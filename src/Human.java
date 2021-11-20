/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 19, 2021 15:41
 * @modify date November 19, 2021 15:41
 * @desc A sub class which represents a human player. It is a sub class of the Player class.
 */

 import java.util.Random;


public class Human extends Player {


    public Human(String name, int width, int height, int maxShips) {
        this.setGuesses(new Board(width,height,'#'));
        this.setShipPlacements(new Board(width,height,'#'));
        this.setName(name);
        this.setShips(new Ship[maxShips]);
    }


    public void placeShip(Ship ship) {
        Pixel pixel = Input.getPixel("Where do you want to place your ship? (It's " + ship.getAppearance().length() + " tiles long)", 0, 9, 0, 9);

        // Check there are no ships already placed at that pixel.
        if (this.getShipPlacements().getPixel(pixel.getRow(), pixel.getColumn()) != this.getShipPlacements().getBlankPixel()) {
            System.out.println("Sorry, looks like there's already a ship there!!!!!");
            placeShip(ship);
            return;
        }
        
        int orientation = Input.getInt(
                "Select the orientation of the ship: \n0: bottom to top\n1: left to right\n2: top to bottom\n3: right to left",
                0, 3);
        Pixel[] proposedPosition = this.getShipPlacements().getPixels(ship.getAppearance().length(), pixel.getRow(), pixel.getColumn(),
                orientation);
        if (this.checkShipPlacement(proposedPosition, ship)) {
            this.getShipPlacements().setObject(ship.getAppearance(), pixel.getRow(), pixel.getColumn(), orientation);

            this.addShip(ship);


            int[][] positions = new int[ship.getAppearance().length()][2];
            for (int i = 0; i < proposedPosition.length; i++) {

                
                positions[i][0] = proposedPosition[i].getRow();
                positions[i][1] = proposedPosition[i].getColumn();
            }
            ship.setPosition(positions);
        } else {
            System.out.println("Sorry, that area is invalid, place the ship elsewhere.");
            placeShip(ship);
        }
        
    }



    // A function to get the human player to try to guess the enemy ship locations.
    public void takeTurn(Player enemyPlayer) {
        Pixel guess = Input.getPixel("Take your shot!", 0, 9, 0, 9);
        // The player guessed a valid pixel that has not been guessed yet.
        if (this.getGuesses().getPixel(guess.getRow(), guess.getColumn()) == this.getGuesses().getBlankPixel()) {
            // The return value of set guess is optionally the ship that was hit.
            Ship result = this.setGuess(guess.getRow(), guess.getColumn(), enemyPlayer);
            if (result == null) {
                // Result is null meaning no ship was hit.
                System.out.println("Nice try, but you missed!");
            } else {
                if (result.getHealth() > 0) {
                    System.out.println("Nice shot! you hit your enemy's " + result.getName() + ".");

                } else {
                    System.out.println("You sunk your enemy's " + result.getName() + "!");

                }
            }
        } else {
            System.out.println("You've already guessed there, try again!");
            takeTurn(enemyPlayer);
        }
    }
    
   
    
}
