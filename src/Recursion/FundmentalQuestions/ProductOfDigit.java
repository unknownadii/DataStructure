package Recursion.FundmentalQuestions;

public class ProductOfDigit {
    public static void main(String[] args) {
        // System.out.println(sumOfDigit(13245, 0));
        System.out.println(productOfDigit2(13245));
    }

    static int productOfDigit(int n, int sum) {
        if (n <= 0) {
            return sum;
        }
        int a = n % 10;
        sum = sum * a;
        int num = n / 10;
        return productOfDigit(num, sum);
    }

    static int productOfDigit2(int n) {
        if (n == 0) {
            return 1;
        }
        return n % 10 * productOfDigit2(n / 10);
    }
}
