import java.io.IOException;

public class Application {

    // Main method used to specify input and output file and call DuplicateRemover methods for testing
    public static void main(String[] args) throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        // Input and output file names are specified as string literals
        String inputFileName = "problem1.txt";
        String outputFileName = "unique_words.txt";

        // Try used to handle exceptions calling DuplicateRemover methods
        try {

            // Calls the remove method from DuplicateRemover with the specified input file name
            duplicateRemover.remove(inputFileName);

            // Calls write method from DuplicateRemover with specified file name
            duplicateRemover.write(outputFileName);
        }
        catch(IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}