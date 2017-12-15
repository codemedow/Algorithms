import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
/*
given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew") );
    }

    public static int lengthOfLongestSubstring(String s) {
      /*  Hashtable<String, Integer> ht = new Hashtable<String, Integer>();

       char[] charArray = s.toCharArray();

       long size=0;
       long max=0;
       for(char c: charArray)
       {
           if(ht.get(c)!=null){
               //Repeat found. Store off length if it is greater than max
               // clear ht
               size =ht.size();
               if(size>max) max= size;
               ht.clear();
           }
       }*/

        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;

    }
}
