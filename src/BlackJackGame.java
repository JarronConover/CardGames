import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGame {
    private Deck deck;
    private Boolean gameOver = false;
    private ArrayList<Card> playersHand = new ArrayList<>();
    private ArrayList<Card> dealersHand = new ArrayList<>();
    public BlackJackGame(){
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Deck deck3 = new Deck(deck1, deck2);
        deck3.shuffle();
        this.deck=deck3;

        System.out.println("Let's Play Black Jack!");

        playersHand.add(deck.deal());
        dealersHand.add(deck.deal());
        playersHand.add(deck.deal());
        dealersHand.add(deck.deal());

        displayDealerHand();
        displayPlayerHand();

        isWinner();

        action();

        isWinner();

        //fix is winner and make sure to get the aces right
        //then start on the simulation


    }

    private void displayPlayerHand(){
        String display = "Your Hand: ";
        for (Card card : playersHand){
            display += "\n\t" + card;
        }
        System.out.println(display);
    }

    private void displayDealerHand(){
        System.out.println("Dealers Hand: ");

        if (getCardValue(dealersHand.get(0)) + getCardValue(dealersHand.get(1)) == 21 ){
            System.out.println("\t"+dealersHand.get(0)+ "\n\t"+dealersHand.get(1));
            System.out.println("\tDealer has Black Jack!");
        } else {
            System.out.println("\t"+dealersHand.get(0) + "\n\t????");
        }
    }
    private int isWinner(){
        if (gameOver){
            int playerTotal = 0;
            for (Card card : dealersHand){

            }
            for (Card card : playersHand){


            }
            int dealerTotal = 0;

            return 0; // 1 if player wins
        }
        return -1;
    }

    private void action(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select your move");
        System.out.println("\t(1) Hit");
        System.out.println("\t(2) Stay");
        System.out.println("\t(3) Double Down");
        System.out.println("\t(4) Split");

        int selection = scanner.nextInt();

        if (selection==1){
            hit();
        } else if (selection==2){
            stay();
        } else if (selection==3){
            doubleDown();
        } else if (selection==4){
            split();
        } else {
            System.out.println("Please type the number of the desired action");
            action();
        }
    }

    private void hit(){
        playersHand.add(deck.deal());
        displayPlayerHand();
        bust();
        if (!gameOver){
            action();
        }
    }

    private void stay(){
        gameOver = true;

    }

    private void doubleDown(){
        playersHand.add(deck.deal());
        gameOver = true;

    }

    private void split(){
        if (playersHand.size() > 2){
            System.out.println("Can not split, choose another action");
            action();
        }

    }

    private boolean bust(){
        if (21>21){
            gameOver = true;
            return true;
        }
        return false;

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
