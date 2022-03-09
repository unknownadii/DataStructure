package Searching.BinarySearch.Questions;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(arr, target));
    }

    static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //If answer is not found than
        // the end index is at value which is less than target value
        return letters[start % letters.length];
    }
}
