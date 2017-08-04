package br.com.igbeni.b2w.model;

import br.com.igbeni.b2w.exception.TriangleException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by iggor on 02/08/2017.
 *
 * Class to test the data structure {@link HellTriangle} using unit tests.
 */
public class HellTriangleTest {
    private int[][] triangle = new int[][]{{6}, {3, 5}, {9, 7, 1}, {4, 6, 8, 4}};
    private int[][] nullTriangle = null;

    @Test
    public final void constructHellTriangle() {
        new HellTriangle(triangle);
    }

    @Test(expected = TriangleException.class)
    public final void constructNullHellTriangle() {
        new HellTriangle(nullTriangle);
    }

    @Test
    public final void getFirstElement() {
        HellTriangle hellTriangle = new HellTriangle(triangle);
        assertEquals(6, hellTriangle.getFirstElement());
    }

    @Test
    public final void getLeftElementNextRow() {
        HellTriangle hellTriangle = new HellTriangle(triangle);
        assertEquals(8, hellTriangle.getLeftElementFromNextRow(2,2));
    }

    @Test
    public final void getRightElementNextRow() {
        HellTriangle hellTriangle = new HellTriangle(triangle);
        assertEquals(4, hellTriangle.getRightElementFromNextRow(2,2));
    }

    @Test
    public final void getBiggestNeighborTest() {
        HellTriangle hellTriangle = new HellTriangle(triangle);
        assertEquals(9, hellTriangle.getTheLargestElementOnNextRow(1,0));
    }

    @Test
    public final void getTriangleLength() {
        HellTriangle hellTriangle = new HellTriangle(triangle);
        assertEquals(4, hellTriangle.getTriangleSize());
    }

    @Test
    public final void getColumnBiggestElementNextRow() {
        HellTriangle hellTriangle = new HellTriangle(triangle);
        assertEquals(2, hellTriangle.getColumnOfTheLargestElementOnNextRow(2,1));
    }

    @Test
    public final void getgetLargestSum() {
        HellTriangle hellTriangle = new HellTriangle(triangle);
        assertEquals(26, hellTriangle.getLargestSum());
    }

    @Test
    public final void getBiggestSumStressTest() {
        int[][] largeTriangle = new int[10000][];

        for(int i = 0; i < largeTriangle.length; i++) {
            largeTriangle[i] = new int[i + 1];

            for(int j = 0; j < (i + 1); j++) {
                largeTriangle[i][j] = (int) (Math.random() * 1000);
            }
        }

        HellTriangle hellTriangle = new HellTriangle(triangle);
        hellTriangle.getLargestSum();
    }
}