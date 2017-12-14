public class Main {

    public static void main(String[] args) {
        int [] a = {1,2,3,45,6,8,9,11};
        System.out.println(binarySearchRecursive(a,3, 0, a.length-1));
    }

    public static int binarySearchRecursive(int[] a , int x, int begin, int end){

        //In the sorted array, Go to middle and and see if element is greater or lesser and so on
        int middle = (begin + end)/2;
        if(x==a[middle]) return middle;
        if( x>a[middle]){
            return binarySearchRecursive(a, x, middle+1, end);
        } else return binarySearchRecursive(a, x, begin, middle-1);
    }
}
