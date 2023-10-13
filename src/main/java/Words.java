import java.util.ArrayList;
import java.util.Comparator;

public class Words {
    private ArrayList<String> words;
    //private ArrayList<char[]> wordsChar = stringsToChars(words);

    public Words( ArrayList<String> words) {this.words = words;}

    public ArrayList<String> getWords() {return words;}
    public void setWords(ArrayList<String> words) {this.words = words;}
    //public ArrayList<char[]> getWordsChar() {return wordsChar;}

    public char[][] stringsToChars (ArrayList<String> wordsArray) {
        char[][] wordsChar = new char[wordsArray.size()][];
        for (int i = 0; i< this.words.size(); i++) {
            char[] word = this.words.get(i).toCharArray();
            wordsChar[i] = word;
        }
        return wordsChar;
    }


    public void sort() {
        this.words.sort(Comparator.naturalOrder());
    }



}
