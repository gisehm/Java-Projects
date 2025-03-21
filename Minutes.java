/* Giselle Muriel 
 * Minutes.java - calculates the number of minutes of a specific amount of time
 */
import java.util.Scanner;

public class Minutes 
{
    public static final void main(String[] args) 
    {
        Scanner out = new Scanner(System.in);

        //prints "Hours: " for you to input the hours you will calculate into minutes
        System.out.print("Hours: ");
        int a = out.nextInt();  
        //the process above is the same for the rest
        System.out.print("Days: ");
        int b = out.nextInt();

        System.out.print("Weeks: ");
        int c = out.nextInt();

        System.out.print("Years: ");
        int d = out.nextInt();
    
        //outputs the overall sum of the measures of time, calculated into minutes
        System.out.println((a * 60) + (b * 1440) + (c * 10080) + (d * 525600));
    }    
}
