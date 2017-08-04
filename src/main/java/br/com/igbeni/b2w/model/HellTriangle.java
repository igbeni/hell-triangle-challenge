package br.com.igbeni.b2w.model;

import br.com.igbeni.b2w.exception.TriangleException;

/**
 * Created by iggor on 02/08/2017.
 *
 * Data structure representing the triangle and implementing important functions.
 */
public class HellTriangle {
    private int[][] triangle;

    /**
     * @param triangle An array of integers representing the triangle.
     */
    public HellTriangle(int[][] triangle) {
        if (triangle == null) {
            throw new TriangleException();
        }
        this.triangle = triangle;
    }

    /**
     * Function to get an element from its row and column.
     * @param row element row.
     * @param col element column.
     * @return The element.
     */
    private int getElement(final int row, final int col) {
        return triangle[row][col];
    }

    /**
     * @return The first element of the triangle.
     */
    int getFirstElement() {
        return getElement(0, 0);
    }

    /**
     * Function to get the element on the left on the next row.
     * @param row element row.
     * @param col element column.
     * @return The left element.
     */
    int getLeftElementFromNextRow(final int row, final int col) {
        return getElement(row + 1, col);
    }

    /**
     * Function to get the element on the right on the next row.
     * @param row element row.
     * @param col element column.
     * @return The right element.
     */
    int getRightElementFromNextRow(final int row, final int col) {
        return getElement(row + 1, col + 1);
    }

    /**
     * Function that compares the left and right elements on the next row and returns the largest of them.
     * @param row element row.
     * @param col element column.
     * @return The largest element.
     */
    int getTheLargestElementOnNextRow(final int row, final int col) {
        return Math.max(getLeftElementFromNextRow(row, col), getRightElementFromNextRow(row, col));
    }

    /**
     * @return The triangle's size.
     */
    int getTriangleSize() {
        return triangle.length;
    }

    /**
     * Function to get the column of the largest element on the next row.
     * @param row element row.
     * @param col element column.
     * @return The column of the largest element.
     */
    int getColumnOfTheLargestElementOnNextRow(final int row, final int col) {
        if (getLeftElementFromNextRow(row, col) > getRightElementFromNextRow(row, col)) {
            return col;
        } else {
            return col + 1;
        }
    }

    /**
     * @return Function to get the largest sum of the triangle elements, starting by the first element.
     */
    public final long getLargestSum() {
        long sum = getFirstElement();
        int col = 0;

        for (int row = 0; row < getTriangleSize() - 1; row++) {
            sum += getTheLargestElementOnNextRow(row, col);
            col = getColumnOfTheLargestElementOnNextRow(row, col);
        }

        return sum;
    }
}
