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


class De{
    private int x, y;
 
 public Rectangle getRect(){
      return new Rectangle (x,y,20,20);
    }
    
    public De(int xx, int yy){
        x=xx;
        y=yy;
        
    }


public void draw(Graphics g){
  //draws my mushrooms
    Rectangle mush= new Rectangle(x,y,20,20);
    g.setColor(Color.GREEN);
		g.fillRect(mush.x,mush.y,mush.width,mush.height);

       
  }


	
public boolean contains(int xx, int yy){
        return xx>x && xx < x+35 && yy > y && yy < y+35;
    }

}