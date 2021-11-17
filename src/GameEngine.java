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
        mainBoard = new Board(48, 18, ' ');
        Board.drawBlank();
        
        mainBoard.setObject("Welcome to Battle Ship!",0, 12, 1);
        mainBoard.setObject("Please select from the menu below", 3,7,1);
        mainBoard.setObject("(press and enter 1, 2, or 3)", 5,10,1);
        mainBoard.setObject("1:  Single Player Mode", 8,10,1);
        mainBoard.setObject("2:  Two Player Mode", 10,10,1);
        mainBoard.setObject("3:  Quit Game",12,10,1);
        int input
        
        mainBoard.drawBoard();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
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
