
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversions {

    private static BigInteger inversions = new BigInteger("0");
    public static void main(String[] args) {

       int [] intArray= readInput("/Users/venkateshsubramanian/Documents/code/courses/Algorithms Coursera -1/Inversions/IntegerArray.txt");
        //int [] intArray= readInput("/Users/venkateshsubramanian/Documents/code/courses/Algorithms Coursera -1/Inversions/IntegerArrayT23_128.txt");
        System.out.println("Input: " +Arrays.toString(intArray));
        System.out.println("------------------------------------------");
        mergeSort(intArray);
        System.out.println("Sorted: " +Arrays.toString(intArray));

        System.out.println("Inversions: " +inversions);
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

    public static void mergeSort(int[] intArray){

        System.out.println("Merging ...");

        int [] mergedArray=null;
        try {
            // Base case is if we have two numbers, we need to compare and order them in ascending
            if(intArray.length<=1) {
                //return intArray as is
                return ;
            } else{

                // Divide array in to Right and left half
                int n= (intArray.length)/2;
                int[] leftArray = copyIntArray(intArray, 0, n-1);
                int[] rightArray = copyIntArray(intArray, n, intArray.length-1);
                mergeSort(leftArray);
                mergeSort(rightArray);
                merge(intArray, leftArray, rightArray);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void merge(int[] orig, int[] leftArray, int[] rightArray) {

        try {
            int i=0;
            int j=0;
            int k=0;


          while(i<leftArray.length && j<rightArray.length ){
                if(leftArray[i] < rightArray[j]){
                    orig[k] = leftArray[i];
                    i++;
                }else{
                    orig[k] = rightArray[j];
                    j++;

                    //Count Inversions - whaterver left in leftArray each time we copy item from Right Array is inversion
                    if(i< leftArray.length) {
                        BigInteger bi = BigInteger.valueOf((leftArray.length -i));
                        inversions = inversions.add(bi);
                    }
                }
                k++;

            }

            //Copy remaining left over in left and right array
            while(i<leftArray.length){
              orig[k++] = leftArray[i++];

            }
            while(j<rightArray.length){
                orig[k++] = rightArray[j++];
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Merged--->: " +Arrays.toString(orig));

    }

    public static int[] copyIntArray(int[] intArray, int begin, int end){
        int[] outArray = new int[end-begin+1];
        int k=0;

        for(int i=begin; i <=end; i++){
           outArray[k++] = intArray[i];
        }
        return outArray;
    }
}
