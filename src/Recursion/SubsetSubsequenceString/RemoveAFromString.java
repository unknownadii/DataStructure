package Recursion.SubsetSubsequenceString;

/*
example - bbaccaxsxaxd remove all "a" from thid String
 */
// Note if we are passing arr then change in its actual value takes place
// but if pass the any string or integer thing then there will no effect on its real value. like question :- RemoveAFromString.java

public class RemoveAFromString {
    public static void main(String[] args) {
        String Str = "adedsaadrdaaffga";
        System.out.println(removeA(Str, 0));
        System.out.println(removeA2(Str));
        removeA1(Str, "");
        // there is no effect takes place on String Str
        System.out.println(Str);
    }

    static String removeA(String str, int i) {
        if (i == str.length()) {
            return str;
        }
        char c = str.charAt(i);
        if (c == 'a') {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            return removeA(newStr, i);
        } else {
            return removeA(str, i + 1);
        }
    }

    // Method 2
    static void removeA1(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        if (ch == 'a') {
            removeA1(str.substring(1), ans);
        } else {
            removeA1(str.substring(1), ans + ch);
        }
    }

    // Method 2 with return type
    static String removeA2(String str) {
        if (str.isEmpty()) {
            return " ";
        }
        char ch = str.charAt(0);
        if (ch == 'a') {
           return removeA2(str.substring(1));
        } else {
            return ch + removeA2(str.substring(1));
        }
    }
}
