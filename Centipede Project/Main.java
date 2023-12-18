
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Main extends JFrame{
	GamePanel game= new GamePanel();
    Timer myTimer;
    public Main() {
		super("Centipede");
        

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myTimer = new Timer(10, new TickListener());  // trigger every 100 ms
        myTimer.start();
		add(game);
		pack();  // set the size of my Frame exactly big enough to hold the contents
		setVisible(true);
    }
    class TickListener implements ActionListener{
      public void actionPerformed(ActionEvent evt){
       if(game!= null && game.ready){

        game.repaint();
 
       }
      }
 }
    public static void main(String[] arguments) {
		Main frame = new Main();		
    }
}

class GamePanel extends JPanel implements KeyListener, ActionListener{
 //declaring all var
	private int boxx, boxy;            
 private int pwr,pwr1,pwr2,pwr3;
  private Rectangle bullet;
  private int pwrups=1;
  private int spix=100;
  private int spiy=500;
  private int spil;
 
  int d1l;
  int d2l;
 int  d3l;
 
 int min;
      int max;
      int num;
        int ux;
        int ul;
        int point;
       
        int level=0;
        int way=1;
        int con=1;
        
        //movment speed
        int ms=5;
// bullet speed
int bs=5;


 //seeing if my bullet is ready to fire 
  boolean readyTofire = true;
    public boolean ready = true;
    //declaring keys 
	private boolean []keys;
	//all my images
  Timer timer;
  Image back;
  Image L2;
  Image L3;
  Image star;
  Image start;
  Image centpic;
  Image mush;
  Image player;
  Image endgame;
  Image spider;
  Image info;
  Image win;
  
  //array list of alieans how i can remove 1 and not all of them when i shoot
  ArrayList<Centipede>cent;
  ArrayList<Centipede1>cent1;
  ArrayList<Centipede2>cent2;
  ArrayList<Centipede3>cent3;
  ArrayList<De>shrooms;
	
  
  public GamePanel(){
    
    cent = new ArrayList<Centipede>();
    //loop to creat all my cent
    int z=1;
     for(int x=200;x<600;x+=30 ){
       for(int y =10;y<60; y+= 50){
         cent.add(new Centipede(x,y,z));
         
       }
       //intlizing my bullet
       	bullet= new Rectangle(0,0,0,0);
        
         
     
     }
      cent1 = new ArrayList<Centipede1>();
    //loop to creat all my cent
   
     for(int x=200;x<600;x+=30 ){
       for(int y =10;y<60; y+= 50){
         cent1.add(new Centipede1(x,y,z));    
           
       }
     }
cent2 = new ArrayList<Centipede2>();
    //loop to creat all my cent
    
     for(int x=400;x<800;x+=30 ){
       for(int y =60;y<70; y+= 50){
         cent2.add(new Centipede2(x,y,z));    
           
       }
     }
     cent3 = new ArrayList<Centipede3>();
    //loop to creat all my cent
   
     for(int x=0;x<400;x+=30 ){
       for(int y =10;y<60; y+= 50){
         cent3.add(new Centipede3(x,y,z));    
           
       }
     }

// my mushrooms
shrooms = new ArrayList<De>();
  Random rand = new Random(); //instance of random class
  // RNG for my x and y
      int upperbound = 770;
      int  upperbound1 = 200;
      //makes 15 diffrent mushrooms
       for(int i =0; i<15; i++){
      int xran = rand.nextInt(upperbound+50); 
      int yran = rand.nextInt(upperbound1+100);
       shrooms.add(new De(xran,yran+100));
       }
   



		//background pic
		back = new ImageIcon("OuterSpace.jpg").getImage();
    start = new ImageIcon("home.jpg").getImage();
    L2 = new ImageIcon("L2.png").getImage();
    L3 = new ImageIcon("L3.png").getImage();
    centpic = new ImageIcon("cent.jpg").getImage();
    star = new ImageIcon("star.jpg").getImage();
    endgame = new ImageIcon("gameover.jpg").getImage();
    mush = new ImageIcon("mushroom.png").getImage();
    player = new ImageIcon("player.png").getImage();
    spider = new ImageIcon("spi.png").getImage();
    info = new ImageIcon("info.png").getImage();
    win = new ImageIcon("win.jpg").getImage();
		keys = new boolean[KeyEvent.KEY_LAST+1];
    //box is my player u
		boxx = 400;
		boxy = 500;
    //my defences
    //my RNG for my power ups
    int upperbound5 = 775;
		  pwr = rand.nextInt(upperbound5);
      pwr1 = rand.nextInt(upperbound5);
      pwr2 = rand.nextInt(upperbound5);
      pwr3 = rand.nextInt(upperbound5);
      spil=1;
      
    
	  //mushrooms lives lifes
    d1l=3;
   
    //player lives
    // lives=3;
     ux=70;
     ul=1;
     point=0;
		
       //my dimension
		setPreferredSize(new Dimension(800, 600));
		timer = new Timer(10, this);
		timer.start();
		setFocusable(true);
		requestFocus();
		addKeyListener(this);

// power ups location

 

	  }


