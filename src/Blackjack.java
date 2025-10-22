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

        public int getValue() {

            if (value == "J" || value == "Q" || value == "K") {
                return 10;
            } else if (value == "A") {
                return 11; //wartosc asa na poczatku
            } else {
                return Integer.parseInt(value);
            }
        }
    }

    int cardWidth = 110;
    int cardHeight = 154;
    Image hiddenCardImage;
    ArrayList<Card> deck;
    ArrayList<Card> dealerHand;
    int dealerHandValue = 0;

    JFrame frame = new JFrame("Blackjack Game");

    //player's hand
    ArrayList<Card> playerHand;
    int playerHandValue = 0;

    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // tutaj rysowanie komponentów gry

            //draw hidden card
            g.drawImage(hiddenCardImage, 20, 20, cardWidth, cardHeight, null);
        }
    };

    Blackjack() {

        buildDeck();
        shuffleDeck();
        drawCards();

        hiddenCardImage = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();

        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(53,101,77));
        frame.add(panel);

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
    
    public void drawCards() {

        // draw cards for the player
        playerHand = new ArrayList<Card>();
        Card drawnCard1 = deck.remove(0);
        playerHand.add(drawnCard1);
        playerHandValue += drawnCard1.getValue();
        Card drawnCard2 = deck.remove(0);
        playerHand.add(drawnCard2);
        playerHandValue += drawnCard2.getValue();
        System.out.println("=============================");
        System.out.println("Drawing cards: ");
        System.out.println("Deck: " + deck);
        System.out.println("Deck size: " + deck.size());
        System.out.println("Player hand: " + playerHand);
        System.out.println("Player hand value: " + playerHandValue);

        //draw cards for the dealer
        dealerHand = new ArrayList<Card>();
        Card dealerCard1 = deck.remove(0);
        dealerHand.add(dealerCard1);
        dealerHandValue += dealerCard1.getValue();
        Card dealerCard2 = deck.remove(0);
        dealerHand.add(dealerCard2);
        dealerHandValue += dealerCard2.getValue();
        System.out.println("=============================");
        System.out.println("Drawing cards: ");
        System.out.println("Deck: " + deck);
        System.out.println("Deck size: " + deck.size());
        System.out.println("Dealer hand: " + dealerHand);
        System.out.println("Dealer hand value: " + dealerHandValue);
    }

}
