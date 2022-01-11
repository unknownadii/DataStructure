// Do it with out converting it in to String
package Recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        reverse(1234);
        System.out.println(sum);
        System.out.println(reverse2(1));
    }

    static int sum = 0;

    static void reverse(int n) {
        if (n == 0) {
            return;
        }
        int r = n % 10;
        sum = sum * 10 + r;
        reverse(n / 10);
    }

    static int reverse2(int n) {
        int power = (int) (Math.log10(n)) + 1;// it will gives the no of digit in integer
        return helper(n, power);
    }

    private static int helper(int n, int power) {
        if (n == 0) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, power - 1)) + helper(n / 10, power - 1);
    }
}
