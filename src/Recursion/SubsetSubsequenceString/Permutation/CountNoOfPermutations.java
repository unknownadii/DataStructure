package Recursion.SubsetSubsequenceString.Permutation;

public class CountNoOfPermutations {
    public static void main(String[] args) {
        System.out.println(count("","abc"));
    }

    static int count(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            return 1;
        }
        int count =0 ;
        char ch = unProcessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String f = processed.substring(0, i);
            String l = processed.substring(i, processed.length());
            count = count + count(f+ch+l,unProcessed.substring(1));
        }
        return count;
    }

}
