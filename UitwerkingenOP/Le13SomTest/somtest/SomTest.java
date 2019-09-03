package somtest;

import org.junit.Test;
import static org.junit.Assert.*;

public class SomTest {

  /**
   * Berekent de som van de eerste n niet-negatieve gehele  
   * getallen.
   * @param   n  het aantal op te tellen getallen
   * @return  de som van de eerste n niet-negatieve gehele 
   *          getallen
   */
  public static int som(int n) {
    int resultaat = 0;
    for (int i = 0; i < n; i++)
      resultaat = resultaat + i;
    return resultaat;
  }
  
  @Test
  public void testSom() {
    assertEquals(0, som(0)); //niets optellen levert 0
    assertEquals(0, som(1)); //alleen 0 optellen levert 0
    assertEquals(1, som(2)); //0 + 1 = 1
    assertEquals(3, som(3)); //0 + 1 + 2 = 3
    assertEquals(6, som(4)); //0 + 1 + 2 + 3 = 6
  }
}
