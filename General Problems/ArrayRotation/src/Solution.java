import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int keep=-1;
        for(int i=0; i<k; i++){
            keep = a[0];
            for(int j=1; j<n; j++){
                a[j-1] =a[j]    ;
            }
            a[n-1]= keep;
        }
        return a;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
*/
        int n=5;
        int k=4;
        int a[] = {1,2,3,4,5};
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
