import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeTraversal {
  private String[][] maze; // maze array
  private int ms;
  private boolean[][] visited; // visited positions
  private List<int[]> path; // visited positions
  private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public MazeTraversal(int mazeSize) { // constructor to initialize maze with the contents of maze.txt
    ms = mazeSize;
    maze = new String[ms][ms];
    visited = new boolean[ms][ms];
    path = new ArrayList<>();

    // Fill maze array
    try (BufferedReader br = new BufferedReader(new FileReader("maze.txt"))) {
      for (int row = 0; row < maze.length; row++) {
        String line = br.readLine();
        String[] tiles = line.split(" "); // splits line into an array of individual tiles
        for (int col = 0; col < maze.length; col++) {
          maze[row][col] = tiles[col];
          System.out.printf("Maze in row %d, col %d: %s%n%n", row, col, maze[row][col]);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<int[]> solveMaze() {
    if (solveMaze(2, 0))
      return path;
    return null;
  }

  private boolean solveMaze(int row, int col) {

    // if at an invalid position, return false
    if (row < 0 || col < 0 || row >= ms || col >= ms)
      return false;

    if (maze[row][col].equals("#") || visited[row][col]) {
      return false;
    }

    path.add(new int[] { row, col });
    visited[row][col] = true;

    // this is the goal. If col is at the last postion, a solution was found :)
    if (col == ms - 1)
      return true;

    for (int[] direction : DIRECTIONS) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];
      if (solveMaze(newRow, newCol))
        return true; // path found in recursion
    }

    System.out.printf("Path contents: %s%n", Arrays.toString(path.get(row)));
    path.remove(col);
    return false;
  }

  public void drawMaze(List<int[]> solvedPath) {
    // Mark path with 'X'
    if (solvedPath != null) {
      for (int[] position : solvedPath) {
        maze[position[0]][position[1]] = "○"; // I couldn't help it. X and hashtags look TOO DAMN UGLY. So i'm using
                                              // this circle
      }
    }

    // Print maze
    for (int i = 0; i < ms; i++) {
      for (int j = 0; j < ms; j++) {
        String symbol = maze[i][j];
        System.out.printf("%s ", symbol.equals(".") ? " " : maze[i][j]); // replace all dots with spaces because i'm
                                                                         // lazy to do it manually
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Create maze
    int size = 12;
    MazeTraversal maze = new MazeTraversal(size);
    // Solve
    maze.drawMaze(maze.solveMaze());
  }
}
