package Recursion.SubsetSubsequenceString.SubsetAnsSubsequence;

public class SubsequenceWithAscii {
    public static void main(String[] args) {
        subSequenceAscii("abc","");
        // How to find the ascci of a number ?
        char c = 'a';
        System.out.println(c + 0 ); //it will all ascii cide of 'a' with 0
    }

    static void subSequenceAscii(String pro ,String store)
    {
        if (pro.isEmpty())
        {
            System.out.println(store);
            return;
        }
        char ch = pro.charAt(0);
        subSequenceAscii(pro.substring(1), store);// choice of not adding/coming
        subSequenceAscii(pro.substring(1), store + ch); // choice of adding/coming
        subSequenceAscii(pro.substring(1), store + (ch + 0)); // choice of Ascii adding
    }
}
