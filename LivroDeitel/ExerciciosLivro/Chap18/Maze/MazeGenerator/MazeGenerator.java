import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeGenerator {
  String[][] maze;
  int rowNum;
  int colNum;
  private int startRow;
  private int endRow;
  List<int[]> path;
<<<<<<< HEAD
=======
  boolean[][] visited;
>>>>>>> 7cacd7e (i love githuuuuuuuuuuuuub)

  public MazeGenerator(int rowNum, int colNum) {
    this.rowNum = rowNum;
    this.colNum = colNum;
    maze = new String[rowNum][colNum];
  }

<<<<<<< HEAD
  private final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
=======
  private final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
>>>>>>> 7cacd7e (i love githuuuuuuuuuuuuub)

  public String[][] generateMaze() { // row num and col num are the dimensions
    for (int row = 0; row < rowNum; row++) {
      for (int col = 0; col < colNum; col++) {
        addBorder(row, col); // add borders around maze
        addInBetween(row, col); // add spaces in the middle (replace space with dot to get effect like in the
        // book)
      }
    }
    makeEntranceAndExit(rowNum, colNum); // create maze exit, start and init startRow instance variable
    createRandomPath();
    for (int[] position : path) // add random path to array
      maze[position[0]][position[1]] = "○";
    return maze;
  }

  private void addBorder(int row, int col) {
    // if row = 0, or row = rowNum, loop over each col in maze and add '-'
    if (row == 0 || row == rowNum - 1) {
      maze[row][col] = "-";
      return;
    }

    // if col = 0 or col = colNum, loop over each row and add '|'
    if (col == 0 || col == colNum - 1) {
      maze[row][col] = "|";
      return;
    }
  }

  private void addInBetween(int row, int col) {
    if (row != 0 && row != rowNum - 1 && col != 0 && col != colNum - 1)
      maze[row][col] = ".";
  }

  private void makeEntranceAndExit(int rowNum, int colNum) {
    SecureRandom random = new SecureRandom();
    startRow = random.nextInt(1, rowNum - 1);
<<<<<<< HEAD
    endRow = random.nextInt(1, rowNum - 1);
=======
    System.out.printf("Start Row: %d%n", startRow);
    endRow = random.nextInt(1, rowNum - 1);
    System.out.printf("End Row: %d%n", endRow);
>>>>>>> 7cacd7e (i love githuuuuuuuuuuuuub)
    maze[startRow][0] = ".";
    maze[endRow][colNum - 1] = ".";
  }

  private void createRandomPath() {
    path = new ArrayList<>();
<<<<<<< HEAD
=======
    visited = new boolean[rowNum][colNum];
>>>>>>> 7cacd7e (i love githuuuuuuuuuuuuub)
    createRandomPath(startRow, 0);
  }

  private boolean createRandomPath(int row, int col) {
    // Find path to the exit from the entrance
    if (row <= 0 || col < 0 || row >= rowNum - 1 || col >= colNum) {// if in invalid position, return false
      System.out.printf("%nWait,this is false already? Row: %d, Col: %d%n", row, col);
      return false;
    }

<<<<<<< HEAD
    if (maze[row][col].equals("|"))
      return false;

    path.add(new int[] { row, col }); // decision
=======
    // If at a wall, return false
    if (maze[row][col].equals("|") || visited[row][col])
      return false;

    path.add(new int[] { row, col }); // decision
    visited[row][col] = true;
>>>>>>> 7cacd7e (i love githuuuuuuuuuuuuub)

    if (col == colNum - 1) { // this is the goal, get to the last col at specific row and find the dot
      System.out.printf("Goal reached, path contents: %n");
      path.forEach(array -> System.out.println(Arrays.toString(array)));
      return true;
    }

    for (int[] direction : DIRECTIONS) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];
      if (createRandomPath(newRow, newCol))
        return true;
    }

    path.remove(path.size() - 1); // undo last decision
    return false;
  }
}
