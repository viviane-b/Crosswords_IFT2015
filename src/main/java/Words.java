import java.util.ArrayList;
import java.util.Comparator;

public class Words {
    private ArrayList<String> words;

    /**
     * Constructor for Words
     * @param words the list of words to find
     */
    public Words( ArrayList<String> words) {this.words = words;}

    //      Getters & Setters
    public ArrayList<String> getWords() {return words;}



    /**
     * Converts an ArrayList of Strings to a 2D array of characters
     * @param wordsArray the ArrayList to convert
     * @return the 2D array of characters
     */
    public char[][] stringsToChars (ArrayList<String> wordsArray) {
        char[][] wordsChar = new char[wordsArray.size()][];
        for (int i = 0; i< this.words.size(); i++) {
            char[] word = this.words.get(i).toCharArray();
            wordsChar[i] = word;
        }
        return wordsChar;
    }

    /**
     * Sorts the words by alphabetical order
     */
    public void sort() {
        this.words.sort(Comparator.naturalOrder());
    }

}
