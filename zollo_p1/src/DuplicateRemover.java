import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

// Class containing instance variable for a set of unique words, and functions to read and write to and from the set
public class DuplicateRemover {

    // HashSet used to store list of unique words
    // HashSet is used as it has built in functionality that it will not add duplicate elements to the set
    private HashSet<String> uniqueWords = new HashSet<String>();

    // Function used to store unique words from a given data file
    public void remove(String dataFile) {

        // FileInputStream and Scanner are initialized to null to avoid issues with exception handling
        FileInputStream inputStream = null;
        Scanner scanFile = null;
        try {

            // Scanner is made to read input from the input stream for the given file
            inputStream = new FileInputStream(dataFile);
            scanFile = new Scanner(inputStream);

            // While loop that adds every unique word to HashSet until Scanner reaches the end of file
            while (scanFile.hasNext()) {
                uniqueWords.add(scanFile.next());
            }
        }

        // Displays error message if any errors occurred while reading the input file
        catch(IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        // Whether or not exception is thrown, closes objects at end of method
        finally {

            // Compiler was displaying unhandled exceptions when closing objects, so additional try is needed
            try {

                // Objects are only closed if they are not null
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

    // Method used to write the set of unique words to a specified output file
    public void write(String outputFile) throws IOException {

        // FileOutputStream and PrintWriter initialized to null to avoid issues with exception handling
        FileOutputStream outputStream = null;
        PrintWriter writer = null;
        try {
            // writer is made to write into the text file specified by method parameter
            outputStream = new FileOutputStream(outputFile);
            writer = new PrintWriter(outputStream);

            // Iterator is created for the HashSet of unique words to access its elements
            Iterator iterateWords = uniqueWords.iterator();

            // Prints every element of HashSet on its own line until there are no more words to be printed
            while (iterateWords.hasNext()) {
                writer.println(iterateWords.next());
            }
            writer.flush();
        }

        // Displays error message if any errors occurred while printing HashSet into output file
        catch(IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        // Whether or not exception is thrown, closes objects at end of method
        finally {

            // Additional try is used to handle exceptions thrown when closing objects
            try {

                // Objects are only closed if they are not equal to null
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