/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:49
 * @modify date November 16, 2021 09:49
 * @desc This is the main class which will coordinate other classes to communicate key strokes, and refresh the board.
 */




public class GameEngine {
    
    private boolean running = true;

    

    private Board mainBoard;




    public void showMenu() {
        mainBoard = new Board(64, 36, '#');
        Board.drawBlank();

        mainBoard.setObject("Welcome to Battle Ship!", 15, 25, 1);
        mainBoard.drawBoard();

    }





    public boolean isRunning() {
        return this.running;
    }

    public void startGame() {

    }

    public void setRunning(boolean running) {
        this.running = running;
    }



    
}
