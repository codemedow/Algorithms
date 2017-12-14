import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {


     static int inversions=0;
    public static void main(String[] args) {

        int [] numbers = new int[] {6,5,4,3,2,1};
        /*int [] numbers = new int[10];

        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            // numbers[i] = generator.nextInt(10);
            numbers[i] = 10-i;
        }*/

        printArray(numbers);
        mergeSort(numbers);

        printArray(numbers);
        System.out.println("Number of Inversions: " + inversions);
    }

    public static void printArray(int [] a){
        for(int i = 0; i<a.length; i++)
        {
            System.out.print(a[i]+ " ");
        }
        System.out.println("");
    }

    // Merge sort
    // Divide the array in to half and and divide the resulting to half and so on until it results in one element each
    // merge them sorted in a new list

    public static void mergeSort(int [] nums){

        System.out.println("---------------");
        System.out.println("mergeSort Call Input: ");
        printArray(nums);
        System.out.println("---------------");

        if(nums.length<=1)
        {
            //Already sorted if length is 1
            // No need to sort if length is <1
            return;
        }

        int middle = (nums.length)/2;

        int[] l =extract(nums, 0, middle-1);
        int [] r = extract(nums, middle, nums.length-1);

        System.out.println("left: BeginIndex=" + 0 + " EndIndex=" + middle);
        printArray(l);

        System.out.println("right: BeginIndex=" + (middle) + " EndIndex=" + (nums.length-1));
        printArray(r);

        mergeSort(l);
        mergeSort(r);
        merge(nums, l, r);

    }

    public static int[] extract(int [] a, int low, int high)
    {
        int[] newA = new int[high-low+1];

        for(int i=low, j=0; i <=high; i++, j++){
            newA[j]= a[i];
        }
        return newA;
    }

    public static int[] merge(int[] orig, int [] l, int[] r)
    {
        //int[] orig = new int[l.length + r.length];

        System.out.println("Merging");

        int i=0, j=0, k=0;
        while(i<l.length && j <r.length)
        {
            if(l[i]<r[j]){
                orig[k] = l[i];
                i++;

            } else  if(r[j]<l[i]){
                orig[k] = r[j];
                j++;

                //Copying from right array
                //Inversion needs to be incremented by number or elements left in  array i
                if(i< l.length)
                    inversions = inversions + l.length-i;
            }
            k++;
        }

        // Copy remaining elements of l and r left from last index when prev while loop exited

        while (i<l.length)
        {
            orig[k] = l[i];
            i++;
            k++;
        }

        while (j<r.length)
        {
            orig[k] = r[j];
            j++;
            k++;

        }

        return orig;
    }
}
