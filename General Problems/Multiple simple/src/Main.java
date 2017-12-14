import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(sumAll(6));
        int[] a = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(reverseArray(a)));
        System.out.println(isPrime(11));
        System.out.println(fib(7));
        System.out.println(fibDynamic(7));
    }

    //Factorial
    public static long factorial(int n) {
       if(n<0) return -1;
       else if(n==0) return 0;
       else if(n==1) return 1;
       else return n* factorial(n-1);


    }

//Sum all numbers from 0 .. n
    public static long sumAll(int n) {
        if(n<0) return -1;
        else return n+ sumAll(n-1);

    }

    //Reverse an Array
    //Swap first and last and second and last but one and so on and do it until you hit the midpoint
    public static int [] reverseArray(int[] n) {
        int temp=0;
        if(n==null) return n;
        for(int i=0 ; i< n.length/2 ; i++){

            temp = n[i];
            n[i] = n[n.length-1 -i];
            n[n.length-1 -i] = temp;
        }

      return n;

    }

    //Is prime
    public static boolean isPrime(int n){
        for(int i=2; i*i <n; i++){
            if(n%i==0) return false;
        }
        return true;
    }

    //Fibonacci recurvise
    public static long fib(int n) {
        if(n<0) return -1;
        else if(n==0) return 0;
        else if(n==1) return 1;
        else if(n==2) return 1;
        else return fib(n-2)+ fib(n-1);

    }

    //Fibonacci dynamic progr
    public static int fibDynamic(int n) {

        if(n<0) return -1;

        int [] fibArray =new int[n+1];
        fibArray[0] =0;
        fibArray[1]= fibArray[2]=1;

        for(int i=2; i <=n ; i++) {

            fibArray[i] = fibArray[i - 2] + fibArray[i - 1];
        }

        return fibArray[n];
    }



}
