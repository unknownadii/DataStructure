package Recursion.SubsetSubsequenceString.Permutation;

/*
String processed = String on which value is storing
, String unProcessed = String which id given by user to give permutation
 */
public class PermuationOfAbc {
    public static void main(String[] args) {
        permutation("", "abc");
    }

    static void permutation(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String f = processed.substring(0, i);
            String r = processed.substring(i, processed.length());
            String addElement = f + ch + r;
            permutation(addElement, unProcessed.substring(1));
        }
    }
}
