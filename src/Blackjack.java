import java.awt.*; //awt to biblioteka do tworzenia GUI
import java.awt.event.*; //eventy do obslugi zdarzen
import java.util.ArrayList; //lista dynamiczna
import java.util.Random; //do losowania kart
import javax.swing.*; //swing do tworzenia GUI

public class Blackjack {

    private class Card {
        
        String value;
        String type;

        Card(String value, String type){
            this.type = type;
            this.value = value;
        }

        public String toString() {
            return value + "-" + type;
        }
    }

    ArrayList<Card> deck;
    JFrame frame = new JFrame("Blackjack Game");

    Blackjack() {

        buildDeck();
        shuffleDeck();

    }

    public void buildDeck() {

        deck = new ArrayList<Card>();
        String[] types = {"H", "D", "C", "S"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String type : types) {
            for (String value : values) {
                deck.add(new Card(value, type));
            }
        }

        System.out.println("============================="); 
        System.out.println("Building Deck: "); 
        System.out.println(deck);
        System.out.println("Deck size: " + deck.size());
    }

    public void shuffleDeck() {

        for (int i = 0; i < deck.size(); i++) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, temp);
        }

        System.out.println("=============================");
        System.out.println("Shuffling Deck: ");
        System.out.println(deck);
        System.out.println("Deck size: " + deck.size());
    }
}
