/* Giselle Muriel
 * F2C.java - converts fahrenheit to celsius
 */
import java.util.Scanner;

public class F2C 
{
    public static final void main(String[] args) 
    {
        Scanner out = new Scanner(System.in);
        
        //prints out this message in the terminal
        System.out.print("Give me a temperature in Fahrenheit: ");   
        //allows you to input a value, in this case represented by g
        int g = out.nextInt();   
        //value is then put through the equation to convert fahrenheit to celsius
        System.out.println((g - 32) * 5/9); 
    }  
}
