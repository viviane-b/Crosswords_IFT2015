import java.util.Stack;


public class Path  {
    private String word;    // the word found

    private Stack<String> list = new Stack<>();      // the path of the word, each coordinate of the format "(x,y)"

    /**
     * Constructor for Path
     * @param word the word to print the path of
     */
    public Path (String word) {
        this.word = word;
    }


    /**
     * Adds new coordinates at the end of the path
     * @param element the coordinates to add
     */
    public void push(String element) {
        this.list.push(element);
    }



    /**
     * Keeps only the coordinates of the path from start to a certain index
     * @param index the position of the last element kept in the path
     */
    public void adjustPath(int index) {
        for (int i = index; i<this.list.size(); i++) {
            this.list.pop();
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
        System.out.println(this.list.peek());
    }
}
