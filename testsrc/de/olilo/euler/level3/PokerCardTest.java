package de.olilo.euler.level3;

import org.junit.Assert;
import org.junit.Test;

public class PokerCardTest {

    @Test
    public void testGetByShortVersion() {
        final PokerCard expected = new PokerCard(PokerCard.Value.EIGHT, PokerCard.Suit.DIAMONDS);
        final PokerCard actual = PokerCard.getByShortVersion("8D");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetByShortVersion2() {
        final PokerCard expected = new PokerCard(PokerCard.Value.TEN, PokerCard.Suit.CLUBS);
        final PokerCard actual = PokerCard.getByShortVersion("TC");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetByShortVersion3() {
        final PokerCard expected = new PokerCard(PokerCard.Value.ACE, PokerCard.Suit.HEARTS);
        final PokerCard actual = PokerCard.getByShortVersion("AH");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetByShortVersion4() {
        final PokerCard expected = new PokerCard(PokerCard.Value.KING, PokerCard.Suit.CLUBS);
        final PokerCard actual = PokerCard.getByShortVersion("KC");
        Assert.assertEquals(expected, actual);
    }

}
