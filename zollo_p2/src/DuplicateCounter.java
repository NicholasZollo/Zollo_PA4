import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

// Class containing map for unique words and the count for each word,
// and methods to read from input file and print to output file
public class DuplicateCounter {

    // HashMap used to store all unique words from input file and the count of each word
    // HashMap is used for its ability to store pairs of String and Integer variables
    private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    // Method used to read input file and store all unique words and count the number of times they appear
    public void count(String dataFile) throws IOException {

        // FileInputStream and Scanner are initialized to null to assist with exception handling
        FileInputStream inputStream = null;
        Scanner scanFile = null;

        // Variables used to store the current String and its current count when going through input file
        Integer currCount;
        String currString;
        try {

            // Scanner is made to read input from the specified input file
            inputStream = new FileInputStream(dataFile);
            scanFile = new Scanner(inputStream);

            // While loop that iterates once for every word in input file until it reaches end of file
            while (scanFile.hasNext()) {

                // scanFile.next() is saved into currString variable to avoid executing multiple times
                currString = scanFile.next();

                // Sets currCount variable to the value corresponding to the currString key in wordCounter
                currCount = wordCounter.get(currString);

                // If current word has appeared for first time, currCount will be set to null
                // If this is the case, we set it to 0 so it can be incremented
                if(currCount == null) {
                    currCount = 0;
                }

                // Puts mapping with current word into wordCounter while incrementing the count by 1
                wordCounter.put(currString, currCount + 1);
            }
        }

        // Displays error message if IOException thrown while scanning through specified input file
        catch(IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        // Whether or not exception was thrown, closes all non-null objects at end of method execution
        finally {

            // Extra try/catch used to handle IOExceptions that come up when closing objects
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
                if(scanFile != null) {
                    scanFile.close();
                }
            }
            catch(IOException e) {
                System.out.println("Caught IOException: " + e.getMessage());
            }
        }
    }

    // Method used to write all unique words and their counts from HashMap to specified output file
    public void write(String outputFile) throws IOException {

        // FileOutputStream and PrintWriter initialized to null to assist with exception handling
        FileOutputStream outputStream = null;
        PrintWriter writer = null;

        // Variable that stores the integer count for each unique word
        int keyCount;
        try {

            // writer is made to print into specified output file
            outputStream = new FileOutputStream(outputFile);
            writer = new PrintWriter(outputStream);

            // keySet function is used to create set of only the keys from wordCounter
            Set<String> keys = wordCounter.keySet();

            // Loop that iterates for each key in wordCounter
            for(String key : keys) {

                // Gets the count for the current key, then prints the current key and its count separated by a space
                keyCount = wordCounter.get(key);
                writer.println(key + " " + keyCount);
            }
            writer.flush();
        }

        // Displays error message if exception was thrown while writing to output file
        catch(IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        // Whether or not exception was thrown, closes all non-null objects at end of method execution
        finally {

            // Extra try used to handle exceptions thrown when closing objects
            try {
                if(outputStream != null) {
                    outputStream.close();
                }
                if(writer != null) {
                    writer.close();;
                }
            }
            catch(IOException e) {
                System.out.println("Caught IOException: " + e.getMessage());
            }
        }
    }
}