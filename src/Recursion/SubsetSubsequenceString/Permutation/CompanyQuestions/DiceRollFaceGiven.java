package Recursion.SubsetSubsequenceString.Permutation.CompanyQuestions;

public class DiceRollFaceGiven {
    public static void main(String[] args) {
        dice("", 9,20);
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
}
