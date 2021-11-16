/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 12:47
 * @modify date November 16, 2021 12:47
 * @desc This class is responsible for drawing to the screen and contains different helper methods to simplify drawing.
 */


public class Board {
    // The width of the board which will be generated
    private int width;
    // The height of the board which will be generated
    private int height;
    // A 2D array which holds the value of each "pixel" that is being drawn on the board which is being presented to the user.
    private char[][] board;
    // The default pixel value if no other value has been assigned.
    private char blankPixel;

    Board (int width, int height, char blankPixel) {
        this.setWidth(width);
        this.setHeight(height);
        this.setBlankPixel(blankPixel);
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

    public char getBlankPixel() {
        return this.blankPixel;
    }

    public void setBlankPixel(char blankPixel) {
        this.blankPixel = blankPixel;
    }

    // TODO: add description
    public void setBoard() {
        for (int i=0; i<this.getBoard().length; i++) {
            for (int j=0;j<this.getBoard()[i].length; j++) {
                this.setPixel(this.getBlankPixel(), i, j);
            }
        } 
    }
    // TODO: add description
    public void setBoard(char[][] board) {
        this.board = board;
        for (int i=0; i<this.getBoard().length; i++) {
            for (int j=0;j<this.getBoard()[i].length; j++) {
                // Checks if pixel is empty. if so it sets the pixel to the default blank pixel.
                if (Character.isWhitespace(board[i][j])) {
                    this.setPixel(this.getBlankPixel(), i, j);
                } else {
                    this.setPixel(blankPixel, i, j);
                }
                
            }
        }
    }
    // TODO: add description
    public void setBoard(char[][] board, char pixel) {
        for (int i=0; i<this.getBoard().length; i++) {
            for (int j=0;j<this.getBoard()[i].length; j++) {
                this.setPixel(pixel, i, j);
            }
        }
    }



    // ************ Class specific methods ***********************

    // Set the value of an individual pixel (Character)
    public void setPixel(char pixel, int row, int column) {
            this.board[row][column] = pixel;
    }


    /*
    string: A string of arbitrary size, but it will be cut off if it exceeds the board space.
    row: The row which the string should be drawn in.
    column: The column which the string should be drawn in.
    orientation: The orientation of the string. There are four possible orientations
    0: bottom to top
    Example: 
    g
    n 
    i
    r
    t
    s
    1: left to right:
    Example:
    s t r i n g
    2: top to bottom:
    s
    t
    r
    r
    i
    n
    g
    3: right to left g n i r t string
    If the orientation is not between 0-3 it will be defaulted to 1 and an error message will be sent.
    */
    public void setObject(String string, int row, int column, int orientation) {
        switch (orientation) {
            // bottom to top
            case 0:
                for (int i = 0; i<string.length(); i++) {
                    this.setPixel(string.charAt(i), i-row, column);
                }
            break;
        }
    }


    // Draws the characters that are within the board variable.
    // Careful if there is more than one board being presented to the user this method will override other boards.
    public void drawBoard() {
        for (int i=0; i<this.getBoard().length; i++) {
            for (int j=0;j<this.getBoard()[i].length; j++) {
                System.out.print(this.getBoard()[i][j] + " ");
            }
            System.out.print('\n');
        }
    }






}