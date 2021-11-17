/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:44
 * @modify date 2021-11-17 13:12:25
 * @desc The main class which will execute.
 */



public class Main {
    public static void main(String[] args) {
      Pixel pixel;
      do {
        Board.drawBlank();
        pixel = Input.getPixel("Pick a quadrant to bomb!", 0, 7, 0, 7);
      } while (pixel.getRow() < 0 || pixel.getColumn() < 0);





    }
}
