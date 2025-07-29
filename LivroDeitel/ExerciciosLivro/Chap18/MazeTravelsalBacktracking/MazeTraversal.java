import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class MazeTraversal {
  String[][] maze; // instance variable maze

  public MazeTraversal(String[][] maze) { // constructor to initialize maze with the contents of maze.txt
    int size = maze.length;
    this.maze = new String[size][size];

    try (BufferedReader br = new BufferedReader(new FileReader("maze.txt"))) {
      for (int row = 0; row < size; row++) {
        String line = br.readLine();
        String[] tiles = line.split(" "); // splits line into an array of individual tiles
        for (int col = 0; col < size; col++) {
          maze[row][col] = tiles[col];
          System.out.printf("Maze in row %d, col %d: %s%n", row, col, maze[row][col]);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String[][] getMaze(int size) {
    return maze;
  }

  // public void solveMaze() {
  //
  // }

  public void drawMaze() {

  }

  public static void main(String[] args) {
    // Tilemap
    int size = 12;
    MazeTraversal maze = new MazeTraversal(new String[size][size]);
    // Solve
    // drawMaze(solveMaze());
  }
}
