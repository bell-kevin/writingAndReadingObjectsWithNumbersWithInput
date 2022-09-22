/** ****************************************************************************
 * writingAndReadingObjectsWithNumbers.java
 * Kevin Bell
 *
 * The program writes objects to a file, and reads objects from a file.
 **************************************************************************** */
package writingAndReadingObjectsWithNumbersWithInput;

import java.io.*;
import java.util.*;

public class writingAndReadingObjectsWithNumbersWithInput {

    public static void main(String[] args) {
        System.out.println("Objects in Files by Kevin Bell with numbers \n");
        Scanner computerKeyboardInput = new Scanner(System.in);
        double score;
        double[] numbers = {};
        numbers = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter test score: ");
            score = computerKeyboardInput.nextDouble();
            numbers[i] = score;
        } // end for loop
        NumberList numberList = new NumberList(numbers);
        String fileName = "scoresOnly.txt";
        try (ObjectOutputStream fileOut // write object
                = new ObjectOutputStream(new FileOutputStream(fileName))) {
            fileOut.writeObject(numberList);
            fileOut.reset();
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } // end try/catch, and close fileOut automatically
        System.out.println("Data written to file");
        try (ObjectInputStream fileIn = new ObjectInputStream( // read object
                new FileInputStream(fileName))) {
            while (true) {
                numberList = (NumberList) fileIn.readObject();
                numberList.display();
            } // end while loop
        } catch (EOFException e) { // terminates infinite while loop
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } // end try/catch, and close fileOut automatically
    } // end main method
} // end writingAndReadingObjectsWithNumbers class
