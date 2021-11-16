/*
Author: Paul Molczanski
Date: November 15, 2021 8:57 PM
Description: This class is responsible for drawing to the screen and contains different helper methods to simplfy drawing.
**/

public class Board {
    // The width of the board which will be generated
    private int width;
    // The height of the board which will be generated
    private int height;
    // A 2D array which holds the value of each "pixel" that is being drawn on the board which is being presented to the user.
    private String[][] board;

    Board (int width, int height) {

    }


    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



}