import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianHeap {

    public static void main(String[] args) {
        try {
            System.out.println("Find Median of a stream of integers");

            MedianHeap mh = new MedianHeap();

            int num;
            BigInteger medianSum= new BigInteger("0");
            int median=-1;
            File file = new File("medianstream.txt");
            BufferedReader reader = null;

            reader = new BufferedReader(new FileReader(file));
            String text = null;
            int i=0;

            while ((text = reader.readLine()) != null) {
                i++;
                num =Integer.parseInt(text);
                mh.add(num);
                median = mh.getMedian();

                medianSum = medianSum.add(BigInteger.valueOf(median));

                System.out.println("Count="+ i + " Added:" + num + " Median=" + median + " MedianSum="+medianSum);
            }

             medianSum = medianSum.mod(BigInteger.valueOf(10000));

            System.out.println("MedianSum="+(medianSum));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Have Max heap representing left part and Max heap representing right part

    PriorityQueue<Integer> maxHeap = null;
    PriorityQueue<Integer> minHeap = null;
    int currentMedian=-1;

    MedianHeap(){

        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    void add(int num){
        try {
            // if new element is > current median it goes to min heap
            //if it is < current median it goes to max heap
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());

            if(maxHeap.size() < minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    int getMedian(){

        int median=-1;
        try {
            //if size of heaps are same, median is mean of root of min and max heap
            //if size of one heap is more than other heap, median resides in that heap's root

            if(maxHeap.size()==0 && minHeap.size()==0) return 0;

            if(maxHeap.size()== minHeap.size()){
               median= (maxHeap.peek()+ minHeap.peek())/2;
            } else {
                median = maxHeap.peek();
            }
        } catch (Exception e) {
            e.printStackTrace();
            median=-1;
        }

        currentMedian= median;
        return median;
    }

    int readNum(){

        return -1;
    }

}
