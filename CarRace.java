import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.URL;
import java.util.Random;
class CarRace extends JFrame 
{
   int gameoverpause=0;
  JLabel hs,br,br1,br2,br3,car,ec1,ec2,ec3,ec4,go,exp,sm;
  JLabel road = new JLabel();
  int x=355, y=0, y1= 151,y2=y1+151, y3=y2+151,i=310, j= 330,a=0,b1=-100,b2=-100,b3=-100,b4=-100,n;
  boolean gamestarted=false;
  AudioClip [] clips= new AudioClip[5];
  public CarRace()
  {	
	super("Aventador Clash ---Press <ESC> To EXIT !!");
	setSize(720,480);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	ImageIcon icon=new ImageIcon(getClass().getResource("pics/homepage.jpg"));
	ImageIcon bar=new ImageIcon(getClass().getResource("pics/bar.jpg"));
	ImageIcon lambo=new ImageIcon(getClass().getResource("pics/car.png"));
	ImageIcon e1=new ImageIcon(getClass().getResource("pics/enemycar1.png"));
	ImageIcon e2=new ImageIcon(getClass().getResource("pics/enemycar2.png"));
	ImageIcon e3=new ImageIcon(getClass().getResource("pics/enemycar3.png"));
	ImageIcon e4=new ImageIcon(getClass().getResource("pics/enemycar4.png"));
	ImageIcon ex=new ImageIcon(getClass().getResource("pics/explosion.gif"));
	ImageIcon smk=new ImageIcon(getClass().getResource("pics/smoke.gif"));
	br= new JLabel(bar);
	br1=new JLabel(bar);
	br2=new JLabel(bar);
	br3=new JLabel(bar);
	car=new JLabel(lambo);
	ec1=new JLabel(e1);
	ec2=new JLabel(e2);
	ec3=new JLabel(e3);
	ec4=new JLabel(e4);
	exp=new JLabel(ex);
	sm=new JLabel(smk);
	go= new JLabel("Game Over !!");
	go.setOpaque(true);
	go.setBackground(Color.yellow);
	go.setHorizontalAlignment(JLabel.CENTER);
	go.setFont(new Font("Arial",1,20));
	car.setBounds(i,j,60,74);
	hs=new JLabel(icon);
	hs.setOpaque(true);
	hs.setBounds(0,0,720,480);
	add(hs);
	go.setBounds(0,140,720,200);
	road.setBounds(200,0,320,480);
	road.setBackground(Color.black);
	add(go);
	add(sm);
	add(exp);
	add(car);
	add(ec1);
	add(ec2);
	add(ec3);
	add(ec4);
	add(br); 
	add(br1);
	add(br2);
	add(br3);	
	add(road);
	road.setOpaque(true);
	br.setOpaque(true);
	addKeyListener(new KL());
	ra();
	loadFiles();
	clips[0].loop();
	go.setVisible(false);
	setVisible(true);
  }
  class KL extends KeyAdapter	
  {
	
