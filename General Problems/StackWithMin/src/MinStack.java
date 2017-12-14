import java.util.Stack;

public class MinStack {

    private Stack<Integer> st = new Stack();
    int min = Integer.MAX_VALUE;


    boolean empty() {

        return st.empty();

    }

    int peek() {

        return st.peek();
    }

    int pop( ) {
        // Check the popped value
        return st.pop();
    }

    void  push(int element) {

        if(st.size()==0){
            min = element;
            st.push(element);
        } else{
            if(element<min){
                min = element;
            }
        }
    }



    int getMin() {

        return min;
    }

    public static void main(String[] args) {

        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(10);
        ms.push(3);
        ms.push(0);

        System.out.println("Min value in stack is: " + ms.getMin());
    }
}
