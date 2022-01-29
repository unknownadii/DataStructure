package Recursion.SubsetSubsequenceString.Permutation.CompanyQuestions;

public class countTotalNumberInLetterGeneratedByPHone {
    public static void main(String[] args) {
        System.out.println(count("","21"));
    }

    static int count(String pro, String unPro) {
        if (unPro.isEmpty()) {
            return 1;
        }
        int digit = unPro.charAt(0) - '0';
        int count =0;// this will convert character in to digit
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // it will gives the letter as a + 1 = 98 = 'b'
           count = count + count(pro + ch, unPro.substring(1));
        }
        return count;
    }
}
