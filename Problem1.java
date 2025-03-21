/* Giselle Muriel 
 * Problem1.java - recursively calculate the value of x^n (x raised to the n power) assuming x and n are both positive integers
 */

public class Problem1
{
    public static int pow(int x, int n)
    {
        if(n == 0)
        {
            return 1;
        }

        return x * pow(x, n - 1);
    }

    public static void main(String[] args)
    {
        int x, n;

        x = Integer.parseInt(args[0]);
        n = Integer.parseInt(args[1]);

        System.out.println(x + " to the " + n + " power = " + pow(x, n));
    }
}
