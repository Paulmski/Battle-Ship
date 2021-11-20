/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 19, 2021 16:32
 * @modify date November 19, 2021 16:32
 * @desc This is a sub class of the Player class. It is used to generate random events for the player to play against.
 */



import java.util.Random;

public class Computer extends Player {
    



    public Computer(int width, int height, int maxShips) {
        this.setGuesses(new Board(width,height,'#'));
        this.setShipPlacements(new Board(width,height,'#'));
        this.setName("CPU");
        this.setShips(new Ship[maxShips]);
    }


    public void placeShip(Ship ship) {

        // the random number generator used to assign ship locations
        Random random = new Random();


        // Random position
        int randomRow = random.nextInt(10);
        int randomColumn = random.nextInt(10);
        // Random orientation
        int orientation = random.nextInt(4);
        // Get the positions and values of all proposed pixels.
        Pixel[] proposedPosition = this.getShipPlacements().getPixels(ship.getAppearance().length(), randomRow, randomColumn,orientation);
        if (this.checkShipPlacement(proposedPosition, ship)) {
            this.getShipPlacements().setObject(ship.getAppearance(), randomRow, randomColumn, orientation);
            this.addShip(ship);
            int[][] positions = new int[ship.getAppearance().length()][2];
            for (int i = 0; i < proposedPosition.length; i++) {

                
                positions[i][0] = proposedPosition[i].getRow();
                positions[i][1] = proposedPosition[i].getColumn();
            }
            ship.setPosition(positions);
            
        } else {
            placeShip(ship);
        }
        
    }

    
    // An method to get the cpu to place down all ships passed as an argument.
    public void placeAllShips(Ship[] ships) {
    
        for (int i=0; i < ships.length; i++) {
            this.placeShip(ships[i]);
        }

    }


    // A function to randomly pick a spot to shoot the enemy player.
    public void takeTurn(Player enemyPlayer) {
        Random random = new Random();
        Pixel guess = new Pixel();
        guess.setRow(random.nextInt(10));
        guess.setColumn(random.nextInt(10));
        // The player guessed a valid pixel that has not been guessed yet.
        if (this.getGuesses().getPixel(guess.getRow(), guess.getColumn()) == this.getGuesses().getBlankPixel()) {
            
            this.setGuess(guess.getRow(), guess.getColumn(), enemyPlayer);
            
        } else {
            takeTurn(enemyPlayer);
        }
    }




}
