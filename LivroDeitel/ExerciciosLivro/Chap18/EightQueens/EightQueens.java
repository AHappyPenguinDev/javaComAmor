import java.util.List;
import java.util.ArrayList;

public class EightQueens {
  public static void main(String[] args) {
    int boardDimension = 8;
    drawBoard(nQueens(boardDimension).get(90), boardDimension);
  }

  public static List<List<Integer>> nQueens(int boardDimension) {
    List<List<Integer>> result = new ArrayList<>();

    solveNQueens(boardDimension, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private static void solveNQueens(int bd, int row, List<Integer> colPlacements,
      List<List<Integer>> result) { // colPlacements's index is the row, the value . [0,1] is 0,0 - 0,1, an
                                    // attacking position

    if (row == bd) { // If at the last row, add colPlacements arraylist to list or affrl
      result.add(new ArrayList<>(colPlacements)); // Our goal
    } else {
      for (int col = 0; col < bd; col++) {
        colPlacements.add(col);
        if (isValid(colPlacements)) { // our constraint
          solveNQueens(bd, row + 1, colPlacements, result);
        }
        colPlacements.remove(colPlacements.size() - 1); // Undo our choice
      }
    }
  }

  private static boolean isValid(List<Integer> colPlacements) {
    int rowId = colPlacements.size() - 1;
    for (int i = 0; i < rowId; i++) {
      int diff = Math.abs(colPlacements.get(i) - colPlacements.get(rowId));
      if (diff == 0 || diff == rowId - i) {
        return false;
      }
    }
    return true;
  }

  public static void drawBoard(List<Integer> positions, int bd) {
    String[][] board = new String[8][8]; // This will change to be "e" or "q" (queen) position I specify
    for (int row = 0; row < bd; row++) {
      for (int col = 0; col < bd; col++) {
        if (row == positions.indexOf(col)) {
          board[row][col] = "Q";
        } else {
          board[row][col] = "-";
        }
      }
    }
    for (int i = 0; i < bd; i++) {
      for (int j = 0; j < bd; j++) {
        System.out.printf("%s %s",
            board[i][j], (j + 1) % 8 == 0 ? "\n" : ""); // prints board, e stands for "empty"
      }
    }
    System.out.println();
  }

}
