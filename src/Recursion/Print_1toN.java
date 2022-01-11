package Recursion;

public class Print_1toN {
    public static void main(String[] args) {
        oneToN(6);
    }

    static void oneToN(int n)
    {
        if(n==0)
        {
            return;
        }
        oneToN(n-1);
        System.out.println(n);
    }
}
