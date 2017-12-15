public class Main {

    public static void main(String[] args) {

        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords(null));
        System.out.println(reverseWords("1 "));
        System.out.println(reverseWords("   a   b "));
    }

    public static String reverseWords(String s) {
        if(s==null) return null;
        s.trim();

        StringBuffer sbAll = new StringBuffer(s.trim());
        String strOut="";
        sbAll.reverse();

       String [] str;
       str = sbAll.toString().split(" ");
       for(String st : str){

           st.trim();
           if(!st.equals("")) {
               StringBuffer sb = new StringBuffer(st);
               sb.reverse();

               if (strOut == "")
                   strOut = sb.toString();
               else {
                   strOut = strOut + " " + sb.toString();
               }
           }
       }

       return strOut;

    }
}
