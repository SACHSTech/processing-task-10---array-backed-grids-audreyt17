import processing.core.PApplet;

/**
 * Draw 10 by 10 grid using 2D arrays, mousePressed triggers colour change of the clicked cell and its neighbours. Console prints out statistical summary of the grid.
 * @author: TaoA
 */

public class Sketch extends PApplet {

  public static final int CELL_WIDTH = 20;
  public static final int CELL_HEIGHT = 20;
  public static final int MARGIN = 5;
  public static final int ROW_COUNT = 10;
  public static final int COLUMN_COUNT = 10;
  public static final int SCREEN_WIDTH = calcCoord(COLUMN_COUNT, CELL_WIDTH);
  public static final int SCREEN_HEIGHT = calcCoord(ROW_COUNT, CELL_HEIGHT);

  public int[][] intGrid;  // grid of squares.  Set to 1 when clicked
  
  /**
   * This function calculuates the coordinate of a cell of dimension x, at location count (i.e. row or column count), taking margin into account.
   * @param count the location count
   * @param x the dimension of the cell
   * @return the coordinate of the cell
   */
  public static int calcCoord(int count, int x) {
    return count * (x + MARGIN) + MARGIN;
  }

    /**
   * This function calculuates the location count (i.e. row or column count) of a cell of dimension x, taking margin into account.
   * @param coord the coordinate
   * @param x the dimension of the cell
   * @return the location count.  If clicked within a margin, returns -1.
   */
  public static int calcCount(int coord, int x) {
    if (coord % (x + MARGIN) < MARGIN) {
      return -1;  // within a margin
    } else {
      return (int)coord / (x + MARGIN);
    }
  }
  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    intGrid = new int[ROW_COUNT][COLUMN_COUNT];
    background(0, 0, 0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    fill(255, 255, 255);

    for (int row = 0; row < ROW_COUNT; ++row) {
      for (int column = 0; column < COLUMN_COUNT; ++column) {
        if (intGrid[row][column] == 1) {
          fill(0, 255, 0);
        } else {
          fill(255, 255, 255);
        }
        rect(calcCoord(column, CELL_WIDTH),
             calcCoord(row, CELL_HEIGHT),
             CELL_WIDTH,
             CELL_HEIGHT);
      }
    }
  }

  /**
   * This function flips a cell at specified location.
   * @param row the row number
   * @param column the column number
   */
  public void flip(int row, int column) {
    intGrid[row][column] = 1 - intGrid[row][column];  
  }

  /**
   * This function caclulates the number of cells continuously selected in a row.
   * @param row the cells in a row
   * @return The size of the biggest block of cells continuously selected
   */
  public static int continuousCount(int[] row) {
    int max = 0;  // the size of the biggest block
    int count = 0;  // size of current block
    for (int i: row) {
      if (i == 0) {
        // end of a block
        if (max < count) {
          max = count;
        }
        count = 0;  // reset the count
      } else {
        ++count;  // increase the count
      }
    }
    if (max < count) {  // check final block
      max = count;
    }
    return max;
  }
  
  public void mousePressed() {
    int r = calcCount(mouseY, CELL_HEIGHT);
    int c = calcCount(mouseX, CELL_WIDTH);
    
    if (r != -1 && c != -1) {
      // clicked within a cell
      flip(r, c);

      // flip neighbouring cells
      if (r > 0) {
        flip(r-1, c);       
      }
      if (r < ROW_COUNT - 1) {
        flip(r+1, c);
      }
      if (c > 0) {
        flip(r, c-1);       
      }
      if (c < COLUMN_COUNT - 1) {
        flip(r, c+1);
      }
    }
    
    System.out.println("mouse coordinates: (" + mouseX + ", " + mouseY +
                       "); grid coordinates: (row:" + r +
                       ", column: " + c + ")");
    int selectedCell = 0;  // total number of selected cells
    int[] selectedRowCell = new int[ROW_COUNT];  // number of selected cells in each row
    int[] selectedColumnCell = new int[COLUMN_COUNT];  // number of selected cells in each column
    for (int i = 0; i < ROW_COUNT; ++i) {
      for (int j = 0; j < COLUMN_COUNT; ++j) {
        selectedRowCell[i] += intGrid[i][j];
        selectedColumnCell[j] += intGrid[i][j];
      }
      selectedCell += selectedRowCell[i];  // sum the total count
    }
    
    System.out.println("Total of " + selectedCell + " cells are selected.");
    for (int i = 0; i < ROW_COUNT; ++i) {
      int count = continuousCount(intGrid[i]);
      if (count > 2) {
        System.out.println("There are " + count + " continuous blocks selected on row " + i + ".");
      }
      System.out.println("Row "+ i + " has " + selectedRowCell[i] + " cells selected.");
    }
    for (int j = 0; j < COLUMN_COUNT; ++j) {
      System.out.println("Column "+ j + " has " + selectedColumnCell[j] + " cells selected.");
    }
  }
}