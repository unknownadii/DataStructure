package Recursion.SubsetSubsequenceString.Permutation.CompanyQuestions;

import java.util.ArrayList;

/*
Questions :- print all combination on which the sum is 4 when a dice role;
example :- for 4 ( 4, 22,31,112,1111,)
 */
public class DiceRoll {
    public static void main(String[] args) {
        dice("", 4);
        System.out.println(diceReturnArrayList("", 4));
        System.out.println(count("", 4));
    }

    static void dice(String pro, int target) {
        if (target == 0) {
            System.out.println(pro);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(pro + i, target - i);
        }
    }

    //return Arraylist
    static ArrayList<String> diceReturnArrayList(String pro, int target) {
        if (target == 0) {
            ArrayList<String> st = new ArrayList<>();
            st.add(pro);
            return st;
        }
        ArrayList<String> s = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            ArrayList<String> str = diceReturnArrayList(pro + i, target - i);
            s.addAll(str);
        }
        return s;
    }

    //return count
    static int count(String pro, int target) {
        if (target == 0) {
            return 1;
        }
        int c = 0;
        for (int i = 1; i <= 6 && i <= target; i++) {
            c = c + count(pro + i, target - i);
        }
        return c;
    }
}
