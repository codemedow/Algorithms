package com.company;

import java.io.*;
import java.util.*;

/* Cost of Various items in a menu
Target given.
Find menu items
*/

class Solution {

    public static void menu(int a[], int target, ArrayList ret, int i) {
        if (target == 0) {
            System.out.println(ret);
            return;
        }
        if (target == a.length) {
            return;
        }
        ret.add(a[i]);
        menu(a, target - a[i], ret, i);
        ret.remove(ret.size() - 1);
        menu(a, target, ret, i + 1);
    }


    public static void main(String[] args)
    {
        int a[] = {4,2,3,1};
        int target = 6;
        menu(a,target, new ArrayList(),0);
    }
}