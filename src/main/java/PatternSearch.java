import java.util.*;
public class PatternSearch {
    private int[] x = {-1, -1, -1, 0, 0, 1, 1, 1 };
    private int[] y = {-1, 0, 1, -1, 1, -1, 0, 1 };
    private char[][] grid;
    private char[][] words;

    //private String word;

    public PatternSearch(char[][] grid, char[][] words) {
        this.grid = grid;
        this.words = words;
    }


    public boolean isAround (int x0, int y0, char[] word){
        // Convert word in a char Array
        //char[] word = wordString.toCharArray();




       // if (grid[row][col] != word[0]) {
       //     return false;
       // }



        for (int move = 0; move<8; move++){
            int row = x0 + x[move];
            int col = y0 + y[move];
            if (row >= 0 && row < this.grid.length && col >= 0 && col < this.grid[0].length) {
                System.out.println("searching for letter " + word[1] + " at position (" + row + "," + col + ").");

                if (this.grid[row][col] == word[1]) {
                    System.out.println("letter " + word[1] + " was found at position (" + row + "," + col + ").");
                    System.out.println("array is of length " + word.length);
                    if (word.length > 2) {
                        isAround(row, col, Arrays.copyOfRange(word, 1, word.length));
                    } else {
                        System.out.println("**************");
                        return (true);        // the whole word was found!
                        // recursive function calls the whole stack of precedent isAround so it doesn't return true at the end.

                    }

                }
            }
        }
        return (false);
    }

    public void search() {
        for (int i = 0; i < this.words.length; i++) {
            char first = words[i][0];
            for (int m = 0; m < grid.length; m++) {
                for (int n = 0; n < grid[m].length; n++) {
                    if (grid[m][n] == first) {  // we have the position of the first letter of the word.
                        System.out.println("letter " + first + " is at position (" + m + "," + n + ").");
                        System.out.println(isAround(m, n, words[i]));
                        if (isAround(m, n, words[i])) {
                            System.out.println("SUCCES! The word " + new String(words[i]) + " was found at position \n");
                        } else {
                            System.out.println("the word " + new String(words[i]) + " was not found at position (" + + m + "," + n + "). \n");
                        }
                    }
                }
            }


        }
    }



}
