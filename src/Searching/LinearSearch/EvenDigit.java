package Searching.LinearSearch;
// Find Numbers with Even Number of Digits
public class EvenDigit {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

    static int findNumbers(int[] nums) {
        int count =0 ;
        for(int num : nums) {
            if(even(num)) {
                count++;
            }
        }
        return count;
    }
    // It will return if the digit is even otr not
    static boolean even(int num) {
        if (num<0) {
            num=num*-1;//when number is negative
        }
        String str= Integer.toString(num);
        if (str.length() %2 ==0) {
            return true;
        }
        return false;
    }
}
