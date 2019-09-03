import java.awt.Color;

import tegels.KruisTegel;
import tegels.Vloer;

public class KruisTegelVloer {

  /*
 * Tekent een vloer van 10 x 10
 * identieke tegels.
 */
  public static void main(String[] args) {
    Vloer vloer = new Vloer();
    for (int i=1; i <= 10; i++) {
      for (int j=1; j <= 10; j++) {
        vloer.legTegel(new KruisTegel(Color.blue));
      }
      vloer.nieuweRij();
    }
  }
}
