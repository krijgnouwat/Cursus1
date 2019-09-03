import java.awt.Color;

import tegels.HoekTegel;
import tegels.Vloer;

/*
 * Deze klasse tekent een vloer van 10 x 10 
 * asymmetrische tegels. Er is een herhalend patroon
 * van zestien tegels.
 */
public class TweekleurenVloer {
  
  /*
   * Tekent de vloer. Van elke tegel wordt
   * afzonderlijk bepaald welke kleur die moet
   * krijgen en hoeveel slagen die gedraaid moet worden.
   */
  public static void main(String[] args) {
    Vloer vloer = new Vloer();
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= 10; j++) {
        int draai = bepaalDraai(i, j);
        Color kleur = bepaalKleur(i, j);
        vloer.legTegel(new HoekTegel(kleur), draai);          
        }
      vloer.nieuweRij();
    }
  }
  
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
   * Deze hulpmethode bepaalt de kleur van de 
   * tegel op de i-de rij en ede j-de kolom.
   */
  private static Color bepaalKleur(int i, int j) {
    if (   (i % 4 == 0 || i % 4 == 3)
        && (j % 4 == 0 || j % 4 == 3))
      return Color.RED;
    else
      return Color.DARK_GRAY;
  }
 
}
