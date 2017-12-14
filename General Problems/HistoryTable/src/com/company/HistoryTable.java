package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* Not complete, but all logic is there - but can be completed easily*/
public class HistoryTable {

    HashMap hm ;
    LinkedList ll ;

    HistoryTable(){

        hm = new HashMap();


    }
    void put(String key, String value){

        if(key==null) return;
        else{

            llhead = hm.get(key);

            //If already there
            if(llHead!=null) {
                //Add it to llHead
                currentTime = getCurrentTimeInLong();
                TimeStampVal = new TimeStampVal(currentTime, value);

                llHead.add(TimestampVal);
            } else {
                //New entry
                currentTime = getCurrentTimeInLong();
                TimeStampVal = new TimeStampVal(currentTime, value);

                LinkedList<TimeStampValue> ll = new LinkedList<TimeStampValue>();
                ll.add(TimeStampVal);
                hm.put(key,ll );
            }
        }

    }

     String get(String key, long timeStamp){

         LinkedList<TimeStampValue> llhead;
         TimeStampVal tsVal=null;
         long lastTimeStamp=0;
         if(key==null) return;
         else{
              // Found a linked list
             llhead = hm.get(key);
             if(llhead!=null){
                 Iterator itr = llhead.listIterator();
                 while(itr.hasNext()){
                     lastTimeStamp = tsVal.TimeStamp ;
                     lastVal = tsVal.value;
                   tsVal  = (TimeStampValue) itr.next();


                   // Found the timestamp
                   if(tsval.TimeStamp==timeStamp)
                   {
                       return tsVal.value;
                   } else
                   {
                       if(timeStamp < tsval.TimeStamp ){
                           if(timeStamp> lastTimeStamp)
                               return lastVal;

                       } else if(timeStamp> lastTimeStamp && !itr.hasNext()){

                           return lastVal;
                       }

                 }

                 }
                 //Found linkedlist, but not timestamp
                 return null;
             } else{
                 // Not found
                 return null;
             }


         }


    public static void main(String[] args) {
	// write your code here
    }

    Class TimestampValue {
         long TimeStamp;
         String value;
         TimeStampValue(long TimeStamp, String value){
             //fill it up
        }
    }

}
