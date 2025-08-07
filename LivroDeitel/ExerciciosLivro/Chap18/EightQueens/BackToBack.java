import java.util.List;
import java.util.ArrayList;

public class BackToBack {
  public static List<List<Integer>> nQueens(int n) {
    List<List<Integer>> result = new ArrayList<>();

    solveNQueens(n, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private static void solveNQueens(int n, int row, List<Integer> colPlacements, List<List<Integer>> result) {

    if (row == n) {
      result.add(new ArrayList<>(colPlacements)); // Our goal
    } else {
      for (int col = 0; col < n; col++) {
        colPlacements.add(col);
        if (isValid(colPlacements)) { // our constraint
          solveNQueens(n, row + 1, colPlacements, result);
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

  public static void main(String[] args) {
    int n = 8;
    System.out.println(nQueens(n));
  }
}
