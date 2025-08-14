public class TowersOfHanoi {
  // recursively move disks between towers
  public static void solveTowers(int disks, int sourcePeg,
      int destinationPeg, int tempPeg, int count) {

    // base case -- only one disk to move
    if (disks == 1) {
      System.out.printf("%n%-20s %10d --> %d", "Oh damn disk is one. ", sourcePeg, destinationPeg);
      return;
    }

    // recursion step -- move (disk - 1) disks from sourcePeg
    // to tempPeg using destinationPeg
    solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg, count);

    // move last disk from sourcePeg to destinationPeg
    System.out.printf("%n%-20s %10d --> %d", "Look mom I reached Systout. ", sourcePeg, destinationPeg);

    // move (disks - 1) disks from tempPeg to destinationPeg
    solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg, count);
  }

  public static void main(String[] args) {
    int startPeg = 1; // value 1 used to indicate startPeg in output
    int endPeg = 3; // value 3 used to indicate endPeg in output
    int tempPeg = 2; // value 2 used to indicate tempPeg in output
    int totalDisks = 3; // number of disks
    int count = 0;

    // initial nonrecursive call: move all disks.
    solveTowers(totalDisks, startPeg, endPeg, tempPeg, count);
  }
}
