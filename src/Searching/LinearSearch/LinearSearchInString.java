package Searching.LinearSearch;

public class LinearSearchInString {
    public static void main(String[] args) {
        String str = "Aditya";
        char ch = 'i';
        System.out.println(searchChar(str, ch));
        System.out.println(searchCharForEachLoop(str, ch));
    }

    static boolean searchCharForEachLoop(String str, char ch) {
        if (str.length() == 0) {
            return false;
        }
        for (char i : str.toCharArray()/*It will convert String Array of Character */) {
            if (i == ch) {
                return true;
            }
        }
        return false;
    }

    static boolean searchChar(String str, char ch) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
