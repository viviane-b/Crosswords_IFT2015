import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Path extends ArrayList {
    private String word;
    private ArrayList<String> list = new ArrayList<>();         // should be a linkedlist so it's faster to remove(index=0)
  //    private Queue<String> coordinates = new Queue<String>();

    public Path (String word) {
        this.word = word;
       // this.list = list;
       // this.coordinates = coordinates;
    }

 // public Queue<String> getCoordinates() {
 //     return coordinates;
 // }


    public String getWord() {
        return word;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void setWord(String word) {
        this.word = word;
    }

 //  public void setCoordinates(Queue<String> coordinates) {
 //      this.coordinates = coordinates;
 //  }

    public void add (String element) {
        this.list.add(element);
    }

    public void removeLast () {
        this.list.remove(this.list.size()-1);
    }
    public void enqueue(String element) {
        this.list.add(element);
    }
    public String dequeue() {
        return (this.list.remove(0));
    }
    public void adjustPath(int index) {
        for (int i = index; i < this.list.size(); i++) {
            this.list.remove(i);
        }
    }

    public void printPath(){
        System.out.print(this.word + " ");
        for (int i=0; i< this.list.size()-1; i++) {
            System.out.print(this.list.get(i) + "->");
        }
        System.out.println(this.list.get(this.list.size()-1));

    }

    public void printPath1() {
        int listSize = this.list.size();
        System.out.println("size of queue before printPath: " + this.list.size());
        System.out.print(this.word + " ");
        for (int i=0; i < listSize -1; i++) {
            System.out.print(this.list.remove(0) + "->");
        }
        System.out.println(this.list.remove(0));
        System.out.println("size of queue after printPath: " + this.list.size());

    }

}
