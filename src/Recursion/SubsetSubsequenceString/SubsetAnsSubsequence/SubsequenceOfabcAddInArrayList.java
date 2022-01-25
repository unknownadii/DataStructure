package Recursion.SubsetSubsequenceString.SubsetAnsSubsequence;

import java.util.ArrayList;

public class SubsequenceOfabcAddInArrayList {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        subSequence("abc", "", arr);
        System.out.println(arr);
        System.out.println(subSequence2("abcd",""));
    }

    static void subSequence(String pro, String store, ArrayList<String> arrlist) {
        if (pro.isEmpty()) {
            arrlist.add(store);
            return;
        }
        char ch = pro.charAt(0);
        subSequence(pro.substring(1), store, arrlist);// choice of not adding/coming
        subSequence(pro.substring(1), store + ch, arrlist); // choice of adding/coming
    }

    // Method 2 without passing Arraylist in argument
    static ArrayList<String> subSequence2(String pro, String store) {
        if (pro.isEmpty()) {
            ArrayList<String> arrlist = new ArrayList<>();
            arrlist.add(store);
            return arrlist;
        }
        char ch = pro.charAt(0);
        ArrayList<String> left = subSequence2(pro.substring(1), store);// choice of not adding/coming
        ArrayList<String> right = subSequence2(pro.substring(1), store + ch); // choice of adding/coming
        left.addAll(right);
        return left;
    }
}
