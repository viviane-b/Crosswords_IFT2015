import java.util.*;
public class PatternSearch {
    private int[] x = {-1, -1, -1, 0, 0, 1, 1, 1 };
    private int[] y = {-1, 0, 1, -1, 1, -1, 0, 1 };
    private char[][] grid;
    private char[][] words;
    //private ArrayList<String> path = new ArrayList<>();

    //private String word;


    public PatternSearch(char[][] grid, char[][] words) {
        this.grid = grid;
        this.words = words;
    }


    // TODO: do another function isAround() that is not recursive :(


    public boolean isAround2 (int x0, int y0, char[] word) {
        for (int move = 0; move<8; move++) {
            int i;
            int row = x0 + x[move];
            int col = y0 + y[move];

            for (i = 1; i < word.length; i++) {
                if (row < 0 || row >= this.grid.length || col < 0 || col >= this.grid[0].length) {
                    break;
                }
                if (this.grid[row][col] != word[i]) {
                    break;
                }
                System.out.println("letter " + word[i] + " was found at position (" + row + "," + col + ").");
                //row += x[move];
                //col += y[move];
            }
            if (i == word.length) {
                System.out.println("SUCCESS for word " + new String(word) + "\n");
                return true;
            }
        }
        return false;
    }



    public boolean isAround (int x0, int y0, char[] word, Path path){
        //path.setList(path.getList().add("(" + x0 + "," + y0 + ")"));
        path.add("(" + x0 + "," + y0 + ")");

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
                 //   if (isAround(row, col, Arrays.copyOfRange(word, 1, word.length))) {
    //           //         System.out.println("TRUE");
    //           //         return (true);
                 //       printPath(new String(word), this.path);
                 //       this.path.clear();
                 //       System.out.println("\n");
                 //   }
                    if (word.length > 2) {
                      isAround(row, col, Arrays.copyOfRange(word, 1, word.length), path);
                    } else {
                      System.out.println("**************");
                      path.printPath();
                 //     this.path.clear();
                      return (true);        // the whole word was found!
                      // recursive function calls the whole stack of precedent isAround so it doesn't return true at the end.

                    }

                }
            }
        }
    //    System.out.println("False!");
        if (path.getList().size()>=1) {
            path.removeLast();
        }
        return (false);
    }

    public void findWord1(int x0, int y0, char[] word, Path path) {

        if (this.grid[x0][y0] == word[0]) {
            System.out.println("letter " + word[0] + " was found at position (" + x0 + "," + y0 + ").");
            path.enqueue("(" + x0 + "," + y0 + ")");
            if (word.length == 1) {;
                path.printPath1();
            } else {
                for (int move = 0; move<8; move++) {
                    int row = x0 + x[move];
                    int col = y0 + y[move];
                    if (row >= 0 && row < this.grid.length && col >= 0 && col < this.grid[0].length) {
                        findWord1(row, col, Arrays.copyOfRange(word, 1, word.length), path);
                    }
                }
                if (path.getList().size() != 0) {
                    path.removeLast();
                }
            }
        }

        // check if the character matches
        // if true:
        //      add the coordinates to the queue
        //      check if it's the last character: printPath
        //      for all the directions:
        //          recursive call of the function on the rest of the word
        // if false:
        //      pass
    }
    public void findWord(int x0, int y0, char[] word, Path path, int length) {
        int pathLength = length-word.length;
        path.adjustPath(pathLength);
        if (this.grid[x0][y0] == word[0]) {
            System.out.println("letter " + word[0] + " was found at position (" + x0 + "," + y0 + ").");
            path.enqueue("(" + x0 + "," + y0 + ")");
            if (word.length == 1) {;
                path.printPath();
            } else {
                for (int move = 0; move<8; move++) {
                    int row = x0 + x[move];
                    int col = y0 + y[move];
                    if (row >= 0 && row < this.grid.length && col >= 0 && col < this.grid[0].length) {
                        findWord(row, col, Arrays.copyOfRange(word, 1, word.length), path, length);

                    }
                }
            }
        }
    }




    // TODO: put the paths in a tree and then print each leave of the tree with ancestors?


    public void search() {
        for (int i = 0; i < this.words.length; i++) {
            Path path = new Path(new String(words[i]));

            char first = words[i][0];
            for (int m = 0; m < grid.length; m++) {
                for (int n = 0; n < grid[m].length; n++) {
                    if (grid[m][n] == first) {  // we have the position of the first letter of the word.
                        System.out.println("letter " + first + " is at position (" + m + "," + n + ").");
                        findWord(m, n, words[i], path, words[i].length);
        //                if (isAround(m, n, words[i], path)) {
        //                    System.out.println("SUCCESS! The word " + new String(words[i]) + " was found at position \n");
        //                    System.out.println(this.path);
        //                    printPath(new String(words[i]), this.path);
        //                   this.path.clear();
                            System.out.println("\n");

        //                } else {
        //                    System.out.println("the word " + new String(words[i]) + " was not found at position (" + + m + "," + n + "). \n");
         //               }
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
