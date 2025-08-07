import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeTraversal {
  private String[][] maze; // maze array
  private int ms;
  private boolean[][] visited; // visited positions
<<<<<<< HEAD
  private List<int[]> path; // visited positions
=======
  private List<int[]> path;
>>>>>>> 7cacd7e (i love githuuuuuuuuuuuuub)
  private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

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
    if (row <= 0 || col < 0 || row >= ms - 1 || col >= ms)
      return false;

    if (maze[row][col].equals("#") || maze[row][col].equals("|") || visited[row][col])
      return false;

    path.add(new int[] { row, col });
    visited[row][col] = true;

    // this is the goal. If col is at the last postion, a solution was found :)
    if (col == ms - 1) {
      System.out.printf("Goal reached, Path:%n");
      path.forEach(array -> System.out.println(Arrays.toString(array)));
      return true;
    }

    // DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    for (int[] direction : DIRECTIONS) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];
      if (solveMaze(newRow, newCol))
        return true; // path found in recursion
    }

    path.remove(path.size() - 1);
    return false;

  }

  public void drawMaze(List<int[]> solvedPath) {
    // correct path highlighted with circle
    if (solvedPath != null) {
      for (int[] position : solvedPath) {
        maze[position[0]][position[1]] = "○"; // I couldn't help it. X and hashtags look TOO DAMN UGLY. So i'm using
                                              // this circle. Just replace it with X to make it like it is in the book
      }
    }

    // print maze with solved path
    for (int i = 0; i < ms; i++) {
      for (int j = 0; j < ms; j++) {
        System.out.printf("%s ", maze[i][j]);
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
