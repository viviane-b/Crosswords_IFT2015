import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {
        Grid myGrid = new Grid();

        //test
        myGrid.setHeight(3);
        System.out.println(myGrid.getHeight());

        try {
            myGrid.fileReader("C:\\_Code\\courses\\IFT2015_TP1\\src\\main\\resources\\TP1Input");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
