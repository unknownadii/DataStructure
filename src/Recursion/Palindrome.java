// Same as Reverse a Number
package Recursion;
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(121));
    }

    static Boolean palindrome(int n) {

        int power = (int) (Math.log10(n)) + 1;// it will gives the no of digit in integer
        int num = helper(n, power);
        if (num == n) {
            return true;
        }
        return false;

    }

    private static int helper(int n, int power) {
        if (n == 0) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, power - 1)) + helper(n / 10, power - 1);
    }
}
