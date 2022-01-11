package Recursion;

public class SumNto1 {
    public static void main(String[] args) {
        System.out.println(sumNTo1(5));
    }

    static int sumNTo1(int n) {
        if (n <= 1) {
            return 1;
        }
        return n + sumNTo1(n - 1);
    }
}
