/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:44
 * @modify date November 16, 2021 09:44
 * @desc The main class which will execute.
 */



public class Main {
    public static void main(String[] args) {
        Board board = new Board(20,20, '#');
      for (int i = 0; i <3000; i++) {
          try {
            board.setObject(String.valueOf(i), 10, 10, 1);
            board.drawBoard();
            Thread.sleep(33);
            Board.drawBlank();

          
          } catch (InterruptedException e) {

          }
        }
    }
}
