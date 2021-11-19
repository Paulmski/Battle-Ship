/**
 * @author Paul Molczanski
 * @email paulmski@gmail.com
 * @create date November 16, 2021 12:47
 * @modify date November 16, 2021 12:47
 * @desc This class is responsible for drawing to the screen and contains
 *       different helper methods to simplify drawing.
 */

public class Board {
    // The width of the board which will be generated
    private int width;
    // The height of the board which will be generated
    private int height;
    // A 2D array which holds the value of each "pixel" that is being drawn on the
    // board which is being presented to the user.
    private char[][] board;
    // The default pixel value if no other value has been assigned.
    private char blankPixel;
    /*
     * Due to the exponential work of managing multiple objects and continually
     * redrawing them, Ships or Boards can be added with the addObject() method,
     * meaning the next time this board is redrawn it will redraw the values held in
     * the subObjects array. Subobject positioning is held in the subObjectPositions
     * array.
     */
    private Board[] subBoards = new Board[10];

    // Each element contains the row, column, and orientation of the same indexed
    // subBoard.
    private int[][] subBoardPositions = new int[10][2];

    // Constructors
    Board(int width, int height, char blankPixel) {
        this.setWidth(width);
        this.setHeight(height);
        this.setBlankPixel(blankPixel);
        this.setBoard(new char[height][width]);

    }

    // *********** Setter and Getter methods ***********
    public int getWidth() {
        return this.width;
    }

    // Board can not dynamically change width
    private void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    // Board can not dynamically change height
    private void setHeight(int height) {
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
        for (int i = 0; i < this.getBoard().length; i++) {
            for (int j = 0; j < this.getBoard()[i].length; j++) {
                this.setPixel(this.getBlankPixel(), i, j);
            }
        }
    }

    // TODO: add description
    public void setBoard(char[][] board) {
        this.board = board;
        for (int i = 0; i < this.getBoard().length; i++) {
            for (int j = 0; j < this.getBoard()[i].length; j++) {
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
        for (int i = 0; i < this.getBoard().length; i++) {
            for (int j = 0; j < this.getBoard()[i].length; j++) {
                this.setPixel(pixel, i, j);
            }
        }
    }

    // ************ Class specific methods ***********************

    // A simple helper method to clear the screen of all previous characters.
    public static void drawBlank() {
        // The ANSI escape code to clear the screen.
        System.out.print("\033c");

    }

    // Set the value of an individual pixel (Character)
    public void setPixel(char pixel, int row, int column) {
        try {
            this.board[row][column] = pixel;
        } catch (IndexOutOfBoundsException e) {
           /* If the pixel it is out of bounds it will simply not be drawn to the board. 
           Perhaps a log method could be used to document this out of bounds error, 
           but for the current scope of our classes learning catching this error
           and returning is satisfactory.
           */
        }
    }

    // Get the value of a specific pixel (Character)
    public char getPixel(int row, int column) {
        return this.getBoard()[row][column];
    }

    // TODO: Fix formatting of documentation.
    /*
     * string: A string of arbitrary size, but it will be cut off if it exceeds the
     * board space. row: The row which the string should be drawn in. column: The
     * column which the string should be drawn in. orientation: The orientation of
     * the string. There are four possible orientations 0: bottom to top Example: g
     * n i r t s 1: left to right: Example: s t r i n g 2: top to bottom: Example: s
     * t r r i n g 3: right to left Example: g n i r t s
     * 
     * 
     * If the orientation is not between 0-3 it will be defaulted to 1.
     * 
     * If a character is a white space e.g. '\0' that pixel will not be set. The
     * return value is the position of each pixel in relationship to the board
     * instance.
     */
    public int[][] setObject(String string, int row, int column, int orientation) {
        int[][] pixels = new int[string.length()][2];
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '\0') {
                continue;
            }
            switch (orientation) {
            // bottom to top
            case 0:
                pixels[i][0] = row - i;
                pixels[i][1] = column;
                this.setPixel(string.charAt(i), row - i, column);
                break;
            // left to right
            case 1:
                pixels[i][0] = row;
                pixels[i][1] = column + i;
                this.setPixel(string.charAt(i), row, column + i);
                break;
            // top to bottom
            case 2:
                pixels[i][0] = row + i;
                pixels[i][1] = column;
                this.setPixel(string.charAt(i), row + i, column);
                break;
            // right to left
            case 3:
                pixels[i][0] = row;
                pixels[i][1] = column - i;
                this.setPixel(string.charAt(i), row, column - i);
                break;
            // Default: left to right
            default:
                pixels[i][0] = row + i;
                pixels[i][1] = column;
                this.setObject(string, row, column + i, 1);
            }
        }
        return pixels;
    }

