import java.util.ArrayList;
import java.util.Comparator;

public class Words {
    private ArrayList<String> words;

    public Words( ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<String> getWords() {return words;}
    public void setWords(ArrayList<String> words) {this.words = words;}


    public void sort() {
        this.words.sort(Comparator.naturalOrder());
    }



}
