import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack

            stackNewestOnTop.push(value);
        }

        public T peek() {

            if(stackOldestOnTop.empty()){
                //Move from stackNewest to StackOldest every element and then pop
                while(!stackNewestOnTop.empty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {

            if(stackOldestOnTop.empty()){
                //Move from stackNewest to StackOldest every element and then pop
                while(!stackNewestOnTop.empty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.pop();

        }
    }


    public static void main(String[] args) {
        try {
            MyQueue<Integer> queue = new MyQueue<Integer>();

            Scanner scan = new Scanner(new File("input.txt"));
            int n = scan.nextInt();

            for (int i = 0; i < n; i++) {
                int operation = scan.nextInt();
                if (operation == 1) { // enqueue
                    queue.enqueue(scan.nextInt());
                } else if (operation == 2) { // dequeue
                    queue.dequeue();
                } else if (operation == 3) { // print/peek
                    System.out.println(queue.peek());
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}