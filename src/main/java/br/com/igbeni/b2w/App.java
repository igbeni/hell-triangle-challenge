package br.com.igbeni.b2w;

import br.com.igbeni.b2w.model.HellTriangle;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int numberOfRows;
        int[][] triangle;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of rows:");

        numberOfRows = in.nextInt();

        triangle = new int[numberOfRows][];

        for (int row = 0; row < numberOfRows; row++) {
            System.out.printf("Enter the elements of the row number %d:\n", row + 1);

            triangle[row] = new int[row + 1];

            for (int col = 0; col < (row + 1); col++) {
                triangle[row][col] = in.nextInt();
            }
        }

        HellTriangle hellTriangle = new HellTriangle(triangle);
        System.out.println(hellTriangle.getLargestSum());
    }
}
