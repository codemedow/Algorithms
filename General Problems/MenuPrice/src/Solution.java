
import java.io.*;
import java.util.*;

class Solution {

    static ArrayList retlist = new ArrayList();
    public static void menu2(int a[], int target, ArrayList ret, int i)
    {
        if(target==0) System.out.println(ret);
        return;


    }
    public static void menu(int a[],int target, ArrayList ret, int i)
    {

        if(target==0)
        {
            System.out.println(ret);
            return;
        }
        if(target<0){
            return;
        }

        if(i>= a.length) return;

        ret.add(a[i]);
        menu(a,target-a[i],ret,i);
       ret.remove(ret.size()-1);
        menu(a,target,ret, i+1);

    }

    public static void main(String[] args) {

        int a[] = {1,2};
        int target = 3;

        menu(a,target, new ArrayList(),0);

    }
}

