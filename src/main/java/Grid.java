import java.util.ArrayList;

public class Grid {
    private int height;
    private int width;
    private char[][] grid;
    private ArrayList<String> words;
    public Grid(int height, int width, char[][] grid, ArrayList<String> words) {
        this.height = height;
        this.width = width;
        this.grid = grid;
        this.words = words;
    }


    //      Getters & Setters
    public int getHeight(){return this.height;}
    public int getWidth() {return width;}
    public char[][] getGrid() {return grid;}
    public ArrayList<String> getWords() {return words;}
    public void setHeight(int height){this.height = height;}
    public void setWidth(int width){this.width = width;}
    public void setGrid(char[][] grid) {this.grid = grid;}
    public void setWords(ArrayList<String> words) {this.words = words;}



}

