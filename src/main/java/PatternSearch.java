public class PatternSearch {
    private int[] x = {-1, -1, -1, 0, 0, 1, 1, 1 };
    private int[] y = {-1, 0, 1, -1, 1, -1, 0, 1 };
    private char[][] grid;
    private String word;

    public PatternSearch(char[][] grid, String word) {
        this.grid = grid;
        this.word = word;
    }

    private boolean searchAround (char[][] grid, int row, int col, String word){
        // validation
        if (grid[row][col] != word.charAt(0)) {
            return false;
        }
        else {
            return true;
        }
    }



}
