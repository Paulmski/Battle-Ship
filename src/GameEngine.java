/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:49
 * @modify date November 16, 2021 09:49
 * @desc This is the main class which will coordinate other classes to
 *       communicate key strokes, and refresh the board.
 */

public class GameEngine {
    // A bool to tell the Main Class if it should continue drawing frames.
    private boolean running = true;
    // 0: Single Player mode
    // 1: Two player mode
    private int gameMode = 0;

    private Board mainBoard;

    // Constructors

    GameEngine(int width, int height) {
        mainBoard = new Board(width, height, ' ');

    }

    // ******** Setters and getters ********
    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public Board getMainBoard() {
        return this.mainBoard;
    }

    public void setMainBoard(Board mainBoard) {
        this.mainBoard = mainBoard;
    }

    // ********** Class specific methods ***********
    public void showMenu() {
        Board.drawBlank();
        this.getMainBoard().clearBoard();
        this.getMainBoard().setObject("Welcome to Battle Ship!", 0, 12, 1);
        this.getMainBoard().centerString("Please select from the menu below", 3);
        this.getMainBoard().setObject("1:  Single Player Mode", 8, 10, 1);
        this.getMainBoard().setObject("2:  Two Player Mode", 10, 10, 1);
        this.getMainBoard().setObject("3:  Quit Game", 12, 10, 1);
        this.getMainBoard().drawBoard();
        int input = Input.getInt("Enter 1, 2, or 3: ", 1, 3);
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
        this.getMainBoard().clearBoard();
        // The board that ships will be placed in.
        Board battleBoard = new Board(10, 10, '#');
        this.getMainBoard().addBoard(battleBoard, 4, 19);
        // The top bar to show the user how to select a square
        this.getMainBoard().setObject("0123456789", 3, 19, 1);
        this.getMainBoard().setObject("ABCDEFGHIJ", 4, 18, 2);
        this.getMainBoard().drawBoard();

        // Single player mode
        if (gameMode == 0) {
            // Player 1
            Player player1 = new Player("", 10, 10, 5);
            // CPU / player 2
            Player cpu = new Player("CPU", 10, 10, 5);
            // Clear board
            player1.setName(Input.getString("What's your name?"));
            // A title bar to display messages.
            Board titleBar = new Board(mainBoard.getWidth(), 1, ' ');
            // Add the titleBar as a subBoard to the mainBoard.
            this.getMainBoard().addBoard(titleBar, 0, 0);
            // Welcome the player
            titleBar.centerString("Welcome " + player1.getName(), 0);

            // Add All 5 Battle ships
            this.getMainBoard().drawBoard();
            battleBoard.addBoard(player1.getShipPlacements(), 0, 0);
           
            battleBoard.resetBoard();
            this.getMainBoard().drawBoard();
 


        } else if (gameMode == 1) {

        }
    }

    
    public void playerPlaceShips(Player player) {
        player.placeShip(new Ship("Aircraft Carrier", "^^^^^"));
        mainBoard.drawBoard();

        player.placeShip(new Ship("Battleship", "^^^^"));
        this.getMainBoard().drawBoard();

        player.placeShip(new Ship("Cruiser", "^^^"));
        this.getMainBoard().drawBoard();

        player.placeShip(new Ship("Submarine", "^^^"));
        this.getMainBoard().drawBoard();

        player.placeShip(new Ship("Destroyer", "^^"));
        this.getMainBoard().drawBoard();
        sleep(5000);
    }

    public void cpuPlaceShips(Player cpu) {
        
    }






    // A convience method to allow time to show information to user. Time is in milliseconds 1 second = 1000.
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }

    }







}
