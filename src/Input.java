
/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date 2021-11-17 09:42:30
 * @modify date 2021-11-17 13:29:17
 * @desc A helper class to receive and moderate user interactions with the program.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/* Since there is only one screen being shown to the user there is no good reason to hav instances of this class.
It also doesn't interact with any data making it more of a utility class.
Thus, all methods for this class are static.*/
public class Input {

    /*
     * Asks the user for a row and column along with the message given in the
     * message parameter. If the user provides an invalid input an empty Pixel will
     * be returned. This is so the screen can be correctly redrawn.and the user can
     * be asked again.
     */
    public static Pixel getPixel(String message, int lowerRow, int upperRow, int lowerCol, int upperCol) {
        // Pixel to be eventually returned
        Pixel pixel = new Pixel();

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select row between: " + (char) (lowerRow + 65) + " and " + (char) (upperRow + 65));
        String input = scanner.next();
        // The given input must be of length one otherwise the input will rejected.
        if (input.length() == 1) {
            // Indexing of string is safe because it is known that the string is exactly of
            // length 1
            int row = ((int) input.charAt(0)) - 65;
            if (row >= lowerRow && row <= upperRow) {
                pixel.setRow(row);
            } else {
                pixel.setRow(-1);
            }
        } else {
            pixel.setRow(-1);
        }
        System.out.println("Select column between: " + lowerCol + " and " + upperCol);
        try {
            int input2 = scanner.nextInt();

            // Indexing of string is safe because it is known that the string is exactly of
            // length 1
            if (input2 >= lowerCol && input2 <= upperCol) {
                pixel.setColumn(input2);
            } else {
                pixel.setColumn(-1);
            }

        } catch (InputMismatchException e) {
            pixel.setColumn(-1);
        }
        return pixel;
    }
    // Shows a message to user and returns their input as a string.
    public static String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.next();
        return input;
    }

    // Shows message to user and accepts only an integer equal to or within the lower and upper range.
    public static int getInt(String message, int lower, int upper) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        try {
        int input = scanner.nextInt();
        if (input >= lower && input <= upper) {
            return input;
        } else {
            return getInt(message, lower, upper);
        }
        } catch (NumberFormatException e) {
            return getInt(message, lower, upper);
        }
    }

    

}
