//count number of zeros in number exception value should not atart with 0

package Recursion;
public class CountZeroInNumber {
    public static void main(String[] args) {
        System.out.println(count(10010, 0));
    }

    static int count(int n, int count) {
        if (n == 0) {
            return count;
        }
        int rem = n % 10;
        if (rem == 0) {
            return  count(n / 10, count + 1);
        }
        return count(n / 10, count);

    }
}
