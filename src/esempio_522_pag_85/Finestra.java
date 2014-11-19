package esempio_522_pag_85;
import javax.swing.*;
import java.awt.*;
/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per generare una GUI con due bottoni non agganciati ad eventi
 */

class TwoButtonFrame extends JFrame{
    /**
     * Costruttore del frame
     * @param s stringa necessaria a settare la label del frame
     */
    public TwoButtonFrame(String s){
        super(s);
        setSize(400,200);
        setLayout(new FlowLayout());

        JButton b1 = new JButton("Schiaccia");
        JButton b2 = new JButton("Pigia");

        b1.setBackground(Color.yellow);
        b2.setBackground(Color.blue);
        add(b1);
        add(b2);

    }
}

public class Finestra {
    public static void main( String[] argv ){
        TwoButtonFrame f = new TwoButtonFrame("Prova Button");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
