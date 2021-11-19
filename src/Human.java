/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 19, 2021 15:41
 * @modify date November 19, 2021 15:41
 * @desc A sub class which represents a human player. It is a sub class of the Player class.
 */



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
        if (this.checkShipPlacement(proposedPosition, ship)) {
            this.getShipPlacements().setObject(ship.getAppearance(), pixel.getRow(), pixel.getColumn(), orientation);
        } else {
            System.out.println("Sorry, that area is invalid, place the ship elsewhere.");
            placeShip(ship);
        }
        
    }
}
