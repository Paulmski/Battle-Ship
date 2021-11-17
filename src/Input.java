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
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select row between: " + (char)lowerRow+65 + " and " + (char)upperRow+65);
        scanner.next();
        
    }

}
