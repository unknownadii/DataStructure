package Recursion.SubsetSubsequenceString.Permutation.CompanyQuestions;

/*
Questions :- print all combination on which the sum is 4 when a dice role;
example :- for 4 ( 4, 22,31,112,1111,)
 */
public class DiceRoll {
    public static void main(String[] args) {
        dice("",4);
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
}
