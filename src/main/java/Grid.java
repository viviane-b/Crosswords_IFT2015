import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Grid {
    private int height;
    private int width;
    private char[][] grid;
    private ArrayList<String> words;


    //      Getters & Setters
    public int getHeight(){return this.height;}
    public int getWidth() {return width;}
    public char[][] getGrid() {return grid;}
    public ArrayList<String> getWords() {return words;}
    public void setHeight(int height){this.height = height;}
    public void setWidth(int width){this.width = width;}
    public void setGrid(char[][] grid) {this.grid = grid;}
    public void setWords(ArrayList<String> words) {this.words = words;}

    // File reader
    public void readFile(String filePath) throws FileNotFoundException {
        File textFile = new File(filePath);
        Scanner reader = new Scanner(textFile);

      //  while (reader.hasNextLine()) {
      //      String line = reader.nextLine();
      //      String[] parts = line.split(" ");
      //      setHeight(parseInt(parts[0]));
      //      setWidth(parseInt(parts[1]));
      //      System.out.println(parts);
      //  }

        // Height and width
        String line = reader.nextLine();
        String[] numbers = line.split(" ");
        setHeight(parseInt(numbers[0]));
        setWidth(parseInt(numbers[1]));
       // ArrayList<Character> grid = new ArrayList<>();
         char[][] lettersGrid = new char[getHeight()][getWidth()];
        setGrid(lettersGrid);

        // Letters
        for (int i = 0; i < this.getHeight(); i++) {
            line = reader.nextLine();
            String[] lettersList = line.split(" ");
            char[] letters = String.join("", lettersList).toCharArray();
            grid[i] = letters;

            }

        System.out.println(grid[0][2]);


        // Words
        line = reader.nextLine();
        String[] wordsList = line.split(" ");
        ArrayList<String> wordsArray = new ArrayList<>();

        for (int i = 0; i < wordsList.length; i++) {
            wordsArray.add(i, wordsList[i]);

        }
        this.setWords(wordsArray);
        System.out.println(words);

    }

}

/* class Words
* class Grid: height, width, letters
*
 */