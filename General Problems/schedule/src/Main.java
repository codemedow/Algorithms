import java.util.HashMap;

public class Main {

    static HashMap<Integer, Integer> busyHash = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Hello World!");

       int [] [] []busyArray =  {{{4,5},{6,10},{12,14}}, {{4,5},{5,9},{13,16}}, {{11,14} }};
       int i=0;
        initBusyArray();

       for(int [][] array2d: busyArray)
       {
           for (int[] array1d: array2d) {
               System.out.println("Values:" + array1d[0] + "," + array1d[1]);
               markBusy(array1d[0], array1d[1]);
           }
       }
        System.out.println("Free Times");
       findFreeTimes();
    }

    public static void initBusyArray(){

        for(int i =0; i <=24; i++)
        {
            busyHash.put(i, 0);
        }

    }
    public static void markBusy(int begin , int end){

        if(end<begin) return;
        for(int i= begin; i<=end; i++)
        {
            busyHash.put(i, 1);
        }

    }

    public static void findFreeTimes()
    {
        int begin = 24, end=0;
        int [] [] output = new int[1][2];
        for( int time : busyHash.keySet()){

            if(busyHash.get(time)!=1)
            {
                if(time< begin)  begin = time;

            }
            else if(busyHash.get(time)==1 && begin < time)
            {
                 end = time;
                System.out.print("(" + begin + "," + end + ")");
                begin=24;
                end=0;
            }
        }
    }
}
