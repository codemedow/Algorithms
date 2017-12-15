import java.util.*;
public class Main {

    public static void main(String[] args) {
       String [] words = new String []{"abcd", "dcba", "lls", "s", "sssll"};
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

        // For each word in array append other words and check if palindrome


        for(int i =0; i<words.length; i++)
        {

            for(int j=0; j<words.length; j++){
                if(i!=j && checkIsPalindrome(words[i]+words[j])){
                    ArrayList<Integer> coord  = new ArrayList<Integer>();
                    coord.add(i);
                    coord.add(j);
                    al.add(coord);

                }
            }

        }

        System.out.println("Answer: " + al.toString());

    }

    public static boolean checkIsPalindrome(String word){

       StringBuilder sb = new StringBuilder(word).reverse();
        if(word.equalsIgnoreCase(sb.toString())) return true;
        else return false;
    }
}
