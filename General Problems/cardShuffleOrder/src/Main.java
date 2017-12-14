import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        try {
            // Num of Counts Array
            //This is the array that designates number of alphabets for Ace (use one) through King in a language
            int[] countsEnglish = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 4, 5, 4};
            int[] countsHindi = {2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2};
            int[] countsTamil = {3, 4, 3, 3, 3, 2, 2, 3, 4, 3, 4, 2, 2};
            int[] countsTest = {0, 0, 17, 300, 0, 1, 1, 1, 1, 1, 1, 1, 1}; // test for arbitrary input to see if it works

            ArrayList<String> cardsCorrectOrder = new ArrayList<String>() {{
                add("ONE");
                add("TWO");
                add("THREE");
                add("FOUR");
                add("FIVE");
                add("SIX");
                add("SEVEN");
                add("EIGHT");
                add("NINE");
                add("TEN");
                add("JACK");
                add("QUEEN");
                add("KING");
            }};

            ArrayList<String> cardsEmpty = new ArrayList<String>() {{
                add("0");
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("6");
                add("7");
                add("8");
                add("9");
                add("10");
                add("11");
                add("12");
            }};


            //English
            String[] answerEnglish = doReverseTrickAndFindOrder(countsEnglish, cardsEmpty, cardsEmpty.size(), true, cardsCorrectOrder);
            if(answerEnglish!=null) {
                System.out.println("---Order of cards in English is: " + Arrays.toString(answerEnglish));


                System.out.println("Checking validity by poping it");
                ArrayList<String> cardsEnglish = new ArrayList<String>(Arrays.asList(answerEnglish));
                if (!doTrick(countsEnglish, cardsEnglish, cardsEnglish.size(), true))
                    System.out.println("Trick Failed for English");
            }
            else System.out.println("Could not find order for English.Check inputs");


            //Hindi
            String[] answerHindi = doReverseTrickAndFindOrder(countsHindi, cardsEmpty, cardsEmpty.size(), true, cardsCorrectOrder);
            if(answerHindi!=null) {
                System.out.println("---Order of cards in Hindi is: " +Arrays.toString(answerHindi));
                System.out.println("Checking validity by poping it");
                ArrayList<String> cardsHindi = new ArrayList<String>(Arrays.asList(answerHindi));
                if(!doTrick(countsTamil, cardsHindi, cardsHindi.size(), true))
                    System.out.println("Trick Failed for Hindi");
            }
            else System.out.println("Could not find order For Hindi. Check inputs");


            //Tamil
            String[] answerTamil = doReverseTrickAndFindOrder(countsTamil, cardsEmpty, cardsEmpty.size(), true, cardsCorrectOrder);
            if(answerTamil!=null) {
                System.out.println("---Order of cards in Tamil is: " +Arrays.toString(answerTamil));
                System.out.println("Checking validity by poping it");
                ArrayList<String> cardsTamil = new ArrayList<String>(Arrays.asList(answerTamil));
                if(!doTrick(countsTamil, cardsTamil, cardsTamil.size(), true))
                    System.out.println("Trick Failed for Tamil");
            }
            else System.out.println("Could not find order For Tamil. Check inputs");



            //Arbitrary language
            String[] answerTest = doReverseTrickAndFindOrder(countsTest, cardsEmpty, cardsEmpty.size(), true, cardsCorrectOrder);
            if(answerTest!=null){
                System.out.println("---Order of cards in Test is: " +Arrays.toString(answerTest));
                System.out.println("Checking validity by poping it");
                ArrayList<String> cardsTest = new ArrayList<String>(Arrays.asList(answerTest));
                if(!doTrick(countsTest, cardsTest, cardsTest.size(), true))
                    System.out.println("Trick Failed for Test");
            }
            else System.out.println("Could not find order for Test. Check inputs");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Do the Card Trick to check
    //Deck should have cards from Ace(1) through King and nothing else
    public static boolean doTrick(int [] counts, ArrayList<String> cards, int num, Boolean fromBegin){

        try {

            if(counts.length!=13 || cards.size()!=13) return false;

            int begin=0, end=0;
            //Deep copy
            ArrayList<String> cardsCopy =  new ArrayList<String>(cards.size());
            for (String str : cards) cardsCopy.add(str);
            if(fromBegin!= true){
                begin = counts.length-1-num;
                end = counts.length;
            } else{
                begin = 0;
                end = counts.length;
            }

            for(int i = begin; i<end; i++) {
                String temp=null, out =null;
                int j = counts[i];
                while (--j >= 0) {
                    if(cardsCopy.size()>0) {
                        //Move counts[i] cards in cards list from the top to end =>  for each remove top and add to end
                        temp = cardsCopy.get(0);
                        cardsCopy.remove(0);
                        cardsCopy.add(temp); //adds to end
                    }
                }
                if(cardsCopy.size()>0) {
                    //Pop the top card out of the deck
                    out = cardsCopy.get(0);
                    cardsCopy.remove(0);
                   System.out.println("Popped: " + out);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;


    }

    // Do the Trick, and designate what gets popped out as the correct answer. This way it is like reverse trick to find the original order of card

    public static String[] doReverseTrickAndFindOrder(int [] counts, ArrayList<String> cardsEmpty, int num, Boolean fromBegin, ArrayList<String> cardsCorrectOrder ){

        try {
            int begin=0, end=0, k=0;
            String []cardsOut= new String[13];

            if(counts.length!=13 || cardsEmpty.size()!=13 || cardsCorrectOrder.size()!=13) return null;

            //Deep copy
            ArrayList<String> cardsCopy =  new ArrayList<String>(cardsEmpty.size());
            for (String str : cardsEmpty) cardsCopy.add(str);


            if(fromBegin!= true){
                begin = counts.length-1-num;
                end = counts.length;
            } else{
                begin = 0;
                end = counts.length;
            }

            for(int i = begin; i<end; i++) {
                String temp=null, out =null;
                int j = counts[i];

                if(j<0) return null ; //if any element in counts is negative cannot operate

                while (--j >= 0) {
                    if(cardsCopy.size()>=0) {
                        //Move counts[i] cards in cards list from the top to end => Remove top and add to end every time
                        temp = cardsCopy.get(0);
                        cardsCopy.remove(0);
                        cardsCopy.add(temp); //adds to end
                    }
                }
                if(cardsCopy.size()>=0) {
                    //Pop the top card and we know what it should be, so add it in the output array at proper index
                    out = cardsCopy.get(0);
                    cardsCopy.remove(0);
                    cardsOut[Integer.parseInt(out)]= cardsCorrectOrder.get(k);
                    k++;
                }
            }
            return cardsOut;

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }


}
