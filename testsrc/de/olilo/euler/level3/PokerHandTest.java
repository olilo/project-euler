package de.olilo.euler.level3;

import org.junit.Assert;
import org.junit.Test;

public class PokerHandTest {

    @Test
    public void testAreSameSuit() {
        final PokerCard.Suit suit = PokerCard.Suit.CLUBS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.JACK, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.QUEEN, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.KING, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.THREE, suit);

        final boolean expected = true;
        final boolean actual = PokerHand.areSameSuit(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAreNotSameSuit() {
        final PokerCard.Suit suit = PokerCard.Suit.CLUBS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.JACK, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.QUEEN, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.HEARTS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.THREE, suit);

        final boolean expected = false;
        final boolean actual = PokerHand.areSameSuit(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAreAscending() {
        final PokerCard.Suit suit = PokerCard.Suit.CLUBS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.EIGHT, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.TEN, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.JACK, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.QUEEN, suit);

        final boolean expected = true;
        final boolean actual = PokerHand.areAscending(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAreNotAscending() {
        final PokerCard.Suit suit = PokerCard.Suit.CLUBS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.FIVE, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.TEN, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.JACK, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.QUEEN, suit);

        final boolean expected = false;
        final boolean actual = PokerHand.areAscending(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandRoyalFlush() {
        final PokerCard.Suit suit = PokerCard.Suit.CLUBS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.QUEEN, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.JACK, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.TEN, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.KING, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.ACE, suit);

        final PokerHand expected = PokerHand.ROYAL_FLUSH;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandStraightFlush() {
        final PokerCard.Suit suit = PokerCard.Suit.HEARTS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.FIVE, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.SIX, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.SEVEN, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, suit);

        final PokerHand expected = PokerHand.STRAIGHT_FLUSH;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandFourOfAKind() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.FOUR_OF_A_KIND;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandFourOfAKind2() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.FOUR_OF_A_KIND;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandFullHouse() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.FULL_HOUSE;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandFullHouse2() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.SPADES);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.FULL_HOUSE;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandFlush() {
        final PokerCard.Suit suit = PokerCard.Suit.HEARTS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.SEVEN, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.SIX, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.ACE, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, suit);

        final PokerHand expected = PokerHand.FLUSH;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandStraight() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.SIX, PokerCard.Suit.DIAMONDS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.SEVEN, PokerCard.Suit.SPADES);
        final PokerCard card4 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.STRAIGHT;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandThreeOfAKind() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.SIX, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.THREE_OF_A_KIND;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandTwoPairs() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.TWO_PAIRS;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandOnePair() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.ONE_PAIR;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPokerHandHighCard() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.SIX, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.TEN, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerHand expected = PokerHand.HIGH_CARD;
        final PokerHand actual = PokerHand.getPokerHand(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueRoyalFlush() {
        final PokerCard.Suit suit = PokerCard.Suit.CLUBS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.QUEEN, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.JACK, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.TEN, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.KING, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.ACE, suit);

        final PokerCard.Value expected = PokerCard.Value.ACE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueStraightFlush() {
        final PokerCard.Suit suit = PokerCard.Suit.HEARTS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.FIVE, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.SIX, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.NINE, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.SEVEN, suit);

        final PokerCard.Value expected = PokerCard.Value.NINE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueFourOfAKind() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.FIVE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueFourOfAKind2() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.NINE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueFullHouse() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.NINE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueFullHouse2() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.SPADES);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.FIVE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueFlush() {
        final PokerCard.Suit suit = PokerCard.Suit.HEARTS;
        final PokerCard card1 = new PokerCard(PokerCard.Value.SEVEN, suit);
        final PokerCard card2 = new PokerCard(PokerCard.Value.SIX, suit);
        final PokerCard card3 = new PokerCard(PokerCard.Value.ACE, suit);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, suit);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, suit);

        final PokerCard.Value expected = PokerCard.Value.ACE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueStraight() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.SIX, PokerCard.Suit.DIAMONDS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.SEVEN, PokerCard.Suit.SPADES);
        final PokerCard card4 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card5 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.NINE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueThreeOfAKind() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.SIX, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.NINE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueTwoPairs() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.NINE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueTwoPairs2() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.KING;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueOnePair() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.NINE;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueOnePair2() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.TWO, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.NINE, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.TWO, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.TWO;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandValueHighCard() {
        final PokerCard card1 = new PokerCard(PokerCard.Value.SIX, PokerCard.Suit.HEARTS);
        final PokerCard card2 = new PokerCard(PokerCard.Value.TEN, PokerCard.Suit.CLUBS);
        final PokerCard card3 = new PokerCard(PokerCard.Value.QUEEN, PokerCard.Suit.DIAMONDS);
        final PokerCard card4 = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.SPADES);
        final PokerCard card5 = new PokerCard(PokerCard.Value.FIVE, PokerCard.Suit.HEARTS);

        final PokerCard.Value expected = PokerCard.Value.QUEEN;
        final PokerCard.Value actual = PokerHand.getHandValue(new PokerCard[] {card1, card2, card3, card4, card5});
        Assert.assertEquals(expected, actual);
    }

}
