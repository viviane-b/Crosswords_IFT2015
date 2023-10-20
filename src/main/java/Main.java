import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
    //    Grid myGrid = new Grid();
    //    char[][] grid = {};
        ArrayList<Grid> grids = new ArrayList<>();
        FileReader fileReader = new FileReader();


        try {
            grids = fileReader.readFile("C:\\_Code\\courses\\IFT2015_TP1\\src\\main\\resources\\TP1Input");
    //        grid = myGrid.getGrid();

    //        System.out.println(grid[1][2]);





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < grids.size(); i++) {
            Grid theGrid = grids.get(i);
            char[][] grid = theGrid.getGrid();
            Words myWords = new Words(theGrid.getWords());
            // Sort the words
            myWords.sort();
            char[][] wordsChar = myWords.stringsToChars(myWords.getWords());

            PatternSearch wordSearch = new PatternSearch(grid, wordsChar);
            System.out.println("Query " + (i+1) + ":");
            wordSearch.search();

        /* Search the words
        for (int i = 0; i< myWords.getWords().size(); i++) {
            char first = myWords.getWords().get(i).charAt(0);
            for (int m = 0; m < grid.length; m++) {
                for (int n = 0; n < grid[m].length; n++) {
                    if (grid[m][n] == (first)) {  // we have the position of the first letter of the word.
                        System.out.println("letter " + first + " is at position (" + m +"," + n + ").");


                        // look for the rest of the word
                        PatternSearch search = new PatternSearch();
                        if (search.isAround(grid, m, n, myWords.getWords().get(i).toCharArray())) {
                            System.out.println("the word " + myWords.getWords().get(i) + "was found!");
                        }



                    }
                }
            }

        }




            System.out.println(myWords.getWords());

            System.out.println(theGrid.getHeight());
         */


            // Find the words
        }

    }
}
