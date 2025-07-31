public class MazeGeneratorTest {
  public static void main(String[] args) {
    int rowNum = 12;
    int colNum = 12;

    MazeGenerator mGenerator = new MazeGenerator(rowNum, colNum);
    String[][] maze = mGenerator.generateMaze();
    for (int i = 0; i < rowNum; i++) {
      for (int j = 0; j < colNum; j++) {
        String symbol = maze[i][j];
        System.out.printf("%s ", maze[i][j]);
      }
      System.out.println();
    }
  }
}
