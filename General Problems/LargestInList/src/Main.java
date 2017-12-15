import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>(Arrays.asList(1, 2, 21, 4, 9, 0));
        System.out.println(findMax(ll));
        System.out.println(findMaxRecursive(ll, ll.listIterator(), -1));
    }


    public static int findMax(LinkedList<Integer> lls) {

        int elem=0;
        int max= lls.getFirst();
        Iterator itr = lls.iterator();
        while (itr.hasNext()) {
            elem = (Integer) itr.next();
            if(elem>max) max=elem;
        }

        return max;
    }

    public static int findMaxRecursive(LinkedList<Integer> lls, Iterator itrCurrent, int max) {
         int elem=-1;
         if(!itrCurrent.hasNext()){
             return max;
         } else {

             elem = (Integer) itrCurrent.next();
             if (elem > max) max = elem;

             return findMaxRecursive(lls, itrCurrent, max);
         }

    }

}