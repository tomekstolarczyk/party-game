import java.awt.*; //awt to biblioteka do tworzenia GUI
import java.awt.event.*; //eventy do obslugi zdarzen
import java.util.ArrayList; //lista dynamiczna
import java.util.Random; //do losowania kart
import javax.swing.*; //swing do tworzenia GUI

public class Blackjack {

    JFrame frame = new JFrame("Blackjack Game");

    Blackjack() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
