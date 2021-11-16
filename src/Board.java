package src;
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

    // Set the value of an individual pixel (Character)
    public void setPixel(char pixel, int row, int column) {
        this.board[row][column] = pixel;
    }

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
     * If a character is a white space e.g. '\0' that pixel will not be set.
     */
    public void setObject(String string, int row, int column, int orientation) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '\0') {
                continue;
            }
            switch (orientation) {
                // bottom to top
                case 0:
                        this.setPixel(string.charAt(i), row - i, column);
                    break;
                // left to right
                case 1:
                        this.setPixel(string.charAt(i), row, column + i);
                    break;
                // top to bottom
                case 2:
                        this.setPixel(string.charAt(i), row + i, column);
                    break;
                // right to left
                case 3:
                        this.setPixel(string.charAt(i), i, column - i);
                    break;
                // Default: left to right
                default:
                    this.setObject(string, row, column, 1);
                }
        }
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
                this.setPixel(characters[i], i, column - i);

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
        for (int i = 0; i <characters.length; i++) {
            for (int j=0; j<characters.length; j++) {
                this.setPixel(characters[i][j], i+row, j+column);
            }
        }

    }

    // Draws the characters that are within the board variable.
    // Careful if there is more than one board being presented to the user this
    // method will override other boards.
    public void drawBoard() {
        for (int i = 0; i < this.getBoard().length; i++) {
            for (int j = 0; j < this.getBoard()[i].length; j++) {
                System.out.print(this.getBoard()[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

}