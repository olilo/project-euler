package de.olilo.euler.level3;

import java.util.Arrays;

public enum PokerHand {

    HIGH_CARD,
    ONE_PAIR,
    TWO_PAIRS,
    THREE_OF_A_KIND,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    STRAIGHT_FLUSH,
    ROYAL_FLUSH;

    //public abstract boolean matches(PokerCard[] cards);

    public static PokerHand getPokerHand(PokerCard[] cards) {
        if (cards.length != 5) {
            throw new IllegalArgumentException("Need exactly 5 Cards");
        }

        final PokerCard[] sortedCards = Arrays.copyOf(cards, 5);
        Arrays.sort(sortedCards);

        final PokerCard.Value highestCard = sortedCards[4].getValue();

        if (areSameSuit(sortedCards) && areAscending(sortedCards)) {
            if (highestCard == PokerCard.Value.ACE) {
                return ROYAL_FLUSH;
            } else {
                return STRAIGHT_FLUSH;
            }
        } else if (areFourOfAKind(sortedCards)) {
            return FOUR_OF_A_KIND;
        } else if (areFullHouse(sortedCards)) {
            return FULL_HOUSE;
        } else if (areSameSuit(sortedCards)) {
            return FLUSH;
        } else if (areAscending(sortedCards)) {
            return STRAIGHT;
        } else if (areThreeOfAKind(sortedCards)) {
            return THREE_OF_A_KIND;
        } else if (areTwoPairs(sortedCards)) {
            return TWO_PAIRS;
        } else if (areOnePair(sortedCards)) {
            return ONE_PAIR;
        }

        return HIGH_CARD;
    }

    public static boolean areSameSuit(PokerCard[] cards) {
        final PokerCard.Suit suit = cards[0].getSuit();

        for (PokerCard card : cards) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }

        return true;
    }

    public static boolean areAscending(PokerCard[] cards) {
        PokerCard.Value previousValue = null;
        for (PokerCard card : cards) {
            if (previousValue == null) {
                previousValue = card.getValue();
            } else if (card.getValue().ordinal() != previousValue.ordinal() + 1) {
                return false;
            } else {
                previousValue = card.getValue();
            }
        }

        return true;
    }

    private static boolean areFourOfAKind(PokerCard[] cards) {
        if (cards[1].getValue() == cards[2].getValue() && cards[2].getValue() == cards[3].getValue()) {
            return cards[0].getValue() == cards[1].getValue() || cards[3].getValue() == cards[4].getValue();
        } else {
            return false;
        }
    }

    private static boolean areFullHouse(PokerCard[] cards) {
        if (cards[0].getValue() == cards[1].getValue() && cards[3].getValue() == cards[4].getValue()) {
            return cards[1].getValue() == cards[2].getValue() || cards[2].getValue() == cards[3].getValue();
        } else {
            return false;
        }
    }

    private static boolean areThreeOfAKind(PokerCard[] cards) {
        if (cards[0].getValue() == cards[1].getValue() && cards[1].getValue() == cards[2].getValue()) {
            return true;
        } else if (cards[1].getValue() == cards[2].getValue() && cards[2].getValue() == cards[3].getValue()) {
            return true;
        } else {
            return cards[2].getValue() == cards[3].getValue() && cards[3].getValue() == cards[4].getValue();
        }
    }

    private static boolean areTwoPairs(PokerCard[] cards) {
        if (cards[0].getValue() == cards[1].getValue() && cards[2].getValue() == cards[3].getValue()) {
            return true;
        } else if (cards[0].getValue() == cards[1].getValue() && cards[3].getValue() == cards[4].getValue()) {
            return true;
        } else {
            return cards[1].getValue() == cards[2].getValue() && cards[3].getValue() == cards[4].getValue();
        }
    }

    private static boolean areOnePair(PokerCard[] cards) {
        return cards[0].getValue() == cards[1].getValue() ||
                cards[1].getValue() == cards[2].getValue() ||
                cards[2].getValue() == cards[3].getValue() ||
                cards[3].getValue() == cards[4].getValue();
    }

}
