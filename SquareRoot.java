/*
Giselle Muriel
Babylonian method to compute square root
 */
public class SquareRoot
{
    public static final double EPSILON = 1e-7;

    public static double sqrt(double num, double epsilon)
    {
        //if our number is negative or not a number
        if(num < 0 || Double.isNaN(num))
        {
            //return the non-number value we input
            return Double.NaN;
        }

        //if the number is infinite or equal to 0
        if(num == Double.POSITIVE_INFINITY || num == 0)
        {
            //return back the number
            return num;
        }

        //stating our current number which is the one we input
        double currentGuess = num;
        //initializing to whatever number
        double previousGuess = 0;

        //Babylonian method for square root
        while(Math.abs(currentGuess - previousGuess) > epsilon)
        {
            previousGuess = currentGuess;
            currentGuess = .5 * (previousGuess + (num / previousGuess));
        }

        //returns the answer we get based on the input
        return currentGuess;
    }

    //where the output shows through the terminal
    public static void main(String[] args)
    {
        //if we offer more than two arguments or less than one
        if(args.length > 2 || args.length < 1)
        {
            //There will be an error
            System.err.println("Usage: java SquareRoot <value> [epsilon]");
            System.exit(1);
        }

        //using try in order to call error if the input isn't parseable
        try
        {
            //the number must be parsed to a double
            double num = Double.parseDouble(args[0]);
            //declaring our epsilon variable
            double epsilon;

            //if we include two arguments
            if(args.length == 2)
            {
                //our epsilon would be the second argument
                epsilon = Double.parseDouble(args[1]);

                //if epsilon isn't positive
                if(epsilon <= 0 || Double.isNaN(epsilon))
                {
                    //There will be an error
                    System.err.println("Error: Epsilon argument must be a positive double.");
                    System.exit(1);
                }
            }
            else
            {
                //if the argument length isn't 2, the epsilon will be 1e-7
                epsilon = EPSILON;
            }

            //result based on the arguments we input
            double result = sqrt(num, epsilon);

            //printed out with capacity to hold 8 decimal places
            System.out.printf("%.8f%n", result);
        }
        catch(NumberFormatException e)
        {
            //if it can't be parsed to a double there will be an error
            System.err.println("Error: Value argument must be a double.");
            System.exit(1);
        }
    }
}
