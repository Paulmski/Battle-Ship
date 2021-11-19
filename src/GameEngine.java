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
            Board.drawBlank();
            player1.setName(Input.getString("What's your name?"));
            // A title bar to display messages.
            Board titleBar = new Board(mainBoard.getWidth(), 1, ' ');
            // Add the titleBar as a subBoard to the mainBoard.
            this.getMainBoard().addBoard(titleBar, 0, 0);
            // Welcome the player
            titleBar.centerString("Welcome " + player1.getName(), 0);
            Board.drawBlank();
            this.getMainBoard().drawBoard();
            placeShip(player1, new Ship("Tanker", "^^^^^"), battleBoard);
            Board.drawBlank();
            this.getMainBoard().drawBoard();
 


        } else if (gameMode == 1) {

        }
    }

    public void placeShip(Player player, Ship ship, Board board) {
        Pixel pixel = Input.getPixel("Where do you want to place your ship?", 0, 9, 0, 9);

        // Check there are no ships already placed at that pixel.
        if (board.getPixel(pixel.getRow(), pixel.getColumn()) != board.getBlankPixel()) {
            System.out.println("Sorry, looks like there's already a ship there!!!!!");
            placeShip(player, ship, board);
            return;
        }
        Board.drawBlank();
        this.getMainBoard().drawBoard();
        int orientation = Input.getInt(
                "Select the orientation of the ship: \n0: bottom to top\n1: left to right\n2: top to bottom\n3: right to left",
                0, 3);
        Pixel[] proposedPosition = board.getPixels(ship.getAppearance().length(), pixel.getRow(), pixel.getColumn(),
                orientation);
        // Checks the ship does not go out of bounds of the board.
        if (proposedPosition.length != ship.getAppearance().length()) {
            System.out.println("Sorry this position is invalid, make sure the entire ship is within bounds.");
            placeShip(player, ship, board);
            return;
        }
        // Checks to make sure there are no other object that will overlap with the new ship.
        for (int i = 0; i < proposedPosition.length; i++) {
            if (proposedPosition[i].getValue() != board.getBlankPixel()) {
                System.out.println("Sorry, looks like there's already a ship there.");
                placeShip(player,ship,board);
                return;
            }
        }

        board.setObject(ship.getAppearance(), pixel.getRow(), pixel.getColumn(), orientation);

    }

}
