import java.util.ArrayList;

public class Grid {
    private int height;
    private int width;
    private char[][] grid;
    private ArrayList<String> words;

    /**
     * Constructor for Grid
     * @param height the number of lines of the grid
     * @param width the number of rows of the grid
     * @param grid the grid of letters
     * @param words the list of words to find
     */
    public Grid(int height, int width, char[][] grid, ArrayList<String> words) {
        this.height = height;
        this.width = width;
        this.grid = grid;
        this.words = words;
    }


    //      Getters & Setters
    public char[][] getGrid() {return grid;}
    public ArrayList<String> getWords() {return words;}




}

