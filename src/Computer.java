/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 19, 2021 16:32
 * @modify date November 19, 2021 16:32
 * @desc This is a sub class of the Player class. It is used to generate random events for the player to play against.
 */





public class Computer extends Player {
    



    public Computer(int width, int height, int maxShips) {
        this.setGuesses(new Board(width,height,'#'));
        this.setShipPlacements(new Board(width,height,'#'));
        this.setName("CPU");
        this.setShips(new Ship[maxShips]);
    }




    





}
