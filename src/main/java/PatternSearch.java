import java.util.*;
public class PatternSearch {
    private int[] x = {-1, -1, -1, 0, 0, 1, 1, 1 };
    private int[] y = {-1, 0, 1, -1, 1, -1, 0, 1 };
    private char[][] grid;
    private char[][] words;
    private ArrayList<String> path = new ArrayList<>();

    //private String word;

    public PatternSearch(char[][] grid, char[][] words) {
        this.grid = grid;
        this.words = words;
    }


    // TODO: do another function isAround() that is not recursive :(

    public boolean isAround (int x0, int y0, char[] word){
        this.path.add("(" + x0 + "," + y0 + ")");

        if (word.length == 1) {
        //    System.out.println("**************");
            return (true);        // the whole word was found!
        }


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
                    //this.path.add("(" + row + "," + col + ")");
   //                 System.out.println("letter " + word[1] + " was found at position (" + row + "," + col + ").");
    //                System.out.println("array is of length " + word.length);
                    if (isAround(row, col, Arrays.copyOfRange(word, 1, word.length))) {
    //                    System.out.println("TRUE");
    //                    return (true);
                        printPath(new String(word), this.path);
                        this.path.clear();
                        System.out.println("\n");
                    }


                    // if (word.length > 2) {
                  //     isAround(row, col, Arrays.copyOfRange(word, 1, word.length));
                  // } else {
                  //     System.out.println("**************");
                  //     return (true);        // the whole word was found!
                  //     // recursive function calls the whole stack of precedent isAround so it doesn't return true at the end.

                  // }

                }
            }
        }
    //    System.out.println("False!");
        if (this.path.size()>=1) {
            this.path.remove(this.path.size() - 1);
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
                        if (isAround(m, n, words[i])) {
        //                    System.out.println("SUCCES! The word " + new String(words[i]) + " was found at position \n");
        //                    System.out.println(this.path);
        //                    printPath(new String(words[i]), this.path);
        //                   this.path.clear();
                            System.out.println("\n");

                        } else {
        //                    System.out.println("the word " + new String(words[i]) + " was not found at position (" + + m + "," + n + "). \n");
                        }
                    }
                }
            }
        }
    }


    public void printPath(String word, ArrayList path) {
        System.out.print(word + " ");
        for (int i=0; i< path.size()-1; i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println(path.get(path.size()-1));

    }


}
