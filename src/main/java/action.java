import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class action implements ActionListener {
    chessListener d2;
    public action(chessListener d2){
        this.d2=d2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       d2.chess.isBegin=true;
    }
}
