
/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date 2021-11-17 09:42:30
 * @modify date 2021-11-17 09:42:30
 * @desc A helper class to receive and moderate user interactions with the program.
 */

import java.util.Scanner;

public class Input {

    public static Pixel getPixel(String message, int lowerRow, int upperRow, int lowerCol, int upperCol) {
        // Pixel to be eventually returned
        Pixel pixel = new Pixel();

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select row between: " + (char) lowerRow + 65 + " and " + (char) upperRow + 65);
        String input = scanner.next();
        // The given input must be of length one otherwise the input will be asked for
        // again.
        if (input.length() != 1) {
            System.out.println("Sorry, invalid input please try again.");
            return getPixel(message, lowerRow, upperRow, lowerCol, upperCol);
        }
        // Indexing of string is safe because it is known that the string is exactly of
        // length 1
        int row = ((int) input.charAt(0)) - 65;
        if (row >= lowerRow && row <= upperRow) {
            pixel.setRow(row);
        } else {
            System.out.println("Sorry, invalid input please try again.");
            return getPixel(message, lowerRow, upperRow, lowerCol, upperCol);
        }

        System.out.println("Select column between: " + lowerCol + " and " + upperCol);
        int input2 = scanner.nextInt();

        // Indexing of string is safe because it is known that the string is exactly of
        // length 1
        if (input2 >= lowerRow && input2 <= upperRow) {
            pixel.setRow(input2);
        } else {
            System.out.println("Sorry, invalid input please try again.");
            return getPixel(message, lowerRow, upperRow, lowerCol, upperCol);
        }

        // Prevent memory leak.
        scanner.close();
        return pixel;
    }



    

}
