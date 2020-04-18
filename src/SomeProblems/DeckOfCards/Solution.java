package SomeProblems.DeckOfCards;

public class Solution {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.printCards(3);
        deck.shuffleCards();
        deck.printCards(3);
    }
}
