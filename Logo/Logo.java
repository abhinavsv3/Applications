import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
class Logo extends Frame implements KeyListener
{
	int x,y,xx,xy;
	int maxx,maxy,minx,miny;
	Graphics g;
	String s,msg;
	Color bg,fg,pbg,lineCol;
	Dimension d;
	Label l;
	Logo ()
	{
			x=250;
			y=250;
			s = "A";
			setVisible (true);
			setSize (500,500);
			setLayout (null);
			setResizable(false);
			
			pbg = new Color(240,216,216);
			setBackground (pbg);
			
			bg = new Color(255,255,255);
			fg = new Color(0,0,0);
			lineCol = fg;
			
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
			
			msg = "on";
			l = new Label("Press T to toggle : Pen "+msg+"screen");
			
			
			setTitle ("Logo");
			addWindowListener (new WindowAdapter (){
					public void windowClosing (WindowEvent we)
					{
							System.exit (0);
					}					
			});	
			l.setBounds(20,maxy+5,maxx,20);
			add(l);
			addKeyListener (this);
			
	}
	public void refresh ()
	{
			
			g.drawString(s,x,y);
			g.setColor(lineCol);
			g.drawLine(xx,xy,x,y);
	}
	public void keyPressed (KeyEvent ke)
	{
			
			
			xx=x;
			xy=y;
					if (ke.getKeyCode () == ke.VK_UP)
					{
							g.setColor(bg);
							g.drawString(s,x,y);
							s = "A";
							g.setColor(fg);
							y = (y-5<miny+10)? maxy:y-5;
							if(y == maxy)
							{
								
								xy = maxy;
							}
							refresh ();
					}
					if (ke.getKeyCode () == ke.VK_DOWN)
					{
							g.setColor(bg);
							g.drawString(s,x,y);
							s = " V";
							g.setColor(fg);
							y = (y+5>maxy-10)? miny+10:y+5;
							if(y == miny+10)
							{
								xy = miny+10;
							}
							refresh ();
					}
					if (ke.getKeyCode () == ke.VK_LEFT)
					{
							g.setColor(bg);
							g.drawString(s,x,y);
							s = "<";
							g.setColor(fg);
							x = (x-5<minx+10)? maxx-12:x-5;
							if(x == maxx-12)
							{
								xx = maxx-12;
							}
							refresh ();
					}
					if (ke.getKeyCode () == ke.VK_RIGHT)
					{
							g.setColor(bg);
							g.drawString(s,x,y);
							s = ">";
							g.setColor(fg);
							x = (x+5>maxx-12)? minx+5 :x+5;
							if(x == minx+5)
							{
								xx = minx+5;
								
							}
							refresh ();
					}
					if (ke.getKeyCode () == ke.VK_T)
					{
						if(msg.equals("on"))
						{
							msg="off";
							lineCol = bg;
						}
						else
						{
							msg="on";
							lineCol = fg;
						}
					}
			
	}
	public void keyTyped (KeyEvent ke){}
	public void keyReleased (KeyEvent ke){}
	public static void main (String ar[])
	{
		new Logo ();
	}
	
	
		
}
