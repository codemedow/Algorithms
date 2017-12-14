import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println("Karatsuba Multiplication using Recursion:");
        String [] str = new String[2];
        String [] strPadded = new String[2];
        str[0]= "3141592653589793238462643383279502884197169399375105820974944592";
        str[1]= "2718281828459045235360287471352662497757247093699959574966967627";

        //8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184

       // str[0]= "14977670";
       // str[1]= "84664984";

       // str[0]= "12345678998765432112345678987654321";
       // str[1]= "1212121212121234343434343434343434444444444";

        System.out.println("Input: " + str[0] + "  "+ str[1]);
        System.out.println("Product by Karatsuba recursion method: " + karatsuba(str[0], str[1]));
    }

    public static String karatsuba(String a, String b){

       String [] str = pad(a,b);
       a= str[0];
       b=str[1];
      System.out.println("Karatsuba: " + a + " " + b);

        // Base case: if they have one digit each, multiply them and return
        if(a.length()==1 || b.length()==1){
            int val = Integer.parseInt(a)* Integer.parseInt(b);

            System.out.println("Returning base case: " + val);
            return Integer.toString(val);
        } else {

            int n = a.length() ;
            // Split in to half
            String[] aSplit = splitIntoHalf(a);
            String[] bSplit = splitIntoHalf(b);

            BigInteger part1 = (new BigInteger(karatsuba(aSplit[0], bSplit[0])).multiply(new BigDecimal(Math.pow(10 , n)).toBigInteger()));
            BigInteger part2a = new BigInteger((karatsuba(aSplit[0], bSplit[1])));
            BigInteger part2b= new BigInteger(karatsuba(aSplit[1], bSplit[0]));
            BigInteger part2 = (part2a.add(part2b).multiply(new BigDecimal(Math.pow(10 , n/2)).toBigInteger()));
            BigInteger part3 = new BigInteger(karatsuba(aSplit[1],bSplit[1]));
            BigInteger  f = part1.add(part2).add(part3);

            System.out.println("part1: " + part1 + " " + "part2: " + part2 + " " + "part3: " + part3);
            System.out.println("Returning Answer: " + f);
            return f.toString();
        }

    }

    public static String [] splitIntoHalf(String str)
    {
        try {
            String first=null, second=null;
            if(str!=null) {
                int n = str.length() / 2;
                first = str.substring(0, n);
                second = str.substring(n , str.length());

                String[] ret = new String[2];
                ret[0] = first;
                ret[1] = second;
                return ret;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String [] pad(String a, String b){

        try {
            long alen = a.length();
            long blen = b.length();
            long numPad=0;
            StringBuilder sb = new StringBuilder() ;

           // System.out.println("alen: " + alen + "  " + "blen: " + blen);
            if(alen> blen){
                numPad = alen-blen;
                for(int i=1; i<=numPad; i++){
                    sb.append('0');
                }
                b= sb+ b;
            } else if (blen>alen){
                numPad = blen-alen;
                for(int i=1; i<=numPad; i++){
                    sb.append('0');
                }
                a= sb+ a;
            }

            String [] str = new String[2];
            str[0]=a;
            str[1]=b;

            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
