import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FileReader {
    private String filePath;

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
            char[][] lettersGrid = new char[height][width];

            // Letters
            for (int i = 0; i < height; i++) {
                line = reader.nextLine();
                String[] lettersList = line.split(" ");
                char[] letters = String.join("", lettersList).toCharArray();
                lettersGrid[i] = letters;

            }

//            System.out.println(lettersGrid[0][2]);


            // Words
            line = reader.nextLine();
            String[] wordsList = line.split(" ");
            ArrayList<String> wordsArray = new ArrayList<>();

            for (int i = 0; i < wordsList.length; i++) {
                wordsArray.add(i, wordsList[i]);

            }
 //           System.out.println(wordsArray);
            grids.add(new Grid(height, width, lettersGrid, wordsArray));
        }


        return grids;


    }
}

