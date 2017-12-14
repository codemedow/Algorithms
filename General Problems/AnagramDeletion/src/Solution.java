import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long numberNeeded(String first, String second) {
        //Add each String to hashmap with count of number of occurance
        HashMap<Character, Integer> hmFirst = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmSecond = new HashMap<Character, Integer>();

        char [] firstCharArray = first.toCharArray();
        char [] secondCharArray = second.toCharArray();

        int count=0;

        //Add it to hashmaps
        for(int i=0; i<firstCharArray.length; i++){

            count=0;
            if(hmFirst.get(firstCharArray[i])!=null){
                count = (Integer) hmFirst.get(firstCharArray[i]);
            }

            hmFirst.put(firstCharArray[i], count+1);
        }

        for(int i=0; i<secondCharArray.length; i++){

            count=0;
            if(hmSecond.get(secondCharArray[i])!=null){
                count = (Integer) hmSecond.get(secondCharArray[i]);
            }

            hmSecond.put(secondCharArray[i], count+1);
        }

        // Now Go through first hashmap and compare with second hashmap
        int value1=0, value2=0;
        long numberNeeded=0;
        for ( Character key : hmFirst.keySet() ) {

            value1 = hmFirst.get(key);

            //Check in second hashmap, if not found increment numberNeeded by value found in hmFirst,
            //if found add to numberNeeded the modulus of diff between value found in hmFirst and hmSecond
            if( hmSecond.get(key)!=null){
                value2= hmSecond.get(key);

                //Remove the key from first and second hm
                hmSecond.put(key, -1);
                hmFirst.put(key, -1);

                numberNeeded= numberNeeded +Math.abs(value2-value1);
            } else {

                //remove the key from first hashmap
                hmFirst.put(key, -1);
                numberNeeded= numberNeeded+value1;
            }
        }

        // Go through second hashmap and for each key get value and add to number needed
        for ( Character key : hmSecond.keySet() ) {
            value1 = hmSecond.get(key);
            if(value1!=-1)
                numberNeeded = numberNeeded + value1;
        }

        return numberNeeded;

    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        String a = "cde" ;//in.next();
        String b = "abc"; //in.next();
        System.out.println(numberNeeded(a, b));
    }
}

