import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class action2 implements ActionListener {
    chessListener demo2;
    demo demo;
    Graphics graphics;
    public action2(demo demo, chessListener demo2, Graphics graphics){
        this.demo=demo;
        this.demo2=demo2;
        this.graphics=graphics;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!demo2.stack.empty()){
            HashMap value = demo2.stack.peek();
            demo2.chess.map.remove(value);
            demo2.stack.pop();
            if(demo2.key==1){
                demo2.key=2;
            }
            else {
                demo2.key=1;
            }
            demo.paintAll(graphics);
        }
    }
}
