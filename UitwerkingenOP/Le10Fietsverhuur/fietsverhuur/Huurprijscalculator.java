package fietsverhuur;

/*
 * Klasse voor het berekenen van de huurprijs van een
 * fiets volgens de specificatie in tabel 10.3 van
 * leereenheid 10.
 */
public class Huurprijscalculator {
  
  // enumeratietype voor de drie fietssoorten
  public enum Fietssoort {STADSFIETS, 
                          VERSNELLINGSFIETS, 
                          KINDERFIETS}
  
  // constanten
  public static final double BASISHUUR = 4.00;
  public static final double BASISUREN = 2.0;
  public static final double UURTOESLAG = 1.00;
  public static final double MAXDAGPRIJS = 8.00;
  public static final double VERSNELLINGSFACTOR = 1.40;
  public static final double KINDFACTOR = 0.8;
  public static final double WEEKENDFACTOR = 1.25;
  public static final double VERZEKERING = 2.50;
  
  /*
   * Berekent de huurprijs gegeven het soort fiets, het
   * aantal uren, al dan niet weekend, en wel of geen 
   * verzekering. Als het aantal uren negatief is of
   * groter dan 16, wordt -1 teruggegeven.
   */
  public static double bepaalHuurprijs(
                   Fietssoort soort, int uren, 
                   boolean weekend, boolean verzekering){
    // controleer eerst het aantal uren.
    if (uren < 0 || uren > 16)
      return -1;

    // bepaal eerst de bedragen uit de tabel die gebruikt
    // moeten worden
    double factor;
    switch (soort) {
      case KINDERFIETS:
        factor = KINDFACTOR;
        break;
      case VERSNELLINGSFIETS:
        factor = VERSNELLINGSFACTOR;
        break;
      default:
        factor = 1;
    }
    double basishuur = factor * BASISHUUR;
    double uurtoeslag = factor * UURTOESLAG;
    double maxdagprijs = factor * MAXDAGPRIJS;
    
    // bereken nu de huur op grond van de andere gegevens
    double huurprijs = basishuur;
    if (uren > BASISUREN) {
      huurprijs = 
        huurprijs + (uren - BASISUREN) * uurtoeslag;
    }
    if (huurprijs > maxdagprijs) {
      huurprijs = maxdagprijs;
     }
    if (weekend) {
      huurprijs = huurprijs * WEEKENDFACTOR;
    }
    if (verzekering) {
      huurprijs = huurprijs + VERZEKERING;
    }
    return huurprijs;
  }
}
