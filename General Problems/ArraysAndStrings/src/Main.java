import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        System.out.println(isUniqueBrute("hjkgl"));
        System.out.println(isUnique("hjkgl"));

         System.out.println(checkPermutations("venkat","venkatesh" ));
        System.out.println(checkPermutationsBySort("venkat","venkatesh" ));

        System.out.println(URLify("venkat    is   good   ",20));

        System.out.println(isPermuationOfPalindrome("Tact Coa"));

        System.out.println(stringCompression("abcABBBBBBBCCC"));

    }

    public static boolean isUniqueBrute(String str) {
        char[] carray = str.toCharArray();
        for (int i = 0; i < carray.length; i++) {
            for (int j = 0; j < carray.length; j++) {

                if(i!=j)
                    if(carray[i]==carray[j]) {
                        return false;
                    }
            }
        }
        return true;
    }


    public static boolean isUnique(String str) {
        HashMap<Character, Integer> ht = new HashMap();
        char [] carray= str.toCharArray();
        for(int i=0; i <carray.length ; i++){
            if(ht.containsKey(carray[i])) return false;
            else ht.put(carray[i], 1);
        }
        return true;
    }

    public static boolean checkPermutations(String str1, String str2) {
        String longerString, shorterString=null;
        HashMap<Character, Integer> ht = new HashMap();
        //Add longer string to hashmap and lookup other on that hashmap
        if(str1.length()>= str2.length())   {
            longerString = str1   ;
            shorterString = str2;
        } else {
            longerString = str2;
            shorterString = str1;
        }
        char [] a = longerString.toCharArray();
        for(int i=0; i<longerString.length(); i++){
           ht.put(a[i], 1);
        }
         char [] b = shorterString.toCharArray();
        for(int i=0; i<shorterString.length(); i++){
           if(ht.get(b[i])== null) return false;
        }
        
        return true;
    }

    //This assumes strings are same length. If not algorithm can be extended
    public static boolean checkPermutationsBySort(String str1, String str2) {

        char [] a = str1.toCharArray();
        Arrays.sort(a);
        String sortedStr1 = new String(a);
        char [] b = str1.toCharArray();
        Arrays.sort(b);
        String sortedStr2 = new String(b);

        if(sortedStr1.equals(str2)) return true ;
        else return false;


    }

    public static String URLify(String str, int len) {

        return str.trim().replaceAll(" ", "%20");

       /* StringBuilder sb = new StringBuilder(str);
        str.replace(" ", "%20");
        return str;
*/
    }

    public static boolean isPermuationOfPalindrome(String inpStr) {

        try {
            // Palindromes have at most one character that occurs odd number of times
            //convert to lowercase

            //Enter a hashmap of all chars.
            char [] inpChar = inpStr.replaceAll(" ", "").toLowerCase().toCharArray();
            int val=0;
            Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
            ht.clear();
            for(int i=0; i <inpChar.length; i++ ){
                if(ht.get(inpChar[i])==null) val =1 ;
                else val = (int)ht.get(inpChar[i]) +1;

                ht.put(inpChar[i], val);
                val=0;
            }

            // if we find >1 odd number of occurance of string, it is not a palindrome
            int odd=0;
            for(Character key : ht.keySet()){
               if(ht.get(key)%2!=0) odd++;
            }

            if(odd >1) return false;
            else return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static String stringCompression(String inpStr) {

        StringBuilder sb = new StringBuilder();
        try {
            char [] inpChar = inpStr.toCharArray();

            char prevChar=' ';
            int prevCharCount=0;

            prevChar = inpChar[0];
            for(int i=0; i <inpChar.length; i++ ) {

                if (prevChar == inpChar[i]) {
                    prevCharCount++;
                } else{
                    sb.append(prevChar);
                    if(prevCharCount>1) {
                        sb.append(prevCharCount);
                        prevCharCount=0;
                    }

                    prevChar = inpChar[i];
                }

            }

            sb.append(prevChar);
            if(prevCharCount>1) {
                sb.append(prevCharCount);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    
}   
    
