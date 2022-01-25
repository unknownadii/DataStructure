package Recursion.SubsetSubsequenceString.SubsetAnsSubsequence;

public class SubsequenceOfabcAddInArrayList {
    public static void main(String[] args) {
        subSequence("abc","");
    }

    static void subSequence(String pro ,String store)
    {
        if (pro.isEmpty())
        {
            System.out.println(store);
            return;
        }
        char ch = pro.charAt(0);
        subSequence(pro.substring(1), store);// choice of not adding/coming
        subSequence(pro.substring(1), store + ch); // choice of adding/coming
    }
}
