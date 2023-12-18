import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;




class Centipede{
    private int x, y,level;
    private static int way;
    Image centpic;
  
     
    
    public Centipede(int xx, int yy, int d){
        x=xx;
        y=yy;
        way=d;
       // l=level;
    }
public Rectangle getRect(){
    //using rect so i can still track intercets
    
    return new Rectangle(x,y,20,20);
  }
    
    public void move(ArrayList<De> shrooms){
          x += way;
          //offseting by 15 to make it look right
    
          if(x==785){
              y += 5;
              way *= -1;
          }

        
          else if(x == 0){
              y += 5;
            way *= -1;
            
          }
          
         if(y>=600){
             reset();
          }
          //checks if aliean hits mushrooms
          for(De mush: shrooms){
            if (mush.getRect().intersects(getRect())){
              hitshroom();
            }
          }

    }
  
  public void draw(Graphics g){
    //if (level==1){
    Rectangle alie= new Rectangle(x,y,20,20);
    g.setColor(Color.GREEN);
		g.fillRect(alie.x,alie.y,alie.width,alie.height);
    //g.drawImage(centpic,x,y,this);
    }
       
  //}
  
  
	
public boolean contains(int xx, int yy){
        return xx>x && xx < x+35 && yy > y && yy < y+35;
    }
//when hits the wall
    public boolean hitWall(){
        return x == 785 ||  x == 10;
    }
 
    public void drop(){
        y += 10;
    }
    public void hitshroom(){
changeway();
  drop();
  way *= -1;
//drop();
    }
    public static void changeway(){
       
    }
    public void reset(){
      x=0;
      y=0;
    }
}