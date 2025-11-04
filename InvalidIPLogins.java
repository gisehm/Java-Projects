import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Fail2Ban
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //logs_processed.txt written 1st in command line argument
        File f = new File(args[0]);
        //output.txt written 2nd in command line argument
        PrintWriter output = new PrintWriter(args[1]);
        //Scans and reads info in logs_processed.txt
        Scanner input = new Scanner(f);

        //initializing for lineNumber
        int lineNumber = 0;
        //Initializing for ip address which will be a String
        String ip = "";

        //Creating ArrayList to hold all invalid IP adresses(Strings)
        ArrayList<String> invalidIP = new ArrayList<>();
        /*creating HashMap to hold elements(invalidIP) as keys 
        and occurrences as values*/
        HashMap<String, Integer> invalidIPS = new HashMap<>();
        
        //while logs_processed.txt has a next line
        while(input.hasNextLine())
        {
            //that line is scanned/read
            String line = input.nextLine();
            //Splitting the line based on spaces
            String[] splitStr = line.split(" ");
            //increasing lineNumber to keep going through lines
            lineNumber++;

            //if on the line, the word invalid is present
            if(line.contains("Invalid"))
            {
                //the String ip address is found in index [9]
                ip = splitStr[9];
                //adding that value to our ArrayList
                invalidIP.add(ip); 
            }
        }                  

        //enhanced for loop to count occurrences of each IP address
        //IP addresses used as keys and occurrences used as values
        for(String x : invalidIP)
        {

            if(invalidIPS.get(x) == null)
            {
                //if IP isn't in the HashMap, count is 1
                invalidIPS.put(x, 1);
            }
            else
            {
                //else if IP is in HashMap, increase the count
                invalidIPS.put(x, invalidIPS.get(x) + 1);
            }
        }

        //Get entries from the HashMap
        Set<Entry<String, Integer>> entrySet = invalidIPS.entrySet();
        //Going through the entries
        for(Entry<String, Integer> entry : entrySet)
        {
            //if IP appeared 3 or more times
            if(entry.getValue() >= 3)
            {
                //print out the IP
                output.println(entry.getKey());
            }
        }

        //close input and output
        input.close();
        output.close();
    }
}
