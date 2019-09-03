package test;

import fietsverhuur.Huurprijscalculator;
import fietsverhuur.Huurprijscalculator.Fietssoort;

/* 
 * Testklasse voor de klasse Huurprijscalculator. 
 * De testgevallen zijn:
 * 1. Stadsfiets voor 2 uur, geen weekend, geen verzekering
 * 2. Kinderfiets voor 5 uur, geen weekend, wel verzekering
 * 3. Kinderfiets voor 5 uur, wel weekend, geen verzekering
 * 4. Versnellingsfiets voor 10 uur, wel weekend, wel verzekering
 */
public class HuurprijscalculatorTest {
  public static void main(String[] args) {
    double huurprijs;
    huurprijs = Huurprijscalculator.bepaalHuurprijs(Fietssoort.STADSFIETS, 2, false, false);
    System.out.println(huurprijs);
    huurprijs = Huurprijscalculator.bepaalHuurprijs(Fietssoort.KINDERFIETS, 5, false, true);
    System.out.println(huurprijs);
    huurprijs = Huurprijscalculator.bepaalHuurprijs(Fietssoort.KINDERFIETS, 5, true, false);
    System.out.println(huurprijs);
    huurprijs = Huurprijscalculator.bepaalHuurprijs(Fietssoort.VERSNELLINGSFIETS, 10, true, true);
    System.out.println(huurprijs);  
    huurprijs = Huurprijscalculator.bepaalHuurprijs(Fietssoort.STADSFIETS, 20, false, false);
    System.out.println(huurprijs);  
  }

}
