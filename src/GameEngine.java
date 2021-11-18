/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:49
 * @modify date November 16, 2021 09:49
 * @desc This is the main class which will coordinate other classes to communicate key strokes, and refresh the board.
 */




public class GameEngine {
    // A bool to tell the Main Class if it should continue drawing frames.
    private boolean running = true;
    // 0: Single Player mode
    // 1: Two player mode
    private int gameMode = 0;

    

    private Board mainBoard;




    

    public boolean isRunning() {
        return this.running;
    }


    public void setRunning(boolean running) {
        this.running = running;
    }



    // ********** Class specific methods ***********
    public void showMenu() {
        mainBoard = new Board(48, 18, ' ');
        Board.drawBlank();
        
        mainBoard.setObject("Welcome to Battle Ship!",0, 12, 1);
        mainBoard.setObject("Please select from the menu below", 3,7,1);
        mainBoard.setObject("1:  Single Player Mode", 8,10,1);
        mainBoard.setObject("2:  Two Player Mode", 10,10,1);
        mainBoard.setObject("3:  Quit Game",12,10,1);        
        mainBoard.drawBoard();
        int input  = Input.getInt("Enter 1, 2, or 3: ", 1, 3);
        switch (input) {
            // Selected single player mode
            case 1:
                gameMode = 0;
                break;
            // Selected two player mode
            case 2:
                gameMode = 1;
                break;
            // Quit the game
            case 3:
                this.setRunning(false);
                return;
        }
       
    }



    public void startGame() {
        // Reset mainBoard to be redrawn for main playing area
        Board.drawBlank();
        mainBoard.resetBoard();
        // The board that ships will be placed in.
        Board battleBoard = new Board(10, 10, '#');
        mainBoard.setObject(battleBoard.getBoard(), 4, 19);
        // The top bar to show the user how to select a square
        mainBoard.setObject("0123456789", 3, 19, 1);
        mainBoard.setObject("ABCDEFGHIJ", 4, 18, 2);
        mainBoard.drawBoard();





        // Single player mode
        if (gameMode == 0) {
            Board.drawBlank();
            mainBoard.setObject("Welcome, what's your name?", 0, 3, 1);
            mainBoard.drawBoard();
            String name = Input.getString("What's your name?");
            Player player1 = new Player(name, 10, 10);
            Player cpu = new Player("CPU", 10, 10);
            Board.drawBlank();
            Board.set









        } else if (gameMode == 1) {

        }
    }


    
}
