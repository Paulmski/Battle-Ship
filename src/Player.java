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



// ******** Constructors ***********

    Player(String name, int width, int height) {
        this.setGuesses(new Board(width,height,'\0'));
        this.setShipPlacements(new Board(width,height,'\0'));
        this.setName(name);
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


    // ******** Class methods ********
    public void setGuess(int row, int column, boolean onTarget) {
       if (onTarget) {
           this.guesses.setPixel('X', row, column);
       } else {
           this.guesses.setPixel('O', row, column);
       }
    }



}
