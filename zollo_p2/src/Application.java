import java.io.IOException;

public class Application {

    // Main method used to specify input and output file and call DuplicateCounter methods for testing
    public static void main(String[] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        // Input and output file names are specified as string literals
        String inputFileName = "problem2.txt";
        String outputFileName = "unique_word_counts.txt";

        // Try used to handle exceptions calling DuplicateRemover methods
        try {

            // Calls the remove method from DuplicateRemover with the specified input file name
            duplicateCounter.count(inputFileName);

            // Calls write method from DuplicateRemover with specified file name
            duplicateCounter.write(outputFileName);
        }
        catch(IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}