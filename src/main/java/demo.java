import javax.swing.*;
import java.awt.*;
import java.util.Map;


public class demo extends JFrame {
    chessListener d2;
    JButton jButton1;
    JButton jButton2;
public demo(){
    setSize(800,800);
    setResizable(true);
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(demo.EXIT_ON_CLOSE);
    setBackground(new Color(146, 106, 44));
    FlowLayout flowLayout =new FlowLayout(FlowLayout.CENTER,50,50);
    setLayout(flowLayout);
}
    public void paint(Graphics g) {
        int x1 = 0;
        int y1 = 120;
        int x2 = 800;
        int y2 = 120;
        int n1 = 0;
        int m1 = 120;
        int n2 = 0;
        int m2 = 800;
        for (int i = 0; i < 20; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 40;
            y2 += 40;
        }
        for (int i = 0; i < 20; i++) {
            g.drawLine(n1, m1, n2, m2);
            n1 += 40;
            n2 += 40;
        }
       for (Map.Entry<Map<Integer, Integer>, Integer> map : d2.chess.map.entrySet()) {
            Map<Integer, Integer> key = map.getKey();
            Integer value = map.getValue();
            if (value == 1) {
                Color color = Color.black;
                for (Map.Entry<Integer, Integer> m : key.entrySet()) {
                    int x = m.getKey();
                    int y = m.getValue();
                    d2.g.setColor(color);
                    d2.g.fillOval(x, y, 30, 30);
                }
            }
            if (value == 2) {
                Color color = Color.white;
                for (Map.Entry<Integer, Integer> m : key.entrySet()) {
                    int x = m.getKey();
                    int y = m.getValue();
                    d2.g.setColor(color);
                    d2.g.fillOval(x, y, 30, 30);
                }
            }
        }
        jButton1 .requestFocus();
        jButton2.requestFocus();
    }

    public static void main(String[] args) {
       demo d1=new demo();
        d1.d2=new chessListener();
        JPanel jPanel=new JPanel();
        d1.jButton1=new JButton("开始");
         d1.jButton2=new JButton("悔棋");
        jPanel.add(d1.jButton1);
        jPanel.add(d1.jButton2);
       d1.add(jPanel);
        d1.d2.g= d1.getGraphics();
       action action=new action(d1.d2);
       action2 action2=new action2(d1,d1.d2,d1.d2.g);
        d1.jButton1.addActionListener(action);
        d1.jButton2.addActionListener(action2);
       d1.addMouseListener(d1.d2);
   }


}

