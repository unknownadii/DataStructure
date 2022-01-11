/*
 Sum of Digits
Ex:- 1234
       1+2+3+4=10
Answer = 10
 */

package Recursion.FundmentalQuestions;

public class SumOfDigit {
    public static void main(String[] args) {
       // System.out.println(sumOfDigit(13245, 0));
        System.out.println(sumOfDigit2(13245));
    }

    static int sumOfDigit(int n, int sum) {
        if (n<=0){
            return sum;
        }
        int a = n%10;
        sum = sum + a;
        int num = n/10;
        return sumOfDigit(num ,sum);
    }
    static int sumOfDigit2(int n) {
        if (n==0){
            return 0;
        }
        return n%10 + sumOfDigit2(n/10);
    }
}
