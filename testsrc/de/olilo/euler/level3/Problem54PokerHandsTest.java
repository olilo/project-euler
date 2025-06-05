package de.olilo.euler.level3;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Problem54PokerHandsTest {

    @Test
    public void testReadCards() throws IOException {
        final String input = "QD AD AH KH 9D JS 9H JC KD JD";

        final PokerCard[] expected = new PokerCard[10];
        expected[0] = new PokerCard(PokerCard.Value.QUEEN, PokerCard.Suit.DIAMONDS);
        expected[1] = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.DIAMONDS);
        expected[2] = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.HEARTS);
        expected[3] = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.HEARTS);
        expected[4] = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.DIAMONDS);
        expected[5] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.SPADES);
        expected[6] = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        expected[7] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.CLUBS);
        expected[8] = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.DIAMONDS);
        expected[9] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.DIAMONDS);

        final PokerCard[] actual = new Problem54PokerHands().readCards(new StringReader(input)).get(0);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testPlayGame() throws IOException {
        final PokerCard[] cards = new PokerCard[10];
        cards[0] = new PokerCard(PokerCard.Value.QUEEN, PokerCard.Suit.DIAMONDS);
        cards[1] = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.DIAMONDS);
        cards[2] = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.HEARTS);
        cards[3] = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.HEARTS);
        cards[4] = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.DIAMONDS);
        cards[5] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.SPADES);
        cards[6] = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        cards[7] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.CLUBS);
        cards[8] = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.DIAMONDS);
        cards[9] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.DIAMONDS);

        final boolean expected = false;
        final boolean actual = new Problem54PokerHands().playGame(cards);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayGame2() throws IOException {
        final PokerCard[] cards = new PokerCard[10];
        cards[0] = new PokerCard(PokerCard.Value.QUEEN, PokerCard.Suit.DIAMONDS);
        cards[1] = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.DIAMONDS);
        cards[2] = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.HEARTS);
        cards[3] = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.HEARTS);
        cards[4] = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.DIAMONDS);
        cards[5] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.SPADES);
        cards[6] = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        cards[7] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.CLUBS);
        cards[8] = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.DIAMONDS);
        cards[9] = new PokerCard(PokerCard.Value.JACK, PokerCard.Suit.DIAMONDS);

        final boolean expected = true;
        final boolean actual = new Problem54PokerHands().playGame(cards);
        Assert.assertEquals(expected, actual);
    }

}
