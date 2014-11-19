package esempio_521_pag_85;
import javax.swing.*;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per generare una GUI con un solo frame
 */


class MyFrame extends JFrame{
    public MyFrame( String s ){
        super(s);
        setSize(400,400);
    }
}

public class Finestra {
    public static void main (String[] argv){
        MyFrame f = new MyFrame("Prova");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
