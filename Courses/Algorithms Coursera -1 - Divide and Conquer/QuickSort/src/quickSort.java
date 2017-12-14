import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class quickSort {


    private static int comparisons =0;
    public static void main(String[] args) {

        int [] intArray= readInput("/Users/vs/Documents/code/courses/Algorithms Coursera -1/QuickSort/QuickSort.txt");
        System.out.println("Input: " + Arrays.toString(intArray));
        System.out.println("------------------------------------------");

        quickSort(intArray, 0, intArray.length-1, "First");
        System.out.println("Sorted, Algo First: " +Arrays.toString(intArray));
        System.out.println("Num of Comparisons: " +comparisons);

        intArray= readInput("/Users/venkateshsubramanian/Documents/code/courses/Algorithms Coursera -1/QuickSort/QuickSort.txt");
        comparisons =0;

        quickSort(intArray, 0, intArray.length-1, "Last");
        System.out.println("Sorted, Algo Last: " +Arrays.toString(intArray));
        System.out.println("Num of Comparisons: " +comparisons);

        intArray= readInput("/Users/venkateshsubramanian/Documents/code/courses/Algorithms Coursera -1/QuickSort/QuickSort.txt");
        comparisons =0;

        quickSort(intArray, 0, intArray.length-1, "Median");
        System.out.println("Sorted, Algo Median: " +Arrays.toString(intArray));
        System.out.println("Num of Comparisons: " +comparisons);
    }

    public static int [] readInput(String fileUrl) {
        BufferedReader in = null;
        int[] intArray = null;
        try {
            in = new BufferedReader(new FileReader(fileUrl));
            String str;

            List<Integer> list = new ArrayList<Integer>();
            while ((str = in.readLine()) != null) {
                list.add(Integer.parseInt(str));
            }

            intArray = new int[list.size()];
            int i = 0;
            for (Integer item : list) {
                intArray[i++] = item;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return intArray;
    }

    public static int partition(int [] intArray, int l, int r, String partAlgo){

        if(intArray==null) return -1;
        int i = l +1;
        int temp=0;

        int pivotIndex=0;

        if(partAlgo.equalsIgnoreCase("First")){
            pivotIndex = l;
        } else if(partAlgo.equalsIgnoreCase("Last")){
            pivotIndex = r;
        } if(partAlgo.equalsIgnoreCase("Median")){
            pivotIndex =medianOfThree(intArray, l, r);
        }
        //swap the pivot with l th item
        temp = intArray[l];
        intArray[l] = intArray[pivotIndex];
        intArray[pivotIndex] = temp;

        for(int j = l+1 ; j<=r; j++) {

            if (intArray[j] < intArray[l]) {
                //swap to end of partition
                temp = intArray[i];
                intArray[i] = intArray[j];
                intArray[j] = temp;

                i++;
            }

        }
        //swap the pivot with i-1 index
        temp = intArray[l];
        intArray[l] = intArray[i-1];
        intArray[i-1] = temp;

        return i-1 ;//pivots location

    }

    public static void quickSort(int [] intArray, int l, int r, String partAlgo){

        if(intArray==null) return ;
        if(l>r) return;
        int p = partition(intArray, l, r, partAlgo);

     //   System.out.println("Pivot Index: " + p + " IntArray: "+  Arrays.toString(intArray) + "l: " + l + " r: " + r);


            comparisons = comparisons +r -l;
            if(p>0)
            quickSort(intArray, l, p-1, partAlgo);

            if(p<intArray.length)
            quickSort(intArray, p + 1, r, partAlgo);


    }

    public static int medianOfThree(int []intArray, int startIndex, int endIndex) {
        int aIndex = startIndex;
        int bIndex = (startIndex + endIndex)/2;
        int cIndex = endIndex;

        int a = intArray[aIndex];
        int b = intArray[bIndex];
        int c = intArray[cIndex];

        if(a > b) {
            if(c > a) {
                return aIndex;
            } else if(c < b) {
                return bIndex;
            } else {
                return cIndex;
            }
        } else {
            if(c < a) {
                return aIndex;
            } else if(c > b) {
                return bIndex;
            } else {
                return cIndex;
            }
        }
    }


}
