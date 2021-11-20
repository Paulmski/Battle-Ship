
/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:49
 * @modify date November 16, 2021 09:49
 * @desc This is the main class which will coordinate other classes to
 *       communicate key strokes, and refresh the board.
 */

import java.util.Random;

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
        this.getMainBoard().clearBoard();
        // The board that ships will be placed in.
        Board topBoard = new Board(10, 10, '#');
        this.getMainBoard().addBoard(topBoard, 4, 19);
        // The top bar to show the user how to select a square
        this.getMainBoard().setObject("0123456789", 3, 19, 1);
        this.getMainBoard().setObject("ABCDEFGHIJ", 4, 18, 2);

        Board bottomBoard = new Board(10, 10, '#');
        this.getMainBoard().addBoard(bottomBoard, 16, 19);
        this.getMainBoard().setObject("0123456789", 15, 19, 1);
        this.getMainBoard().setObject("ABCDEFGHIJ", 16, 18, 2);

        this.getMainBoard().drawBoard();

        // Single player mode
        if (gameMode == 0) {

            // Player 1
            Human player1 = new Human("", 10, 10, 5);
            // CPU
            Computer cpu = new Computer(10, 10, 5);
            // Get the users name to customize the UI
            player1.setName(Input.getString("What's your name?"));

            // A title bar to display messages.
            Board titleBar = new Board(mainBoard.getWidth(), 1, ' ');
            // Add the titleBar as a subBoard to the mainBoard.
            this.getMainBoard().addBoard(titleBar, 0, 0);

            // Welcome the player
            titleBar.centerString("Welcome " + player1.getName(), 0);

            // The topBoard is the players guess and the bottomBoard is their ships.
            bottomBoard.addBoard(player1.getShipPlacements(), 0, 0);
            topBoard.addBoard(cpu.getShipPlacements(), 0, 0);
            // Add All 5 Battle ships
            Ship[] playerShips = new Ship[5];
            playerShips[0] = new Ship("Carrier", "^^^^^");
            playerShips[1] = new Ship("Battleship", "^^^^");
            playerShips[2] = new Ship("Cruiser", "^^^");
            playerShips[3] = new Ship("Submarine", "^^^");
            playerShips[4] = new Ship("Destroyer", "^^");
            for (int i = 0; i < playerShips.length; i++) {
                player1.placeShip(playerShips[i]);
                mainBoard.drawBoard();
            }

            titleBar.centerString("Congrats you've chosen all your battle ships!", 0);
            sleep(5);
            this.getMainBoard().drawBoard();

            Ship[] cpuShips = new Ship[5];
            cpuShips[0] = new Ship("Carrier", "^^^^^");
            cpuShips[1] = new Ship("Battleship", "^^^^");
            cpuShips[2] = new Ship("Cruiser", "^^^");
            cpuShips[3] = new Ship("Submarine", "^^^");
            cpuShips[4] = new Ship("Destroyer", "^^");
            cpu.placeAllShips(cpuShips);

            /*
             * Random number to simulate the cpu loading their its choices. Forcing the user
             * to wait a random but small amount of time between turns adds to the
             * experience.
             */
            Random random = new Random();
            while (player1.getHealth() > 0 && cpu.getHealth() > 0) {
                titleBar.clearBoard();
                titleBar.centerString(player1.getName() + "'s turn", 0);
                this.getMainBoard().drawBoard();
                player1.takeTurn(cpu);
                sleep(3000);

                titleBar.clearBoard();
                titleBar.centerString("CPU taking turn...", 0);
                this.getMainBoard().drawBoard();
                // Random delay
                sleep(random.nextInt(2000) + 1500);

                cpu.takeTurn(player1);
            }

            mainBoard.resetBoard();
            titleBar.resetBoard();
            if (player1.getHealth() != 0) {
                titleBar.centerString("Congrats " + player1.getName() + " you won!", 0);
                mainBoard.drawBoard();
                sleep(5000);
                titleBar.resetBoard();
                titleBar.centerString("Come again!",0);
                mainBoard.drawBoard();
                sleep(3000);

            } else {
                titleBar.centerString("Defeat, your enemy has sunk all your ships", 0);
                mainBoard.drawBoard();
                sleep(5000);
                titleBar.resetBoard();
                titleBar.centerString("Come again!",0);
                mainBoard.drawBoard();
                sleep(3000);
            }

        } else if (gameMode == 1) {

        }
    }

    // A convience method to allow time to show information to user. Time is in
    // milliseconds 1 second = 1000.
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }

    }

}
