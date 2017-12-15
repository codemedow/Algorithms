import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        try {
            String[] inp;
            File file = new File("inp");
            Scanner in = new Scanner(file);
            int t = in.nextInt();
            inp = new String[t];
            for(int a0 = 0; a0 < t; a0++){
                String s = in.next();
                inp[a0]=s;
            }
            char [] exp =null;
            for(int a0 = 0; a0 < t; a0++){
                exp = inp[a0].toCharArray();
                if (areParenthesisBalanced(exp))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean areParenthesisBalanced(char [] exp){
        try {
            Stack myStack = new Stack();
            char popped=' ';

            for(int i =0; i< exp.length; i++){
                if (exp[i] =='(' || exp[i]=='[' || exp[i] =='{') {

                    myStack.push(exp[i]);

                }
                if (exp[i] ==')' || exp[i]==']' || exp[i] =='}') {

                    if(myStack.isEmpty()) return false;
                    popped = (char)myStack.pop();
                    if(!isPair(popped, exp[i]) ) return false;

                }
            }

            // if stack has something left return false;
            if(myStack.isEmpty()!= true) return false;
            else return true;
        } catch (Exception e) {
            e.printStackTrace();


        }

        return false;
    }


    private static boolean isPair(char elem1, char elem2){

        if(elem1== '(' && elem2==')') return true;
        if(elem1== '[' && elem2==']') return true;
        if(elem1== '{' && elem2=='}') return true;

        return false;
    }
}
