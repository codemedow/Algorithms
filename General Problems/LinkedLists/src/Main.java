import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>(Arrays.asList("1","2","2","4","5"));

        LinkedList<Integer> ll1 = new LinkedList<Integer>(Arrays.asList(1,2,3));
        LinkedList<Integer> ll2 = new LinkedList<Integer>(Arrays.asList(0,0,1));

        System.out.println(ll);
        System.out.println(removeDuplicates(ll));

        System.out.println(KthElement(ll, 2));
        System.out.println(add(ll1, ll2));
        System.out.println(addinPlace(ll1, ll2));
    }

    public static LinkedList removeDuplicates(LinkedList<String> lls) {
        HashSet hs = new HashSet();
        String elem=null;
        Iterator itr = lls.iterator();
        while(itr.hasNext()){
            elem = (String)itr.next();
            if(hs.contains(elem)){
                itr.remove();
            } else{
                hs.add(elem);
            }
        }
        return lls;

    }

    public static LinkedList KthElement(LinkedList<String> lls, int k) {

        LinkedList newList = new LinkedList<String>();
        for(int i=k; i< lls.size(); i++) {
            newList.add(lls.get(i));
        }

        return newList;

    }

    public static int add(LinkedList<Integer>lls1, LinkedList<Integer> lls2) {

        int elem=0;
        int i=1;
        int num1=0, num2=0;
        Iterator itr = lls1.iterator();
        while(itr.hasNext()){

            elem = (Integer)itr.next();
            num1 = num1+ elem*i;
            i=i*10;
        }
        System.out.println("Number 1: " + num1);

        i=1; elem=0;
        Iterator itr2 = lls2.iterator();
        while(itr2.hasNext()){

            elem = (Integer)itr2.next();
            num2 = num2+ elem*i;
            i=i*10;
        }
        System.out.println("Number 2: " + num2);
        return num1+num2;

    }

    public static LinkedList addinPlace(LinkedList<Integer>lls1, LinkedList<Integer> lls2) {

        int elem1=0, elem2=0;
        int sum=0, carry=0;
        int i=1;
        int num1=0, num2=0;
        Iterator itr ;
        Iterator itr2 ;
        LinkedList<Integer> answer = new LinkedList<Integer>();
        if(lls1.size() >= lls2.size()) {
            itr = lls1.iterator();
            itr2 = lls2.iterator();
        } else {
            itr = lls2.iterator();
            itr2 = lls1.iterator();
        }
        while(itr.hasNext()){

            elem1 = (Integer)itr.next();
            elem2 = (Integer)itr2.next();
            sum = elem1+elem2 + carry ;
            if(sum>=10){
                sum=sum-10;
                carry=1;
                answer.add(sum);
            }  else {
                answer.add(sum);
                carry=0;
            }

        }
        return answer;

    }
}
