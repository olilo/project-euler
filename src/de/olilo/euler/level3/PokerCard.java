package de.olilo.euler.level3;

import java.util.Objects;

public class PokerCard implements Comparable<PokerCard> {

    private final Value value;
    private final Suit suit;

    public PokerCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerCard pokerCard = (PokerCard) o;
        return value == pokerCard.value && suit == pokerCard.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    @Override
    public int compareTo(PokerCard o) {
        return value.compareTo(o.getValue());
    }

    public static PokerCard getByShortVersion(String shortVersion) {
        final Value value = Value.getByShortVersion(shortVersion.charAt(0));
        final Suit suit = Suit.getByShortVersion(shortVersion.charAt(1));
        return new PokerCard(value, suit);
    }

    public enum Value {

        TWO('2'),
        THREE('3'),
        FOUR('4'),
        FIVE('5'),
        SIX('6'),
        SEVEN('7'),
        EIGHT('8'),
        NINE('9'),
        TEN('T'),
        JACK('J'),
        QUEEN('Q'),
        KING('K'),
        ACE('A');

        private final char shortVersion;

        Value(char shortVersion) {
            this.shortVersion = shortVersion;
        }

        public char getShortVersion() {
            return shortVersion;
        }

        public static Value getByShortVersion(char shortVersion) {
            for (Value value : Value.values()) {
                if (value.getShortVersion() == shortVersion) {
                    return value;
                }
            }

            throw new IllegalArgumentException("Unknown value " + shortVersion);
        }

    }

    public enum Suit {

        HEARTS('H'),
        DIAMONDS('D'),
        SPADES('S'),
        CLUBS('C');

        private final char shortVersion;

        Suit(char shortVersion) {
            this.shortVersion = shortVersion;
        }

        public char getShortVersion() {
            return shortVersion;
        }

        public static Suit getByShortVersion(char shortVersion) {
            for (Suit suit : Suit.values()) {
                if (suit.getShortVersion() == shortVersion) {
                    return suit;
                }
            }

            throw new IllegalArgumentException("Unknown suit " + shortVersion);
        }

    }

}
