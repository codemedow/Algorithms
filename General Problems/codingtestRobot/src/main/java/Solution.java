import java.util.HashMap;


public class Solution {

    static String[] doesCircleExist(String[] commands) {

        String [] output=null;
        String command=null;
        long numOfTimes= 0;
        HashMap<String, Long> mymap = new HashMap();
        //Get each element in commands
        for(int i =0; i<commands.length; i++) {
            command = commands[i];

            for (int j = 0; i < command.length(); j++) {
                //Look up how many times an action occured first and  every time the action is encountered increment it and store it in the hashmap
                if(mymap.containsKey(command)){
                    numOfTimes =mymap.get(command);
                    mymap.put(command, Long.valueOf(numOfTimes + 1));
                } else mymap.put(command, Long.valueOf(1));

            }


            //Now go through the hashmap and
            // if it has No G ->YES
            // if it has EVEN R or 0 R and EVEN L or 0 L, -> YES
            //Otherwise NO

            output[i]= "YES";
            for (String key : mymap.keySet()) {
                //NO G- NO
                if (key.equalsIgnoreCase("G")) {
                    if (mymap.containsKey(key) !=true || mymap.get(key) == 0) {
                     output[i]= "NO";
                    }
                } else if (mymap.get(key) % 2!=0 ){
                    output[i]= "NO";
                }
            }
        }


        return output;
    }


    public static void main(String[] args) throws Exception
    {
        String[] commands=null;
        String [] output=null;
        commands[0] ="G";

        output = doesCircleExist(commands);

        System.out.println("Output is:" + output);
    }

}
