// Find the Fibonacci number by recursion
// example :- 0 1 1 2 3 5 8 13 .....n
// formula 0 ,1  n = (n-1) + (n-2)

package Recursion.FundmentalQuestions;

import java.util.Scanner;

public class FibonaciiNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(fibonocii(n));
    }

    private static int fibonocii( int n) {
        if (n<2)
        {
            return n;
        }
        return fibonocii(n-1) + fibonocii(n-2);
    }
}
// output :- It will gives the nth fibonacci number