  	public void keyPressed(KeyEvent evt)
	{
		if(evt.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(gameoverpause ==0)
			{	hs.setVisible(false);
				setTitle("Aventador Clash --- Press <ESCAPE>To BACK!!  >>>ENTER TO SPEED UP<<< < P > to Pause");
				new GS().start();
				new FS().start();
				clips[1].play();
				gamestarted=true;
				sm.setBounds(i+30,j+50,44,38);
				return;
			}
			else if(gameoverpause==1)
			{
				return;
			}
		}
		
		if(evt.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			if(!hs.isVisible())
			{
				hs.setVisible(true);
				setTitle("Aventador Clash ---Press <ESC> To EXIT !!");
				return;
			}
		System.exit(0);
		}
		if(evt.getKeyCode()==KeyEvent.VK_P)
		{
			if(gamestarted==true)
			{	
				
				gamestarted=false;
				return;
			}
			else if(gamestarted==false)
			{
				if(gameoverpause==0)
				{
					gamestarted=true;
					return;
				}
			}
		}
		if(evt.getKeyCode()==KeyEvent.VK_LEFT && !gamestarted==false)
		{
			if(i<=260)
			    return;
			i-=45;
			clips[3].play();
			car.setBounds(i,j,60,74);
			sm.setBounds(i+30,j+50,44,38);
		}
		if(evt.getKeyCode()==KeyEvent.VK_RIGHT && !gamestarted==false)
		{
			if(i>=410)
			    return;
			i+=45;
			clips[3].play();
			car.setBounds(i,j,60,74);
			sm.setBounds(i+30,j+50,44,38);
		}
	}
  }
  public void ra()
   {
	Random ra=new Random();
	n=ra.nextInt(4)+1;
   }
   void loadFiles()
  {
  	try
	{
		String [] str={"music.wav", "engine start.wav" , "car.wav", "brakes.wav", "gameover.wav"};
		for(int p=0; p<str.length; p++)
		{
		  clips[p]= Applet.newAudioClip(getClass().getResource("/sound/" + str[p]));
		}
	}catch(Exception ex){}
  }
  class FS extends Thread
  {
  	public void run()
	{
		while(true)
		{
	 	  try
                   	{   
	   		if(gamestarted==true) 
			{
	     			sleep(8);
	     			y+=5;
	     			y1+=5;
	     			y2+=5;
	     			y3+=5;
				br.setBounds(x,y,10,101);
				if(y>= 550)
					y=-101;
	     			br1.setBounds(x,y1,10,101);
				if(y1 >= 550)		
					y1=-101;
	     			br2.setBounds(x,y2,10,101);
				if(y2 >= 550)		
					y2=-101;
	    	 		br3.setBounds(x,y3,10,101);
				if(y3 >= 550)		
					y3=-101;
			}
		}catch(Exception ex){}
		}
	}
  }
  class GS extends Thread
  {
       public void run()
       {
	while(true)
	{
	   try
                   {   
	   	if(gamestarted==true) 
		{
	     		sleep(15);
	     	               if(n==1)
			{
			   clips [2].play();
			   b1+=5;
	     		   if(b1>240 && b1< 398)
		                   {
  			           if(i>= 190 && i<310)
			           {
					exp.setBounds(250,b1+30,71,100);
					gameOver();
				}
	      		   }

	     		    ec1.setBounds(a=250,b1,60,88);
		    	    if(b1>= 480)
			    {
				b1=-89; 
				ra();
			    }
			  }
			if(n==2)
			  { 
			       clips [2].play();
			       b2+=5;    
	     		       if(b2>250 && b2< 398)
	      		       {
  				if(i>= 275 && i<400)
				{
					exp.setBounds(335,b2+30,71,100);
					gameOver();
				}
	      		        } 
	     		        ec2.setBounds(a=335,b2,65,60);
			        if(b2>= 480)
			        {
				b2=-61; 
				ra();
		  	        }
			    }
			if(n==3)
		                 { 
			         clips [2].play();
			         b3+=5;
	    		         if(b3>250 && b3< 398)
	      		         {
  			         	if(i>= 380 && i<470)
				{
					exp.setBounds(410,b3+30,71,100);
					gameOver();
				}
	      		          }
	     		          ec3.setBounds(a=410,b3,60,79);
			          if(b3>= 480)
			          {
				b3=-80; 
				ra();
			           }
			   }
			if(n==4)
			   {
			           clips [2].play(); 
			           b4+=5;
	      		           if(b4>240 && b4< 398)
	      		           {
  				if(i>= 190 && i<310)
				{
					exp.setBounds(250,b4+30,71,100);
					gameOver();
				}
	      		           }
	     		           ec4.setBounds(a=250,b4,60,100);
			           if(b4>= 480)
			           {
				b4=-101; 
				ra();
			            }
			   }
	     		
                  	     }
	}catch(Exception ex){}
         }
     }	
  }
  void gameOver()
  {
	clips[0].stop();
	clips[1].stop();	
	clips[2].stop();
	
	gameoverpause=1;
	try
	{	Thread.sleep(1000);
				
	}catch(Exception ex){}
	clips[4].play();	
	gamestarted=false; 
	go.setVisible(true); 
	setTitle("Game Over !!");
  }
  public static void main(String ...s)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new CarRace();
 }
}