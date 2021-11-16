/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:44
 * @modify date November 16, 2021 09:44
 * @desc The main class which will execute.
 */



public class Main {
    public static void main(String[] args) {
        Board board = new Board(20,20, '*');
        board.setPixel('X', 1, 0);
        Board mainBoard = new Board(40,40, ' ');
        mainBoard.setObject(board.getBoard(), 10, 10);
        mainBoard.setObject("Hello user!", 9, 10, 1);
        mainBoard.drawBoard();
    }
}
