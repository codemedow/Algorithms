public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(Check("5105105105105100"));
    }

    //Lunh Algorithm
    public static boolean Check(String ccNumber) {

        int n=0;
        int sum=0;
        boolean alternate=false;
        for(int  i = ccNumber.length()-1; i>=0; i--)
        {
            if(alternate) {
                n = Integer.parseInt(ccNumber.substring(i, i + 1));
                System.out.println("working on: " + n);
                n = n * 2;
                if (n >9) n = n - 9;
                sum = sum + n;
            }
            alternate=!alternate;

        }

        System.out.println("Sum: " + sum);
        return (sum % 10 == 0);

    }
}
