import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BlackJackGame {
    private Deck deck;
    private ArrayList<Card> playersHand = new ArrayList<>();
    private ArrayList<Card> dealersHand = new ArrayList<>();
    public BlackJackGame() throws InterruptedException {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Deck deck3 = new Deck(deck1, deck2);
        deck3.shuffle();
        this.deck=deck3;

        System.out.println("Let's Play Black Jack");

        playersHand.add(deck.deal());
        dealersHand.add(deck.deal());
        playersHand.add(deck.deal());
        dealersHand.add(deck.deal());

        System.out.println("Dealers Hand: ");

        if (getCardValue(dealersHand.get(0)) + getCardValue(dealersHand.get(1)) == 21 ){
            System.out.println("\t"+dealersHand.get(0)+ " and "+ dealersHand.get(1));
            System.out.println("\tDealer has Black Jack!");
        } else {
            System.out.println("\t"+dealersHand.get(0) + " and ?");
        }

        System.out.println("Your Hand: ");

        System.out.println("\t"+playersHand.get(0));
        try {
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException e){
            System.out.println("Error with timer");
        }
        System.out.println("\t"+playersHand.get(1));
        if (getCardValue(playersHand.get(0)) + getCardValue(playersHand.get(1)) == 21 ) {
            System.out.println("\tYou have Black Jack!");
        }

    }

    private int getCardValue(Card card){
        int number = card.getNumber();
        if (number > 10){
            number = 10;
        } else if (number == 1){
            number = 11;
        }
        return number;
    }


}
