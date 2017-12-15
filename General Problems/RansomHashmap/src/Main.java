import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main s = new Main("two times three is not four", "two times two is four");

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
    }

    Map<String, Integer> magazineMap = new HashMap<String, Integer>();
    Map<String, Integer> noteMap = new HashMap<String, Integer>();

    public Main(String magazine, String note) {
        // For Magazine
        // Parse string to token
        // Add them to hashmap
        //For each word in note lookup hashmap if found decrement. If 0 remove. If not found false;
        String[] strings = magazine.split(" ");
        int val=0;
        for(String s: strings){
            val=0;
            if(magazineMap.containsKey(s)){
                val= (int) magazineMap.get(s);

            }
            val++;
            magazineMap.put(s, val );
        }
        String[] strings2 = note.split(" ");
        int val2=0;
        for(String s: strings2){
            val2=0;
            if(noteMap.containsKey(s)){
                val2= (int) noteMap.get(s);

            }
            val2++;
            noteMap.put(s, val2 );
        }
    }

    public boolean solve() {

        int val=0;
        for(String key : noteMap.keySet())
        {
            if(magazineMap.containsKey(key)) val= magazineMap.get(key);
            else return false;
            if(val==0) return false;
            int val2 = noteMap.get(key);
            if(val-val2 <0) return false;
        }
        return true;
    }
}
