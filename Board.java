/*
Author: Paul Molczanski
Date: November 15, 2021 8:57 PM
Description: This class is responsible for drawing to the screen and contains different helper methods to simplify drawing.
**/

public class Board {
    // The width of the board which will be generated
    private int width;
    // The height of the board which will be generated
    private int height;
    // A 2D array which holds the value of each "pixel" that is being drawn on the board which is being presented to the user.
    private char[][] board;

    Board (int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        this.setBoard(new char[height][width]);
    }


    // *********** Setter and Getter methods ***********
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

    public char[][] getBoard() {
        return this.board;
    }
    /* This is private because there is no good reason for the entire board to be modified outside of the scope of the Board class. If the board needs to be modified the drawPixel() method can be used.
    */
    private void setBoard(char[][] board) {
        this.board = board;
    }




    // Set the value of an individual pixel


    // Draws the characters that are within the board variable.
    public void drawBoard() {
        for (int i=0; i<this.getBoard().length; i++) {
            for (int j=0;j<this.getBoard()[i].length; j++) {
                System.out.println(this.getBoard()[i][j]);
            }
        }
    }






}