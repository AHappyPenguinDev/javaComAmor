public class Pair<F, S> {
  F element1;
  S element2;

  public Pair(F element1, S element2) {
    this.element1 = element1;
    this.element2 = element2;
  }

  public F getElement1() {
    return element1;
  }

  public S getElement2() {
    return element2;
  }

  public void setElement1(F element1) {
    this.element1 = element1;
  }

  public void setElement2(S element2) {
    this.element2 = element2;
  }

  public static void main(String[] args) {
    Pair pair1 = new Pair(1, "two");
    Pair pair2 = new Pair(true, false);

    System.out.printf("Element 1: %s%n", pair1.getElement1());
    System.out.printf("Element 2: %s%n", pair1.getElement2());
    System.out.println();
    System.out.printf("Element 1: %s%n", pair2.getElement2());
    System.out.printf("Element 2: %s%n", pair2.getElement2());
  }
}
