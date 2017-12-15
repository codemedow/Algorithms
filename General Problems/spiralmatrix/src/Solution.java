import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        //System.out.print("Enter: row column and then actual values in rows:");
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\D");
        System.out.print("Enter Rows, Columns:");
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        Integer[][] a = new Integer[rows][columns];
        Integer[][] b = new Integer[rows][columns];


        for (int i = 0; i < rows; i++) {
            System.out.print("Enter Row values comma separated:");
            for (int j = 0; j < columns; j++) {

                a[i][j] = sc.nextInt();
            }
        }

        // print spirally

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                System.out.print(a[i][j]);
            }
        }

    }

    public static void printright(int rows, int columns, Integer[][] a, Integer[][] b, int row, int column, int direction) {
        //print right or left
        int startVal=0;
        if(direction==0) startVal=0;
                else startVal= columns;
        for (int j = startVal; j < columns;) {

            if(direction ==0) j++; else j--
            // If not printed print it
            if (b[row][j] != 1) {
                System.out.print(a[row][j]);
                b[row][j] = 1;
            }
        }

        // print down
        for (int k = 0; k < rows; k++) {
            // If not printed print it
            if (b[column][k] != 1) {
                System.out.print(a[column][k]);
                b[column][k] = 1;
            }
        }
    }
}
