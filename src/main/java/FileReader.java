import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FileReader {

    /**
     * Reads a crosswords text file and creates a Grid object for each query
     * @param filePath the path of the crosswords file
     * @return an ArrayList containing the grids
     */
    public ArrayList<Grid> readFile(String filePath) throws FileNotFoundException {
        File textFile = new File(filePath);
        Scanner reader = new Scanner(textFile);
        ArrayList<Grid> grids = new ArrayList<>();

        while (reader.hasNextLine()) {

            // Height and width
            String line = reader.nextLine();
            String[] numbers = line.split(" ");
            int height = (parseInt(numbers[0]));
            int width = (parseInt(numbers[1]));
            // Create a 2D array of characters of the specified height and width
            char[][] lettersGrid = new char[height][width];

            // Put the letters in lettersGrid
            for (int i = 0; i < height; i++) {
                line = reader.nextLine();
                String[] lettersList = line.split(" ");
                char[] letters = String.join("", lettersList).toCharArray();
                lettersGrid[i] = letters;

            }

            // Words to search
            line = reader.nextLine();
            String[] wordsList = line.split(" ");
            ArrayList<String> wordsArray = new ArrayList<>();

            // Put the words in an ArrayList
            for (int i = 0; i < wordsList.length; i++) {
                wordsArray.add(i, wordsList[i]);
            }
            grids.add(new Grid(height, width, lettersGrid, wordsArray));
        }

        return grids;
    }
}

