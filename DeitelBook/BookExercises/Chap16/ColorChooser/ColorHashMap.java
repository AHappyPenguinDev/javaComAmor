import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.paint.Color;

public class ColorHashMap {
  Map<String, Color> map;

  // DARKGRAY and LIGHTGRAY don't work for some reason
  public ColorHashMap() {
    map = new HashMap<>();
    map.put("black", Color.BLACK);
    map.put("blue", Color.BLUE);
    map.put("cyan", Color.CYAN);
    map.put("darkGray", Color.DARKGRAY);
    map.put("green", Color.GREEN);
    map.put("lightGray", Color.LIGHTGRAY);
    map.put("magenta", Color.MAGENTA);
    map.put("orange", Color.ORANGE);
    map.put("pink", Color.PINK);
    map.put("red", Color.RED);
    map.put("white", Color.WHITE);
    map.put("yellow", Color.YELLOW);
  }

  public Color getColor(String color) {
    return map.get(color);
  }
}
