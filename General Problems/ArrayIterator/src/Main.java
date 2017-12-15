import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        int input[][] = { {}, { 1, 2, 3 }, { 4, 5 }, {}, {}, { 6 }, { 7, 8 }, {}, { 9 }, { 10 }, {} };

        ArrayIterator itr = new ArrayIterator(input);

        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        itr.reset();
        while(itr.hasNext()) {
            if(((int)itr.next()) %2 == 0) {
                itr.remove();
            }
        }

        itr.reset();
        System.out.println(" ");
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }



    static class ArrayIterator implements Iterator{

        private List mylist = new ArrayList();
        Iterator itr=null;
        private int cursor=0;

        ArrayIterator(int[][] array){

            for(int[] a: array){
                for(int val: a){
                    mylist.add(val);
                }
            }
            itr = mylist.iterator();
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {


            return itr.hasNext();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Object next() {
            return itr.next();
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {

            itr.remove();
        }

        /**
         * Performs the given action for each remaining element until all elements
         * have been processed or the action throws an exception.  Actions are
         * performed in the order of iteration, if that order is specified.
         * Exceptions thrown by the action are relayed to the caller.
         *
         * @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         * @implSpec <p>The default implementation behaves as if:
         * <pre>{@code
         *     while (hasNext())
         *         action.accept(next());
         * }</pre>
         * @since 1.8
         */
        @Override
        public void forEachRemaining(Consumer action) {

        }
        public void reset(){
            //get a new iterator
            itr = mylist.iterator();
        }

    }
}
