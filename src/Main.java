public class Main {
    public static void main(String[] args) {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Deck deck = new Deck(deck1, deck2);

        deck.shuffle();

        System.out.println(deck);
    }
}
