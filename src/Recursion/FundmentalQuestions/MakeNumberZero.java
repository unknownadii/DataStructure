/*
question :- Number of steps are required to make a number 0:-
Condition = In one step , if the number is even divide it with 0 , otherwise
Subtract it with 1
 */

package Recursion.FundmentalQuestions;
public class MakeNumberZero {
    public static void main(String[] args) {
        System.out.println(stepsToZero(5));

    }
    static int stepsToZero(int n )
    {
        return helper(n,0);
    }
    static int helper(int n , int steps)
    {
       if(n==0)
       {
           return steps;
       }
       if (n%2==0)
       {
           return helper(n/2,steps+1);
       }
       return helper(n-1,steps+1);
    }
}

