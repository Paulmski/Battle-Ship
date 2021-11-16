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


   /*

   */
    private void setBoard(char[][] board) {
        for (int i=0; i<this.getBoard().length; i++) {
            for (int j=0;j<this.getBoard()[i].length; j++) {
                this.setPixel(board[i][j], i, j);
            }
        }
    }



    // ************ Class specific methods ***********************

    // Set the value of an individual pixel (Character)
    public void setPixel(char pixel, int row, int column) {
        this.board[row][column] = pixel;
    }


    // Draws the characters that are within the board variable.
    // Careful if there is more than one board being presented to the user this method will override other boards.
    public void drawBoard() {
        for (int i=0; i<this.getBoard().length; i++) {
            for (int j=0;j<this.getBoard()[i].length; j++) {
                System.out.println(this.getBoard()[i][j]);
            }
        }
    }






}