import java.util.*;
public class PatternSearch {
    private int[] x = {0,-1, -1, -1, 0, 0, 1, 1, 1 };       //Horizontal directions to look for a matching character
    private int[] y = {0,-1, 0, 1, -1, 1, -1, 0, 1 };       //vertical directions to look for a matching character
    private char[][] grid;
    private char[][] words;


    public PatternSearch(char[][] grid, char[][] words) {
        this.grid = grid;
        this.words = words;
    }



    /**
     * Finds a given word around a first character in a character grid, and prints the path if found
     * @param x0 the vertical position of the first character of the word
     * @param y0 the horizontal position of the first character of the word
     * @param word the word to search
     * @param path a Path object containing the word to search, and initially no coordinates
     * @param length the length of the word to search
     */
    public void findWord(int x0, int y0, char[] word, Path path, int length) {
        int pathLength = length-word.length;
        path.adjustPath(pathLength);        // Adjust the path to keep only the good coordinates

        if (this.grid[x0][y0] == word[0]) {
            // Add the coordinates to the path
            path.enqueue("(" + x0 + "," + y0 + ")");

            // If it's the last character of the word, the whole word was found. The path is printed
            if (word.length == 1) {;
                path.printPath();

            } else {
                // Try to find the next character at each of the 9 possibilities around the character
                for (int move = 0; move<x.length; move++) {
                    int row = x0 + x[move];
                    int col = y0 + y[move];
                    // Keep only the positions that are included in the grid
                    if (row >= 0 && row < this.grid.length && col >= 0 && col < this.grid[0].length) {

                        // Recursively search for the rest of the word at this position
                        findWord(row, col, Arrays.copyOfRange(word, 1, word.length), path, length);

                    }
                }
            }
        }
    }


    /**
     * Finds all the words to search in a 2D characters grid, and prints their path
     */
    public void search() {
        // Create a Path object to add the coordinates that will be found
        for (int i = 0; i < this.words.length; i++) {
            Path path = new Path(new String(words[i]));

            char first = words[i][0];

            // Search through the whole grid for the first character of the word
            for (int m = 0; m < grid.length; m++) {
                for (int n = 0; n < grid[m].length; n++) {

                    if (grid[m][n] == first) {  // The first character was found at this position

                        // Search for the rest of the word around the first character
                        findWord(m, n, words[i], path, words[i].length);
                    }
                }
            }
        }
    }


}
