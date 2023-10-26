import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<Grid> grids = new ArrayList<>();
        FileReader fileReader = new FileReader();

        // Read the file and create a Grid object for each grid in the file, and put them in the ArrayList grids.
        try {
            grids = fileReader.readFile(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        for (int i = 0; i < grids.size(); i++) {
            Grid theGrid = grids.get(i);
            char[][] grid = theGrid.getGrid();
            Words theWords = new Words(theGrid.getWords());

            // Sort the words, and then convert the ArrayList<String> to a char[][]
            theWords.sort();
            char[][] wordsChar = theWords.stringsToChars(theWords.getWords());

            // Search every word in the grid, and print the output
            PatternSearch wordSearch = new PatternSearch(grid, wordsChar);
            System.out.println("Query " + (i+1) + ":");
            wordSearch.search();

        }

    }
}
