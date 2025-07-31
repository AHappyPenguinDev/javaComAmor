import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeGenerator {
  String[][] maze;
  int rowNum;
  int colNum;
  private int startingRow;
  List<int[]> path;

  public MazeGenerator(int rowNum, int colNum) {
    this.rowNum = rowNum;
    this.colNum = colNum;
    maze = new String[rowNum][colNum];
  }

  private final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public String[][] generateMaze() { // row num and col num are the dimensions
    for (int row = 0; row < rowNum; row++) {
      for (int col = 0; col < colNum; col++) {
        addBorder(row, col); // add borders around maze
        addInBetween(row, col); // add spaces in the middle (replace space with dot to get effect like in the
        // book)
      }
    }
    makeEntranceAndExit(rowNum, colNum); // create maze exit, start and init startingRow instance variable
    createRandomPath();
    for (int[] position : path) // add random path to array
      maze[position[0]][position[1]] = "○";
    return maze;
  }

  private void addBorder(int row, int col) {
    // if row = 0, or row = rowNum, loop over each col in maze and add '-'
    if (row == 0 || row == rowNum - 1) {
      System.out.printf("Adding - (line) to Row: %d, Col: %d%n", row, col);
      maze[row][col] = "-";
      return;
    }

    // if col = 0 or col = colNum, loop over each row and add '|'
    if (col == 0 || col == colNum - 1) {
      System.out.printf("Adding | (pipe) to Row: %d, Col: %d%n", row, col);
      maze[row][col] = "|";
    }
  }

  private void addInBetween(int row, int col) {
    if (row != 0 && row + 1 != 0 && col != 0 && col != 0)
      maze[row][col] = " ";
  }

  private void makeEntranceAndExit(int rowNum, int colNum) {
    SecureRandom random = new SecureRandom();
    startingRow = random.nextInt(1, rowNum - 1);
    maze[startingRow][0] = ".";
    maze[random.nextInt(1, rowNum - 1)][colNum - 1] = ".";
  }

  private void createRandomPath() {
    path = new ArrayList<>();
    createRandomPath(startingRow, 0);
  }

  private boolean createRandomPath(int row, int col) {
    // Find path to the exit from the entrance
    if (row <= 0 || col < 0 || row >= rowNum || col >= colNum) {// if invalid, return false
      System.out.printf("%nWait,this is false already? Row: %d, Col: %d%n", row, col);
      return false;
    }

    if (col == colNum - 1) { // this is the goal, get to the last col and find the dot
      System.out.printf("Goal reached %n");
      return true;
    }

    path.add(new int[] { row, col }); // decision
    System.out.printf("Path contents: %s%n", path);
    for (int[] direction : DIRECTIONS) {
      System.out.printf("loop: row: %d , col: %d%n", row, col);
      int newRow = row + direction[0];
      int newCol = col + direction[1];
      if (createRandomPath(newRow, newCol))
        return true;
    }

    path.remove(col); // undo decision
    return false;
  }
}
