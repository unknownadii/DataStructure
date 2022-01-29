package Recursion.SubsetSubsequenceString.Permutation.CompanyQuestions;

import java.util.ArrayList;

public class DiceRollFaceGiven {
    public static void main(String[] args) {
        dice("", 9,20);
        System.out.println(diceReturnArrayList("", 4,6));
    }

    static void dice(String pro, int target,int face) {
        if (target == 0) {
            System.out.println(pro);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            dice(pro + i, target - i,face);
        }
    }
    static ArrayList<String> diceReturnArrayList(String pro, int target,int face) {
        if (target == 0) {
            ArrayList<String> st = new ArrayList<>();
            st.add(pro);
            return st;
        }
        ArrayList<String> s = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            ArrayList<String> str = diceReturnArrayList(pro + i, target - i,face);
            s.addAll(str);
        }
        return s;
    }
}
