package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import static de.olilo.euler.level1.Problem9PythagoreanTriplet.*;

public class Problem9PythagoreanTripletTest {

    @Test
    public void testFindPythagoreanTriplet() throws Exception {
        final Triplet expected = new Triplet(3, 4, 5);
        final Triplet actual = new Problem9PythagoreanTriplet().findPythagoreanTriplet(12);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindPythagoreanTriplet40() throws Exception {
        final Triplet expected = new Triplet(8, 15, 17);
        final Triplet actual = new Problem9PythagoreanTriplet().findPythagoreanTriplet(40);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindPythagoreanTriplet70() throws Exception {
        final Triplet expected = new Triplet(20, 21, 29);
        final Triplet actual = new Problem9PythagoreanTriplet().findPythagoreanTriplet(70);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindPythagoreanTriplet71() throws Exception {
        new Problem9PythagoreanTriplet().findPythagoreanTriplet(71);
    }

    @Test
    public void testTripletToString() throws Exception {
        final Triplet triplet = new Triplet(3, 4, 5);
        System.out.println(triplet.toString());
    }

    @Test
    public void testTripletEquals() throws Exception {
        final Triplet t1 = new Triplet(3, 4, 5);
        final Triplet t2 = new Triplet(3, 4, 5);
        Assert.assertTrue(t1.equals(t2));
    }

    @Test
    public void testTripletHashcode() throws Exception {
        final Triplet t1 = new Triplet(3, 4, 5);
        final Triplet t2 = new Triplet(3, 4, 5);
        Assert.assertEquals(t1.hashCode(), t2.hashCode());
    }

}
