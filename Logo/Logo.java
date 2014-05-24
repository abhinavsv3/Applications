import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
class Logo extends Frame implements KeyListener
{
	int x,y;
	int maxx,maxy,minx,miny;
	Graphics g;
	String s;
	Color bg,fg,pbg;
	Dimension d;
	Logo ()
	{
			x=250;
			y=250;
			s = "Hi";
			setVisible (true);
			setSize (500,500);
			setLayout (null);
			setResizable(false);
			
			pbg = new Color(240,216,216);
			setBackground (pbg);
			
			bg = new Color(255,255,255);
			fg = new Color(0,0,0);
			
			d = getSize ();
			minx = 20;
			miny = 50;
			maxx = d.width-40;
			maxy = d.height-100;
			g = getGraphics ();
			g.drawString (s,x,y);
			g.setColor(bg);
			g.fillRect(minx,miny,maxx,maxy);
			maxx += minx;
			maxy += miny;
			g.setColor(fg);
			g.drawString (s,x,y);
			
			setTitle ("Logo");
			addWindowListener (new WindowAdapter (){
					public void windowClosing (WindowEvent we)
					{
							System.exit (0);
					}					
			});
			
			addKeyListener (this);
			
	}
	public void refresh ()
	{
			
			g.drawString(s,x,y);
	}
	public void keyPressed (KeyEvent ke)
	{
			
			
			
					if (ke.getKeyCode () == ke.VK_UP)
					{
							g.setColor(bg);
							g.drawString(s,x,y);
							g.setColor(fg);
							y = (y-5<miny+10)? maxy:y-5;
							refresh ();
					}
					if (ke.getKeyCode () == ke.VK_DOWN)
					{
							g.setColor(bg);
							g.drawString(s,x,y);
							g.setColor(fg);
							y = (y+5>maxy-10)? miny+10:y+5;
							refresh ();
					}
					if (ke.getKeyCode () == ke.VK_LEFT)
					{
							g.setColor(bg);
							g.drawString(s,x,y);
							g.setColor(fg);
							x = (x-5<minx+10)? maxx-12:x-5;
							refresh ();
					}
					if (ke.getKeyCode () == ke.VK_RIGHT)
					{
							g.setColor(bg);
							g.drawString(s,x,y);
							g.setColor(fg);
							 x = (x+5>maxx-12)? minx+5 :x+5;
							refresh ();
					}
					
			
	}
	public void keyTyped (KeyEvent ke){}
	public void keyReleased (KeyEvent ke){}
	public static void main (String ar[])
	{
		new Logo ();
	}
	
	
		
}