    // Used to check the values of pixels without overwriting them.
    public Pixel[] getPixels(int length, int row, int column, int orientation) {
        Pixel[] pixels = new Pixel[length];
        for (int i = 0; i < length; i++) {
            pixels[i] = new Pixel();

            try {
                switch (orientation) {
                // bottom to top
                case 0:
                    pixels[i].setValue(this.getBoard()[row - i][column]);
                    pixels[i].setRow(row - i);
                    pixels[i].setColumn(column);
                    break;
                // left to right
                case 1:
                    pixels[i].setValue(this.getBoard()[row][column + i]);
                    pixels[i].setRow(row);
                    pixels[i].setColumn(column + i);
                    break;
                // top to bottom
                case 2:
                    pixels[i].setValue(this.getBoard()[row + i][column]);
                    pixels[i].setRow(row + i);
                    pixels[i].setColumn(column);
                    break;
                // right to left
                case 3:
                    pixels[i].setValue(this.getBoard()[row][column + i]);
                    pixels[i].setRow(row);
                    pixels[i].setColumn(column - i);
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                return pixels;
            }
        }

        return pixels;
    }

    public void setObject(char[] characters, int row, int column, int orientation) {

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '\0') {
                continue;
            }
            switch (orientation) {
            // bottom to top
            case 0:
                this.setPixel(characters[i], row - i, column);

                break;
            // left to right
            case 1:
                this.setPixel(characters[i], row, column + i);

                break;
            // top to bottom
            case 2:
                this.setPixel(characters[i], row + i, column);

                break;
            // right to left
            case 3:
                this.setPixel(characters[i], row, column - i);

                break;
            // Default: left to right
            default:
                this.setObject(characters, row, column, 1);
            }
        }

    }


   

    // The implementation of drawing a 2d is slightly different than the other two
    // implementations.
    /*
     * characters: A 2d array of characters which represent the 2d space in which
     * the character should be displayed. row: The row which the characters should
     * start at. column: The column which the characters should start at. Drawing
     * begins in the top left corner of the object.
     */
    public void setObject(char[][] characters, int row, int column) {
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                this.setPixel(characters[i][j], i + row, j + column);
            }
        }

    }

    // A convenience function to center the string in any given row within the
    // board.
    public void centerString(String string, int row) {
        int start = (this.getWidth() / 2) - (string.length() / 2);
        for (int i = 0; i < string.length(); i++) {
            this.setPixel(string.charAt(i), row, start + i);
        }
    }

    // Draws the characters that are within the board variable.
    // Careful if there is more than one board being presented to the user this
    // method will override other boards.
    public void drawBoard() {
        for (int i = 0; i < this.subBoards.length; i++) {
            if (this.subBoards[i] != null) {
                this.setObject(this.subBoards[i].getBoard(), this.subBoardPositions[i][0],
                        this.subBoardPositions[i][1]);
            }
        }

        for (int i = 0; i < this.getBoard().length; i++) {
            for (int j = 0; j < this.getBoard()[i].length; j++) {
                System.out.print(this.getBoard()[i][j] + " ");
            }
            System.out.print('\n');
        }

    }

    /*
     * This adds the board to the subObjects array, meaning the next time the
     * drawBoard method is called this board will be redrawn with the board.
     */
    public void addBoard(Board board, int row, int column) {
        for (int i = 0; i < this.subBoards.length; i++) {
            if (this.subBoards[i] == null) {
                this.subBoards[i] = board;
                this.subBoardPositions[i][0] = row;
                this.subBoardPositions[i][1] = column;
                return;
            }
        }
    }

    // A function to wipe all pixels to the blank pixel.
    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                this.setPixel(blankPixel, i, j);
            }
        }
    }

    // A more harsh version of of clearBoard which wipes all pixels to the blank pixel and removes all subBoards.
    public void resetBoard() {
        this.clearBoard();
        for (int i = 0; i < subBoards.length; i++) {
            subBoards[i] = null;
        }
    }

}