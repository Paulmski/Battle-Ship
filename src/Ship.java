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
     
 }