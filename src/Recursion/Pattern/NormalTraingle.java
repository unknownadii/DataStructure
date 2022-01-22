package Recursion.Pattern;

/*

*
* *
* * *
* * * *
* * * * *

 */
public class NormalTraingle {
    public static void main(String[] args) {
        traingle(10,0);
    }

    static void traingle(int r ,int c)
    {
        if (r==0) {
            return;
        }
        // for current Row
        if (c < r) {
            traingle(r,c+1);
            System.out.print("*");
        }
        // for changing Row
        else {
            traingle(r-1,0);
            System.out.println();
        }
    }
}
