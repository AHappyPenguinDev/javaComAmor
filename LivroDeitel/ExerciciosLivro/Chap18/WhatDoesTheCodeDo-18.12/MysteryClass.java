
public class MysteryClass {
  public static void mystery(int[] array2, int x, int y) {
    if (x < y) {
      int temp = array2[x];
      array2[x] = array2[y];
      array2[y] = temp;
      x++;
      y--;
      mystery(array2, x, y);
    }

  // I know there is an error, this is how it is in my book. I don't know if it is
  // intentional or not
  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    mystery(array, 0, array.length - 1);
    for (int e : array)
      System.out.println(e);
  }
}