	public void move(){
    //starts game when enter is pressed
     if(keys[KeyEvent.VK_ENTER]){
      if (level==0){
      level=1;
      }
      //progresses to the next level
      if (level==2){
      level=3;
      }
      //progresses to the next level
      if (level==4){
      level=5;
      }

    }
    //gose to help screen
if(keys[KeyEvent.VK_H]){
level=7;
}
//gose back to home screen 
if (level==7){
  
if(keys[KeyEvent.VK_B]){
level=0;
}
}

//spiders movments
if (level==1 || level==3 || level==5){
if(boxx < spix){  
spix-=0.5;

}
if(boxx > spix){
spix++;


}
if(spiy>=550){
  way=1;
}
if(spiy<=400){
  way=0;
}
if (way==1){
  spiy--;
}
if (way==0){
  spiy++;
}
}
 if (level ==1 && con ==1){
   spil=1;
   con +=1;
 }
if (level ==3 && con ==2){
   spil=2;
   ms=5;
  bs=5;
  pwrups=2;
   con +=1;
 }
 if (level ==5 && con ==3){
   spil=3;
   ms=5;
    bs=5;
    pwrups=3;
   con +=1;
   
 }

  

		if(keys[KeyEvent.VK_LEFT]){
			boxx -= ms;
		}		
    //moving player to right
		if(keys[KeyEvent.VK_RIGHT]){
			boxx += ms;
		}	
    if(keys[KeyEvent.VK_UP]){
			boxy -= ms;
		}		
		if(keys[KeyEvent.VK_DOWN]){
			boxy += ms;
		}
   
    //reseting the players movments
    if	(boxx >= 800){
      boxx = 0;
    }
	 if	(boxx <= -50){
      boxx= 800;
	 }
   if	(boxy >= 600){
      boxy = 410;
    }
	  if	(boxy <=400){
      boxy = 550;
    }

   //fireing my bullet after checking if it is ready to fire
   if(keys[KeyEvent.VK_SPACE]){
      if(bullet==null){
        readyTofire = true;
      } 
      //creating the acctual bullet if it can fire
      if(readyTofire){
        bullet=new Rectangle(boxx+15,boxy,3,5);
      }
    }
    //calling move function
    if (level == 1){
    for(Centipede al : cent){
            al.move(shrooms);
        }
        //the movments of the cent
        for(Centipede al : cent){
            if(al.hitWall() == true){
                for(Centipede a : cent){
                    a.drop();
                }
                Centipede.changeway();
            }
  }
   

  }
  
    if (level == 3){
      
    for(Centipede1 al1 : cent1){
            al1.move(shrooms);
        }
        //the movments of the cent1
        for(Centipede1 al1 : cent1){
            if(al1.hitWall() == true){
                for(Centipede1 a : cent1){
                    a.drop();
                }
                Centipede.changeway();
            }
  }
   // }

  }
  if (level == 5){
      
    for(Centipede2 al2 : cent2){
            al2.move(shrooms);
        }
        //the movments of the cent1
        for(Centipede2 al2 : cent2){
            if(al2.hitWall() == true){
                for(Centipede2 a : cent2){
                    a.drop();
                }
                Centipede.changeway();
            }
  }
  for(Centipede3 al3 : cent3){
            al3.move(shrooms);
        }
        //the movments of the cent1
        for(Centipede3 al3 : cent3){
            if(al3.hitWall() == true){
                for(Centipede3 a : cent3){
                    a.drop();
                }
                Centipede.changeway();
            }
  }
   

  }
  }

