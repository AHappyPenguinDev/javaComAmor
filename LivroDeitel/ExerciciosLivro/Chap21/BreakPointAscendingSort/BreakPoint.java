import com.deitel.datastructures.BreakPointList;
import java.util.List;

public class BreakPoint {

  public static void main(String[] args) {
    List<Integer> integerList = List.of(0, 1, 2, 2, 4, 9, 1);
    BreakPointList<Integer> list1 = new BreakPointList<>();

    // insert integers in list
    list1.breakPoint(integerList);
  }
}
