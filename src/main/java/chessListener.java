import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Stack;


public class chessListener implements MouseListener {
    Chess chess =new Chess();
    Graphics g;
    int key=1;
   HashMap<Integer, Integer> LastKey=new HashMap<Integer, Integer>();
    Stack<HashMap> stack=new Stack<HashMap>();

    public void mouseClicked(MouseEvent e) {
        if (chess.isBegin==false){
           return;
        }
        int x=e.getX();
        int y=e.getY();
        if(x%40<20){
            x-=x%40+10;
        }
        if(y%40<20){
            y-=y%40+10;
        }
        if(x%40>20){
            x+=40-x%40-10;
        }
        if(y%40>20){
            y+=40-y%40-10;
        }
          HashMap<Integer, Integer> map=new HashMap();
          map.put(x,y);
          if(!chess.map.containsKey(map))
          {
             if(y<100){
                 return;
             }
              if(key==1){
                  g.setColor(Color.black);
                  g.fillOval(x,y,30,30);
                  chess.map.put(map,key);

                  if(chess.isWin(x,y,key)){
                      JOptionPane.showMessageDialog(null,"Black is win");
                      chess.isBegin=false;
                  }
                  LastKey=map;
                  stack.push(map);
                  key=2;
              }
              else {
                  g.setColor(Color.white);
                  g.fillOval(x,y,30,30);
                  chess.map.put(map,key);

                  if( chess.isWin(x,y,key)){
                      JOptionPane.showMessageDialog(null,"white is win");
                      chess.isBegin=false;
                  }
                  LastKey=map;
                  stack.push(map);
                  key=1;
              }

          }

        }



    public void mousePressed(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }
}
