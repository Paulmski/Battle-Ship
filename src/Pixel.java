/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date 2021-11-17 09:48:23
 * @modify date 2021-11-17 09:48:23
 * @desc A simple class which describes information about a specific pixel, it holds its row, column, and optionally its character value.
 */


public class Pixel {

    // ********* Variables ***************
    private int row;
    private int column;
    private char value;




    // *********** Constructors ***********
    Pixel(int row, int column, char value) {
        this.setRow(row);
        this.setColumn(column);
        this.setValue(value);
    }
    
    Pixel(int row, int column) {
        this.setRow(row);
        this.setColumn(column);
        this.setValue('\0');

    }


    Pixel() {
        this.setRow(0);
        this.setColumn(0);
        this.setValue('\0');
    }


    // ********* Setter and Getter methods ************
    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getValue() {
        return this.value;
    }

    public void setValue(char value) {
        this.value = value;
    }
    
}