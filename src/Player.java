/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date 2021-11-17 09:36:58
 * @modify date November 17, 2021 17:41
 * @desc The class which will contain player information like guesses,
 *       battleship placement, and scoring.
 */

public class Player {
    // ********** Variables ************
    // A 2d grid which holds the players guesses
    protected Board guesses;
    // A 2d grid which holds where the player places their battle ships
    protected Board shipPlacements;
    // The name of the player
    protected String name;
    // An array to hold the ship objects the player has.
    protected Ship[] ships;

    // ******** Constructors ***********

    public Player(String name, int width, int height, int maxShips) {
        this.setGuesses(new Board(width, height, '#'));
        this.setShipPlacements(new Board(width, height, '#'));
        this.setName(name);
        this.setShips(new Ship[maxShips]);
    }

    public Player() {

    }

    public Board getGuesses() {
        return this.guesses;
    }

    public void setGuesses(Board guesses) {
        this.guesses = guesses;
    }

    public Board getShipPlacements() {
        return this.shipPlacements;
    }

    public void setShipPlacements(Board shipPlacements) {
        this.shipPlacements = shipPlacements;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship[] getShips() {
        return this.ships;
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }

    public void addShip(Ship ship) {
        for (int i = 0; i < this.getShips().length; i++) {
            if (this.getShips()[i] == null) {
                this.ships[i] = ship;
            }
        }
    }

    // ******** Class methods ********

    /*
     * Set's the guess of the player and modifies the guesses array. Return values:
     * If it was a miss it returns null otherwise it returns the Ship which was hit.
     */
    public Ship setGuess(int row, int column, Player player) {

       /* Iterates through each position in each ship to check if the row and column of the guess is a valid ship position. If the guess is on a ship, that ship instance is reduced one health, and returned.
       */
       for (int i = 0; i < player.getShips().length; i++) {
           for (int j = 0; j < player.getShips()[i].getPosition()[j].length; j++) {
                // The guess hit a ship!
                if (player.getShips()[i].getPosition()[j][0] == row && player.getShips()[i].getPosition()[j][1] == column) 
                {
                    // reduce the health by one
                    Ship hitShip = player.getShips()[i];
                    hitShip.setHealth(hitShip.getHealth()-1);
                    // Mark board and return hit ship.
                    this.guesses.setPixel('X', row, column);
                    return hitShip;
                }
           }
        }
            // The guess was a miss mark board and return null.
           this.guesses.setPixel('O', row, column);
           return null;
       
    }

    // If the spot is valid returns true else returns false.
    public boolean checkShipPlacement(Pixel[] proposedPosition, Ship ship) {
        // Checks the ship does not go out of bounds of the board.
        if (proposedPosition.length != ship.getAppearance().length()) {
            return false;
        }
        // Checks to make sure there are no other object that will overlap with the new
        // ship.
        for (int i = 0; i < proposedPosition.length; i++) {
            if (proposedPosition[i].getValue() != shipPlacements.getBlankPixel()) {
                return false;
            }
        }
        return true;
    }

}
