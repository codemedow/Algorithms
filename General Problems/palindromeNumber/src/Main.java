public class Main {

    public static void main(String[] args) {
        System.out.println(reverse(121));
        if(reverse(121)==121 ) System.out.println("Palindrome");
                else System.out.println("Not a Palindrome");
    }

    public static int reverse(int i){
        //Reverse the number
        /* Number %10 - last digit
        int(Number/10) %10 = second to last digit
         */
        int rev=0;
        while(i!=0){
            rev = rev*10 + i%10;
            i= i/10;
        }

        return rev;
    }
}
