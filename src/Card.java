import java.util.Random;

public class Card {
    private String suit;
    private int number;

    public Card() {
        Random random = new Random();
        int randomSuit = random.nextInt(4);
        int randomNumber = random.nextInt(12);
        if (randomSuit == 0) {
            this.suit = "spades";
        } else if (randomSuit == 1) {
            this.suit = "hearts";
        } else if (randomSuit == 2) {
            this.suit = "diamonds";
        } else {
            this.suit = "clubs";
        }
        this.number = randomNumber + 1;
    }

    public Card(String suit, int number){
        this.suit = suit;
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public String toString() {
        String number = "" + this.number;
        if (this.number == 1){
            number = "ace";
        } else if (this.number==11){
            number = "jack";
        }else if (this.number==12){
            number = "queen";
        }else if (this.number==13){number = "king";}
        return "The "+ number + " of "+this.suit;
    }
}