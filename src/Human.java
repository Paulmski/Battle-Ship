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

        // the random number generator used to assign ship locations
        Random random = new Random();



        Pixel pixel = new Pixel(random.nextInt(10), random.nextInt(10));

        // Check there are no ships already placed at that pixel.
        if (shipPlacements.getPixel(pixel.getRow(), pixel.getColumn()) != shipPlacements.getBlankPixel()) {
            placeShip(ship);
            return;
        }
        
        int orientation = random.nextInt(4);
        Pixel[] proposedPosition = shipPlacements.getPixels(ship.getAppearance().length(), pixel.getRow(), pixel.getColumn(),
                orientation);
        if (this.checkShipPlacement(proposedPosition, ship)) {
            this.getShipPlacements().setObject(ship.getAppearance(), pixel.getRow(), pixel.getColumn(), orientation);
            this.addShip(ship);
        } else {
            placeShip(ship);
        }
        
    }
    // An method to get the user to place down all ships passed as an argument.
    public void placeAllShips(Ship[] ships) {
    
        for (int i=0; i < ships.length; i++) {
            this.placeShip(ships[i]);
        }

    }

}
