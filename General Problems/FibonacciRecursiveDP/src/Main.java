public class Main {

    public static void main(String[] args) {
        System.out.println("Fibonacci with Recursion and DP");
        init();
        System.out.println(fib(34));
        System.out.println(fib(5));
    }


    static long []fib = new long[10000];

    private static void init(){
        fib[0]=1;
        fib[1]=1;
        for(int i=2; i<10000; i++){
            fib[i]= -1;
        }
    }

    private static long fib(int n){
        if(n<=0) return 0;
        if(fib[n]==-1){
            fib[n]= fib(n-1) + fib(n-2);
        }
        return fib[n];
    }
}
