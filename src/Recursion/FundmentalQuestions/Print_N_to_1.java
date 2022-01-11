package Recursion.FundmentalQuestions;

public class Print_N_to_1 {
    public static void main(String[] args) {
      //  nToOne(5);
        nToOneMethod2(6);
    }
    static void nToOne(int n)
    {
        if(n>0)
        {
            System.out.println(n);
            nToOne(n-1);
        }
    }

    static void nToOneMethod2(int n)
    {
        if(n==0)
        {
         return;
        }
            System.out.println(n);
            nToOne(n-1);
    }

}
