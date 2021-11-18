/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 09:37
 * @modify date November 16, 2021 09:37
 * @desc This class is the basic model for all ships. It contains its appearance along with name and other information.
 */


 public class Ship {
     // The name of the ship
     private String name;
     // The appearance of it on the board
     private String appearance;
     // The positioning of the ship within a board.
     private int[][]position;
     // The health of the ship.
     private int health;

    




     // ********** Setter and getter methods ********
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppearance() {
        return this.appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public int[][] getPosition() {
        return this.position;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
     
 }