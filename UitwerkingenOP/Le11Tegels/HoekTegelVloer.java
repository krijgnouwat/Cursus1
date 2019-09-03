import java.awt.Color;
import tegels.HoekTegel;
import tegels.Vloer;

/*
 * Deze klasse tekent een vloer van 10 x 10 
 * asymmetrische tegels. Er is een herhalend patroon
 * van vier tegels die steeds een slag gedraaid zijn.
 */
public class HoekTegelVloer {

  /*
   * Deze hulpmethode bepaalt hoeveel slagen de
   * tegel op de i-de rij en j-de kolom gedraaid
   * moet worden.
   */
  private static int bepaalDraai(int i, int j) {
    if (i % 2 == 1 && j % 2 == 1) {     // i en j oneven
      return 0;
    } 
    else if (i % 2 == 1 && j % 2 == 0) { // i oneven, j even
      return 1;
    }
    else if (i % 2 == 0 && j % 2 == 0) { // i en j even
      return 2;
    }
    else  {                              // i even, j on even
      return 3;
    }  
  }
  
  /*
   * Maakt een nieuwe vloer en legt rij voor rij 
   * de tegels. De tweede aanpak uit paragraaf 3.2 
   * van leereenheid 11 is gevolgd; de code voor de
   * eerste aanpak is als commentaar toegevoegd.
   */
  public static void main(String[] args) {   
    Vloer vloer = new Vloer();

//    Aanpak 1
//    for (int i = 1; i <= 5; i++) {
//      for (int j = 1; j <= 5; j++) {
//        vloer.legTegel(new HoekTegel(Color.RED), 0);
//        vloer.legTegel(new HoekTegel(Color.RED), 1);
//      }
//      vloer.nieuweRij();
//      for (int j = 1; j <= 5; j++) {
//        vloer.legTegel(new HoekTegel(Color.RED), 3);
//        vloer.legTegel(new HoekTegel(Color.RED), 2);
//      } 
//      vloer.nieuweRij();
//    } 
    
//  Aanpak 2
    for (int i=1; i <= 10; i++) {
      for (int j=1; j <=10; j++) {
        int draai = bepaalDraai(i, j);
        vloer.legTegel(new HoekTegel(Color.DARK_GRAY), draai);
      }
      vloer.nieuweRij();
    }


  }

}
