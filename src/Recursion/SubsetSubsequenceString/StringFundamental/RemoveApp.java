package Recursion.SubsetSubsequenceString.StringFundamental;

/*
Question 3:- Remove only “app” from the string but don’t delete if it
Is “apple” with contains “app” inside it self.
 */
public class RemoveApp {
    public static void main(String[] args) {
        System.out.println(startsWithAppNotApple("appbcdappeadapple"));
    }

    static String startsWithAppNotApple(String str) {
        if (str.isEmpty()) {
            return " ";
        }
        if (str.startsWith("app") && !str.startsWith("apple")) {
            return startsWithAppNotApple(str.substring(3));
        } else {
            return str.charAt(0)+ startsWithAppNotApple(str.substring(1));
        }
    }
}