  public void shoot(){
    //if bullet is fired this makes it travle up wards 
    if(bullet!=null)
    bullet.y -=bs;
  }
	@Override
  //stating my methods
	public void actionPerformed(ActionEvent e){
		move();
		repaint();
 shoot();
 
	}
	
	@Override
	public void keyReleased(KeyEvent ke){
		int key = ke.getKeyCode();
		keys[key] = false;
    //resting mybullet when it reaches -5 and maing ready to fire true
	if(key == KeyEvent.VK_SPACE){
      readyTofire= false;
      if(bullet.y <= -5){
        
        readyTofire=true;
      }

  }	
	}
	
	@Override
	public void keyPressed(KeyEvent ke){
		int key = ke.getKeyCode();
		keys[key] = true;
	}
 
	
	@Override
	public void keyTyped(KeyEvent ke){}
  

	@Override
	public void paint(Graphics g){
  
  if (level==0){
  
      g.drawImage(start,0,0,this);
    
      
  }
  

if (level !=0){
 // My backGround
 g.drawImage(back,0,0,this);
		
   
// acctual player   
Rectangle r1 = new Rectangle(boxx,boxy,30,30);
  
    
//just displaying my player
  g.drawImage(player,boxx,boxy,this);
    
//drawing my Centipede and checking if they get to my player
  if(level==1){
    //spider drawing
    if(spil != 0){
    Rectangle spi = new Rectangle(spix,spiy,20,20);
     g.drawImage(spider,spix,spiy,this);
     
     //if spider intercects the player
      if (r1.intersects(spi)){
    
     level=10;
      }
      //if the bullet hits the spider
      if (spi.intersects(bullet)){
        spil-=1;
        bullet.y=-5;
        
        //so there is a delay when the spider is hit to when he respawns
        spix=-100;
    }
    }
    
     //power ups
    Rectangle pwrL = new Rectangle(pwr,100,20,20);
     if(pwrups==1){
   g.drawImage(star,pwrL.x,pwrL.y,this);
     }
    if (pwrL.intersects(bullet)){
      ms+=5;
      bullet.y=-5;
      bs+=5;
      pwrups+=1;
    }
             
     // drawing my centiped       
  for(Centipede al:cent){
    al.draw(g);
    //checks if the alien got to the player
    if(al.contains(r1.x,r1.y)){
    level =10;
    }
    } 
  }
if(level==3){
  //spider drawing
    if(spil != 0){
    Rectangle spi = new Rectangle(spix,spiy,20,20);
     g.drawImage(spider,spix,spiy,this);
     
     //if spider intercects the player
      if (r1.intersects(spi)){
    
     level=10;
      }
      //if the bullet hits the spider
      if (spi.intersects(bullet)){
        spil-=1;
        bullet.y=-5;
        
        //so there is a delay when the spider is hit to when he respawns
        spix=-100;
    }
    }
     //power ups
 
  Rectangle pwrL1 = new Rectangle(pwr1,100,20,20);
     if(pwrups==2){
    // g.setColor(Color.BLUE);
   //g.fillRect(pwrL1.x,pwrL1.y,pwrL1.width,pwrL1.height);
    g.drawImage(star,pwrL1.x,pwrL1.y,this);
     }
     // if the player hits the power up it gives the player enhanced movment speed and 
     //bullet speed
    if (pwrL1.intersects(bullet)){
      ms+=7;
      bs+=7;
      bullet.y=-5;
      pwrups+=1;
    }
    // drawing my centiped
 for(Centipede1 al1:cent1){
    al1.draw(g);
    //checks if the alien got to the player
    if(al1.contains(r1.x,r1.y)){
    level =10;
    }
   
}
}
if(level==5){
//spider drawing
    if(spil != 0){
    Rectangle spi = new Rectangle(spix,spiy,20,20);
     g.drawImage(spider,spix,spiy,this);
     
     //if spider intercects the player
      if (r1.intersects(spi)){
    
     level=10;
      }
      //if the bullet hits the spider
      if (spi.intersects(bullet)){
        spil-=1;
        bullet.y=-5;
        
        //so there is a delay when the spider is hit to when he respawns
        spix=-100;
    }
    }
    


//power ups
  Rectangle pwrL2 = new Rectangle(pwr2,100,20,20);
  Rectangle pwrL3 = new Rectangle(pwr3,100,20,20);
     //pwr ups
     if(pwrups==3){
    g.drawImage(star,pwrL2.x,pwrL2.y,this);
     }
      // if the player hits the power up it gives the player enhanced movment speed
    if (pwrL2.intersects(bullet)){
      ms+=10;
      pwrups+=1;
      bullet.y=-5;
    
    }
    if(pwrups==4){
     g.setColor(Color.BLUE);
   g.fillRect(pwrL3.x,pwrL3.y,pwrL3.width,pwrL3.height);
    g.drawImage(star,pwrL3.x,pwrL3.y,this);
     }
     // if the player hits the power up it gives the player faster bullets  
     
    if (pwrL3.intersects(bullet)){
      bs+=10;
      bullet.y=-5;
      pwrups+=1;
    }


  //if my level two  spider hits the player and drawing the centiped
 for(Centipede2 al2:cent2){
    al2.draw(g);
    if(al2.contains(r1.x,r1.y)){
    level =10;
    }
   
}
//if my level three  spider hits the player and drawing the centiped
for(Centipede3 al3:cent3){
    al3.draw(g);
    if(al3.contains(r1.x,r1.y)){
    level =10;
    }
   
}
}
  
// drawing shrooms
for(De Mu : shrooms){
    Mu.draw(g);
   // g.drawImage(mush,xran,yran,this);
   if(Mu.contains(bullet.x,bullet.y)){
      bullet.y = -5;
      shrooms.remove(Mu);
   
}
  
}
   if (level==1){
     // checks if bullets hits the centipede and removes it if it dose
   for(Centipede al:cent){
   if(al.contains(bullet.x,bullet.y)){
      bullet.y = -5;
      cent.remove(al);
   }
    if( cent.size() == 0 ){
    level+=1;
   }
   }
   }
   // checks if bullets hits the centipede and removes it if it dose
    if (level==3){
   for(Centipede1 al1:cent1){
   if(al1.contains(bullet.x,bullet.y)){
      bullet.y = -5;
      cent1.remove(al1);

   }
  

   }
   // moves on to the next level if you completed the current level
   if( cent1.size() == 0 ){
    level+=1;

   }
   }
   // checks if bullets hits the centipede and removes it if it dose
   if (level==5){
   for(Centipede2 al2:cent2){
   if(al2.contains(bullet.x,bullet.y)){
      bullet.y = -5;
      cent2.remove(al2);
      point+=25;
   }
   }
   // checks if bullets hits the centipede and removes it if it dose
   for(Centipede3 al3:cent3){
   if(al3.contains(bullet.x,bullet.y)){
      bullet.y = -5;
      cent3.remove(al3);
      point+=25;
   }
   }
      // moves on to the next level if you completed the current level

   if(cent3.size() == 0 && cent2.size() == 0){
    level+=1;

   }
   }
    
//displays my info screen
          
if(level==7){
 g.drawImage(info,0,0,this);
}

    // drawing bullet
    if (bullet!=null){
    g.setColor(Color.RED);
    g.fillRect(bullet.x,bullet.y,bullet.width,bullet.height);
  
  }
  // my level two screen 
  if (level==2){
 
      g.drawImage(L2,0,0,this);
  
  }
   // my level three screen 
  if (level==4){
 
      g.drawImage(L3,0,0,this);
  
  }
  //gamr over screen
   if (level == 10){
   g.drawImage(endgame,0,0,this);
  }
  // if player wins diplays my win screen
    if (level == 6){
   g.drawImage(win,0,0,this);
  }
  
 }
    
  }
}





