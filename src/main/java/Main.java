import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {
        Grid myGrid = new Grid();


        try {
            myGrid.readFile("C:\\_Code\\courses\\IFT2015_TP1\\src\\main\\resources\\TP1Input");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(myGrid.getHeight());
    }
}
