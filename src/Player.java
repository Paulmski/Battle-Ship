/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date 2021-11-17 09:36:58
 * @modify date November 17, 2021 17:41
 * @desc The class which will contain player information like guesses, battleship placement, and scoring.
 */



public class Player {
    // ********** Variables ************
    // A 2d grid which holds the players guesses
    private Board guesses;
    // A 2d grid which holds where the player places their battle ships
    private Board shipPlacements;
    // The name of the player
    private String name;
    // An array to hold the ship objects the player has.
    private Ship[] ships;




// ******** Constructors ***********

    Player(String name, int width, int height, int maxShips) {
        this.setGuesses(new Board(width,height,'#'));
        this.setShipPlacements(new Board(width,height,'#'));
        this.setName(name);
        this.setShips(new Ship[maxShips]);
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



    public void setGuess(int row, int column, boolean onTarget) {
       if (onTarget) {
           this.guesses.setPixel('X', row, column);
       } else {
           this.guesses.setPixel('O', row, column);
       }
    }



    public void placeShip(Ship ship) {
        Pixel pixel = Input.getPixel("Where do you want to place your ship? (It's " + ship.getAppearance().length() + " tiles long)", 0, 9, 0, 9);

        // Check there are no ships already placed at that pixel.
        if (shipPlacements.getPixel(pixel.getRow(), pixel.getColumn()) != shipPlacements.getBlankPixel()) {
            System.out.println("Sorry, looks like there's already a ship there!!!!!");
            placeShip(ship);
            return;
        }
        
        int orientation = Input.getInt(
                "Select the orientation of the ship: \n0: bottom to top\n1: left to right\n2: top to bottom\n3: right to left",
                0, 3);
        Pixel[] proposedPosition = shipPlacements.getPixels(ship.getAppearance().length(), pixel.getRow(), pixel.getColumn(),
                orientation);
        // Checks the ship does not go out of bounds of the board.
        if (proposedPosition.length != ship.getAppearance().length()) {
            System.out.println("Sorry this position is invalid, make sure the entire ship is within bounds.");
            placeShip(ship);
            return;
        }
        // Checks to make sure there are no other object that will overlap with the new ship.
        for (int i = 0; i < proposedPosition.length; i++) {
            if (proposedPosition[i].getValue() != shipPlacements.getBlankPixel()) {
                System.out.println("Sorry, looks like there's already a ship there.");
                placeShip(ship);
                return;
            }
        }
        this.getShipPlacements().setObject(ship.getAppearance(), pixel.getRow(), pixel.getColumn(), orientation);

    }





}
