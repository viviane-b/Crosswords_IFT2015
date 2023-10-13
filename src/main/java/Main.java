import java.io.FileNotFoundException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Grid myGrid = new Grid();
        char[][] grid = {};


        try {
            myGrid.readFile("C:\\_Code\\courses\\IFT2015_TP1\\src\\main\\resources\\TP1Input");
            grid = myGrid.getGrid();

            System.out.println(grid[1][2]);





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Words myWords = new Words(myGrid.getWords());
        // Sort the words
        myWords.sort();
        char[][] wordsChar= myWords.stringsToChars(myWords.getWords());
        System.out.println(new String(wordsChar[0]) + "qwerty");

        PatternSearch wordSearch = new PatternSearch(grid, wordsChar);
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

         */


        System.out.println(myWords.getWords());

        System.out.println(myGrid.getHeight());


        // Find the words


    }
}
