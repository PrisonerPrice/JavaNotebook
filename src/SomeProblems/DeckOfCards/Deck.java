package SomeProblems.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>(52);
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Face f : Card.Face.values()) {
                deck.add(new Card(s, f));
            }
        }
        Collections.shuffle(deck);
    }

    public Card getCard(int id) {
        if (id < 0 || id > 51) throw new IllegalArgumentException();
        return deck.get(id);
    }

    public List<Card> getCards(int player) {
        // the deck will be divided into four equal parts
        // player = 0, 1, 2, 3
        int initId = player * 13;
        List<Card> cards = new ArrayList<>(13);
        for(int i = 0; i < 13; i++) {
            cards.add(deck.get(initId + i));
        }
        return cards;
    }

    public void printCards(int player) {
        // the deck will be divided into four equal parts
        // player = 0, 1, 2, 3
        int initId = player * 13;
        System.out.println("Player " + player + "'s cards are:");
        for(int i = 0; i < 13; i++) {
            System.out.println(deck.get(initId + i).toString());
        }
    }

    public void shuffleCards() {
        Collections.shuffle(deck);
    }

    public static class Card {
        public enum Face {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
        public enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS};

        private Face face;
        private Suit suit;

        public Card(Suit suit, Face face) {
            this.face = face;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "face=" + face +
                    ", suit=" + suit +
                    '}';
        }
    }
}
