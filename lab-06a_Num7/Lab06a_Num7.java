
/**
 * @author ramzijabali, date 02/12/19, 10Am - 11Am
 * @purpose asks for three names and puts them in alphabetical order
 */
import java.util.Scanner;

public class Lab06a_Num7 {

    public static void main(String[] args) {

        String name1,
                name2,
                name3,
                namesInOrder = "";

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter the first name");
        name1 = kb.next();
        System.out.println("Enter the second name");
        name2 = kb.next();
        System.out.println("Enter the Third name");
        name3 = kb.next();

        if (name1.compareToIgnoreCase(name2) < 0 && name1.compareToIgnoreCase(name3) < 0) {

            namesInOrder += name1 + "\n";

            if (name2.compareToIgnoreCase(name3) < 0) {

                namesInOrder += name2 + "\n";
                namesInOrder += name3 + "\n";

            } else {
                namesInOrder += name3 + "\n";
                namesInOrder += name2 + "\n";
            }

        } else if (name2.compareToIgnoreCase(name1) < 0 && name2.compareToIgnoreCase(name3) < 0) {

            namesInOrder += name2 + "\n";

            if (name3.compareToIgnoreCase(name1) < 0) {
                namesInOrder += name3 + "\n";
                namesInOrder += name1 + "\n";

            } else {
                namesInOrder += name1 + "\n";
                namesInOrder += name3 + "\n";

            }
        }else{
            namesInOrder += name3 + "\n";
            
            if(name1.compareToIgnoreCase(name2) < 0 ){
                namesInOrder += name1 + "\n";
                namesInOrder += name2 + "\n";
            }else{
                namesInOrder += name2 + "\n";
                namesInOrder += name1 + "\n";
            }
        }
        System.out.println(namesInOrder);
    }
}
