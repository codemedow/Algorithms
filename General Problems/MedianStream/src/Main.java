import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    /** initialize your data structure here. */

    Queue<Integer> maxHeap ;
    Queue<Integer> minHeap;

    public MedianFinder() {

        maxHeap = new PriorityQueue<Integer>();
        minHeap= new PriorityQueue<Integer>( 1000, Comparator.reverseOrder());


    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);

        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */