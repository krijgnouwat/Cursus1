package yahtzee;

/**
 * Klasse die een klein deel van het dobbelsteenspel 
 * Yahtzee modelleert: de aantallen ogen van een worp met 
 * vijf dobbelstenen worden bewaard in een attribuut ogen, 
 * en de scores die deze worp behaalt in de categorieen "3 
 * dezelfde", "carré", "full house" kunnen berekend 
 * worden.  
 * @author OUNL
 */
public class YahtzeeWorp {
  
  /**
   * Bewaart de aantallen ogen die in deze YahtzeeWorp 
   * met de vijf dobbelstenen gegooid zijn.
   */
  private int[] ogen = new int[5];
  
  /**
   * Creeert een nieuwe instantie van YahtzeeWorp,
   * geinitialiseerd met de (eerste vijf) elementen van de
   * meegegeven array.
   * Voorwaarde: de meegegeven array bevat 5 elementen.
   * @param ogen array met de initiele waarden van de 5 
   *             dobbelstenen 
   */
  public YahtzeeWorp(int[] ogen) {
    for (int i = 0; i < 5; i++) {
      this.ogen[i] = ogen[i];
    }
  }
   
  public int[] getOgen() {
    return ogen;
  }

  /**
   * Geeft een array terug met daarin achtereenvolgens de 
   * scores van deze YahtzeeWorp in de categorieen 
   * "3 dezelfde", "carré" en "full house".
   * @return een array met scores
   */
  public int[] getScores() {
    int[] scores = new int[3];
    scores[0] = nDezelfdeScore(3);
    scores[1] = nDezelfdeScore(4);
    scores[2] = fullHouseScore();
    return scores;
  }
  
  /**
   * Berekent de score van deze YahtzeeWorp in de 
   * categorie "n dezelfde". Geeft de som van alle ogen 
   * terug als inderdaad minstens n keer (0 <= n <= 5) 
   * hetzelfde aantal ogen in de worp voorkomt, anders 0.
   * @param n het gezochte aantal voorkomens van eenzelfde 
   *          getal
   * @return de som van alle ogen, of 0
   */
  public int nDezelfdeScore(int n) {
    for (int ogen = 1; ogen <= 6; ogen++) {
      if (telAantal(ogen) >= n) {
        return somVanAlleOgen();
      }
    }
    return 0;
  }
  
  /**
   * Berekent het totaal aantal ogen in deze YahtzeeWorp.
   * @return het totaal aantal ogen
   */
  public int somVanAlleOgen() {
    int som = 0;
    for (int oog : ogen) {
      som = som + oog;
    }
    return som;
  }
  
  /**
   * Berekent de score van deze YahtzeeWorp in de 
   * categorie "full house".
   * @return 25 als in deze YahtzeeWorp driemaal i en 
   *         tweemaal j ogen gegooid zijn (voor i en j 
   *         tussen 1 en 6 (inclusief)), 0 anders.
   */
  public int fullHouseScore() {
    for (int i=1; i <= 6; i++) {
      for (int j = 1; j <= 6; j++) {
        if ((i != j) && telAantal(i) == 2 
            && telAantal(j) == 3) {
          return 25;
        }
      }
    }
    return 0;
  }
  
  /**
   * Telt het aantal voorkomens van het meegegeven aantal 
   * ogen in deze YahtzeeWorp.
   * @param cijfer het meegegeven aantal ogen
   * @return het aantal keer dat cijfer voorkomt in deze 
   *         YahtzeeWorp
   */
  public int telAantal(int cijfer) {
    int aantal = 0;
    for (int oog: ogen) {
      if (oog == cijfer) {
        aantal++;
      }
    }
    return aantal;
  }
}
