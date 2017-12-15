import java.util.ArrayList;

import static java.lang.Math.abs;

/*
Write an algorithm to determine if a number is "happy".

        A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

*/
public class Main {

  static ArrayList al = new ArrayList();

    public static boolean isHappy(int n) {

        try {
            int ans=0;

            ans = sumOfSquareOfDigits(n);


            if(ans==1) {
                al.clear();
                return true;

            }
            else {
                if(al.contains(ans) ||  al.size()>100) {
                    al.clear();
                    return false; //infinite loop
                }
                else {
                    al.add(ans);
                    return isHappy(ans);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            al.clear();
            return false;
        }

    }

    private static int sumOfSquareOfDigits(int n) {

        String stringVal = Integer.toString(abs(n));
        char [] charNum = stringVal.toCharArray();
        int sum=0;
        int val=0;
        for (int i = 0 ; i<charNum.length ; i++){
            val =Character.getNumericValue(charNum[i]);
            sum = sum + val* val;
        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println("13: " + "Answer: " + Main.isHappy(13));

        System.out.println("19: " + "Answer: " + Main.isHappy(19));
        System.out.println("0: " + "Answer: " + Main.isHappy(0));
        System.out.println("-1: " + "Answer: " + Main.isHappy(-1));
        System.out.println("23: " + "Answer: " + Main.isHappy(23));

    }
}