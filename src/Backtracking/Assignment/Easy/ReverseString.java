package Backtracking.Assignment.Easy;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] ch = {'a','b','c'};
        reverseString(ch);

    }

    static void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    private static void reverse(char[] ch, int s, int e) {
        if (s > e) {
            System.out.println(Arrays.toString(ch));
            return;
        }
        char c = ch[s];
        ch[s] = ch[e];
        ch[e] = c;
        reverse(ch, s + 1, e - 1);
    }
}
