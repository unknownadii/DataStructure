package Recursion.SubsetSubsequenceString.Permutation;

import java.util.ArrayList;

public class ReturnArraylistPermutation {
    public static void main(String[] args) {
        System.out.println(permutaion("","abc"));
    }

    static ArrayList<String> permutaion(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> str = new ArrayList<>();
            str.add(processed);
            return str;
        }

        char ch = unProcessed.charAt(0);
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i <=processed.length(); i++) {
            String f = processed.substring(0, i);
            String l = processed.substring(i, processed.length());
            ArrayList<String> st = permutaion(f + ch + l, unProcessed.substring(1));
            s.addAll(st);
        }
        return s;
    }
}
