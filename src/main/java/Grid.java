import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grid {
    private int height;
    private int width;
    private char[] grid;
    private ArrayList<String> words;


    //      Getters & Setters
    public int getHeight(){return this.height;}

    public int getWidth() {return width;}

    public char[] getGrid() {return grid;}
    public ArrayList<String> getWords() {return words;}
    public void setHeight(int height){this.height = height;}
    public void setWidth(int width){this.width = width;}
    public void setGrid(char[] grid) {this.grid = grid;}
    public void setWords(ArrayList<String> words) {this.words = words;}

    // File reader
    public void fileReader(String filePath) throws FileNotFoundException {
        File textFile = new File(filePath);
        Scanner reader = new Scanner(textFile);
        while (reader.hasNextLine()) {
            System.out.println(reader.nextLine());
        }

    }


}
