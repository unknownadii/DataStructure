package Recursion.SubsetSubsequenceString.Permutation.CompanyQuestions;

import java.util.ArrayList;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        combination("", "12");
        System.out.println(combinationReturnArraylist("", "12"));
        ArrayList<String> testString = new ArrayList<>();
        combinationReturnArraylistInParameter("", "12", testString);
        System.out.println(testString);
        System.out.println(combinationReturnArraylistInParameterWithReturnType("","12",new ArrayList<>()));

    }

    static void combination(String pro, String unPro) {
        if (unPro.isEmpty()) {
            System.out.println(pro);
            return;
        }
        int digit = unPro.charAt(0) - '0'; // this will convert character in to digit
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // it will gives the letter as a + 1 = 98 = 'b'
            combination(pro + ch, unPro.substring(1));
        }
    }

    static ArrayList<String> combinationReturnArraylist(String pro, String unPro) {
        if (unPro.isEmpty()) {
            ArrayList<String> st = new ArrayList<>();
            st.add(pro);
            return st;
        }
        int digit = unPro.charAt(0) - '0'; // this will convert character in to digit
        ArrayList<String> str = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // it will gives the letter as a + 1 = 98 = 'b'
            ArrayList<String> list = combinationReturnArraylist(pro + ch, unPro.substring(1));
            str.addAll(list);
        }
        return str;
    }

    static void combinationReturnArraylistInParameter(String pro, String unPro, ArrayList<String> str) {
        if (unPro.isEmpty()) {
            str.add(pro);
            return;
        }
        int digit = unPro.charAt(0) - '0'; // this will convert character in to digit
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // it will gives the letter as a + 1 = 98 = 'b'
            combinationReturnArraylistInParameter(pro + ch, unPro.substring(1), str);
        }
    }

    static ArrayList<String> combinationReturnArraylistInParameterWithReturnType(String pro, String unPro, ArrayList<String> str) {
        if (unPro.isEmpty()) {
            str.add(pro);
            return str;
        }
        int digit = unPro.charAt(0) - '0'; // this will convert character in to digit
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // it will gives the letter as a + 1 = 98 = 'b'
            combinationReturnArraylistInParameterWithReturnType(pro + ch, unPro.substring(1), str);
        }
        return str;
    }

}

