import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;
    public Deck(){
        ArrayList<Card> deck = new ArrayList<>();
        for (int i=1; i < 14; i++){
            Card card1 = new Card("spades", i);
            Card card2 = new Card("hearts", i);
            Card card3 = new Card("diamonds", i);
            Card card4 = new Card("clubs", i);

            deck.add(card1);
            deck.add(card2);
            deck.add(card3);
            deck.add(card4);
        }
        this.deck = deck;
    }
    public Deck(Deck deck1, Deck deck2){
        for (Card card: deck2.getDeck()){
            deck1.addCard(card);
        }
        this.deck = deck1.getDeck();
    }
    public ArrayList<Card> getDeck(){
        return this.deck;
    }

    public void addCard(Card card){
        this.deck.add(card);
    }
    public String toString(){
        String deckString = "";
        for (int i=0; i<deck.size();i++){
            deckString += (deck.get(i)) + "\n";

        }
        return deckString;
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
        Collections.shuffle(this.deck);
    }

    public Card deal(){
        Card card = this.deck.remove(0);
        return card;
    }



}
