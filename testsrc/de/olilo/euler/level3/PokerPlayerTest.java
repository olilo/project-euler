package de.olilo.euler.level3;

import org.junit.Assert;
import org.junit.Test;

public class PokerPlayerTest {

    private static PokerPlayer getPlayer(PokerCard.Value firstCard, PokerCard.Value secondCard) {
        final PokerCard card1 = new PokerCard(firstCard, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(secondCard, PokerCard.Suit.DIAMONDS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.CLUBS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        return new PokerPlayer(new PokerCard[] {card1, card2, card3, card4, card5});
    }

    @Test
    public void testPlayAgainstWinHand() {
        final PokerPlayer player1 = getPlayer(PokerCard.Value.FIVE, PokerCard.Value.FIVE);
        final PokerPlayer player2 = getPlayer(PokerCard.Value.TWO, PokerCard.Value.NINE);

        final boolean expected = true;
        final boolean actual = player1.playAgainst(player2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayAgainstLoseHand() {
        final PokerPlayer player1 = getPlayer(PokerCard.Value.EIGHT, PokerCard.Value.EIGHT);
        final PokerPlayer player2 = getPlayer(PokerCard.Value.FIVE, PokerCard.Value.NINE);

        final boolean expected = false;
        final boolean actual = player1.playAgainst(player2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayAgainstWinValue() {
        final PokerPlayer player1 = getPlayer(PokerCard.Value.KING, PokerCard.Value.KING);
        final PokerPlayer player2 = getPlayer(PokerCard.Value.QUEEN, PokerCard.Value.QUEEN);

        final boolean expected = true;
        final boolean actual = player1.playAgainst(player2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayAgainstLoseValue() {
        final PokerPlayer player1 = getPlayer(PokerCard.Value.QUEEN, PokerCard.Value.QUEEN);
        final PokerPlayer player2 = getPlayer(PokerCard.Value.KING, PokerCard.Value.KING);

        final boolean expected = false;
        final boolean actual = player1.playAgainst(player2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayAgainstWinHighestCard() {
        final PokerPlayer player1 = getPlayer(PokerCard.Value.FIVE, PokerCard.Value.KING);
        final PokerPlayer player2 = getPlayer(PokerCard.Value.FIVE, PokerCard.Value.JACK);

        final boolean expected = true;
        final boolean actual = player1.playAgainst(player2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayAgainstLoseHighestCard() {
        final PokerPlayer player1 = getPlayer(PokerCard.Value.NINE, PokerCard.Value.TEN);
        final PokerPlayer player2 = getPlayer(PokerCard.Value.NINE, PokerCard.Value.ACE);

        final boolean expected = false;
        final boolean actual = player1.playAgainst(player2);
        Assert.assertEquals(expected, actual);
    }

}
