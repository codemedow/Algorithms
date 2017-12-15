import java.io.*;
import java.util.*;
import java.lang.Math;

class Solution {

    public static void main(String[] args)
    {

        int [] a = {4,10,3,1,5};

        int sum = findMaxNonConsequitiveSum(a);
        System.out.println("Answer:" + sum);
    }

   public static int findMaxNonConsequitiveSum(int [] a){
        if(a==null){
            return 0;
        } else if(a.length==1) return a[0];

        int [] arraySum = new int[a.length];
        arraySum[0]= a[0];
        arraySum[1] = Math.max(a[0], a[1]);
        for(int i=2; i < a.length; i++){
            arraySum[i] = Math.max(arraySum[i-1], arraySum[i-2] + a[i]);
        }
        return arraySum[a.length-1];

   }
}

