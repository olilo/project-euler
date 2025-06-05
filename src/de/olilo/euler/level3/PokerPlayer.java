package de.olilo.euler.level3;

import java.util.Arrays;

public class PokerPlayer {

    private final PokerCard[] cards;
    private final PokerHand hand;
    private final PokerCard.Value handValue;

    public PokerPlayer(PokerCard[] cards) {
        if (cards.length != 5) {
            throw new IllegalArgumentException("Need exactly 5 Cards");
        }

        this.cards = Arrays.copyOf(cards, 5);
        Arrays.sort(this.cards);

        this.hand = PokerHand.getPokerHand(cards);
        this.handValue = PokerHand.getHandValue(cards);
    }

    public boolean playAgainst(PokerPlayer otherPlayer) {
        if (this.hand.compareTo(otherPlayer.hand) > 0) {
            return true;
        } else if (this.hand.compareTo(otherPlayer.hand) < 0) {
            return false;
        } else if (this.handValue.compareTo(otherPlayer.handValue) > 0) {
            return true;
        } else if (this.handValue.compareTo(otherPlayer.handValue) < 0) {
            return false;
        } else {
            for (int i = 4; i >= 0; i--) {
                if (this.cards[i].compareTo(otherPlayer.cards[i]) > 0) {
                    return true;
                } else if (this.cards[i].compareTo(otherPlayer.cards[i]) < 0) {
                    return false;
                }
            }

            // no player wins (should not happen) -> count as 'false' or not won for player 1
            return false;
        }
    }

}
