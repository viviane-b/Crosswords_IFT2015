import java.util.LinkedList;


public class Path  {
    private String word;    // the word found

    // the path of the word, each coordinate of the format "(x,y)"
    private LinkedList<String> list = new LinkedList<>();

    public Path (String word) {
        this.word = word;
    }

    //      Getters & Setters
    public String getWord() {return word;}
    public LinkedList<String> getList() {return list;}
    public void setList(LinkedList<String> list) {this.list = list;}
    public void setWord(String word) {this.word = word;}

    /**
     * Adds new coordinates at the end of the path
     * @param element the coordinates to add
     */
    public void enqueue(String element) {
        this.list.addLast(element);
    }



    /**
     * Keeps only the coordinates of the path from start to a certain index
     * @param index the position of the last element kept in the path
     */
    public void adjustPath(int index) {
        for (int i = index; i<this.list.size(); i++) {
            this.list.removeLast();
        }
    }

    /**
     * Prints path with the format <word><a-space><path>
     */
    public void printPath(){
        System.out.print(this.word + " ");
        for (int i=0; i< this.list.size()-1; i++) {
            System.out.print(this.list.get(i) + "->");
        }
        System.out.println(this.list.get(this.list.size()-1));
    }
}
