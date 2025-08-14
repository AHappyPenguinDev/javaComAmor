//This was a pretty hard question to understand, but this video here: https://www.youtube.com/watch?v=wGbuCyNpxIg
//Helped me a lot. They also have a video explaining backtracking which I found really cool (Backtracking Blueprint)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EightQueens {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Insert board dimensions. (e.g. 8 = 8x8)");
    int boardDimension = Integer.parseInt(scanner.nextLine());
    List<List<Integer>> solutions = nQueens(boardDimension);
    int solSize = solutions.size();
    System.out.printf("%n\t** There %s %d possible solution%s **", solSize > 1 ? "are" : "is", solSize,
        solSize > 1 ? "s" : ""); // formatting in case board is 1x1 (idk why the 1x1 board shows up as 3x3)

    while (true) {
      System.out.printf("%nInsert the index of the solution you would like to view.%nOr, insert q to exit%n");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("q"))
        break;

      System.out.printf("%n-----------------------------------------------%n");
      int index = Integer.parseInt(input);
      index--;
      drawBoard(solutions.get(index), boardDimension);
      System.out.printf("-----------------------------------------------%n");
    }
    scanner.close();
  }

  public static List<List<Integer>> nQueens(int boardDimension) {
    List<List<Integer>> result = new ArrayList<>();

    solveNQueens(boardDimension, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private static void solveNQueens(int bd, int row, List<Integer> colPlacements,
      List<List<Integer>> result) { // colPlacements's index is actually the row, the value . [0,1] is 0,0 - 0,1

    // makes sure board sizes under 4 don't show up as having 0 solutions
    if (bd < 4) {
      colPlacements.add(1);
      result.add(new ArrayList<>(colPlacements));
    }

    if (row == bd) // If at the last row, add colPlacements to list
      result.add(new ArrayList<>(colPlacements)); // goal, I need to get here

    for (int col = 0; col < bd; col++) {
      colPlacements.add(col);
      if (isValid(colPlacements)) { // constraint, it only leaves the recursion loop once the placement is not valid
        solveNQueens(bd, row + 1, colPlacements, result);
      }
      colPlacements.remove(colPlacements.size() - 1); // undo choice
    }

  }

  // Solving row by row, so it's impossible to place 2 queens in the same row,
  // don't need to check.
  // Need to check vertical and diagonal
  private static boolean isValid(List<Integer> colPlacements) {
    int rowId = colPlacements.size() - 1;
    for (int i = 0; i < rowId; i++) {
      int diff = Math.abs(colPlacements.get(i) - colPlacements.get(rowId));
      if (diff == 0 || diff == rowId - i)
        return false;
    }
    return true;
  }

  // this function draws the board by checking if the current position is in the
  // positions array or not and inserting the corresponding value into the array
  public static void drawBoard(List<Integer> positions, int bd) {
    String[][] board = new String[bd][bd];
    for (int row = 0; row < bd; row++) {
      for (int col = 0; col < bd; col++) {
        if (row == positions.indexOf(col)) {
          board[row][col] = "Q";
        } else {
          board[row][col] = "-";
        }
      }
    }

    System.out.print("\t\t"); // this is for indenting
    for (int i = 0; i < bd; i++) {
      for (int j = 0; j < bd; j++) {
        System.out.printf("%s %s",
            board[i][j], (j + 1) == bd ? "\n\t\t" : ""); // if j == board dimension, go to next line (with tab for
                                                         // indenting)
      }
    }
    System.out.println(); // Fun fact: They do this println at the end in the book a couple of times, and
    // I believe this is because on zsh there is a "%" sign highlighting that this
    // is a partial line.
    // At least this is what I will use it for, because it gets rid of the "%" at
    // the end of lines" :)
  }

}
