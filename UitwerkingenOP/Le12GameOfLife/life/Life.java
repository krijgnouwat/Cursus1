package life;

/*
 * Deze klasse representeert een generatie van cellen
 * op een veld. De afmeting van het veld is vastgelegd door
 * de constanten BREEDTE en HOOGTE.
 * Cellen kunnen groeien naar een volgende generatie
 * volgens de regels van Game of Life van John Conway.
 */
public class Life {
  // constanten
  public static final int BREEDTE = 40;
  public static final int HOOGTE = 25;

  // attributen

  /*
   * De constructor hoeft niets te doen en mag dus ook weggelaten worden.
   */
  public Life() {
  }

  /*
   * De cellen van het veld. Een bevolkte cel heeft de waarde true en een
   * onbevolkte cel heeft de waarde false. Omdat false de standaardwaarde is van
   * boolean, zijn alle cellen bij creatie van het veld onbevolkt.
   */
  private boolean[][] lifeCel = new boolean[HOOGTE][BREEDTE];

  /*
   * Geeft de status van de cel op rij i en kolom j. Voorwaarde: 0 <= i < HOOGTE
   * en 0 <= j < BREEDTE
   */
  public boolean isBevolkt(int i, int j) {
    return lifeCel[i][j];
  }

  /*
   * Verandert de status van een cel. Een bevolkte cel wordt onbevolkt en
   * andersom. Voorwaarde: 0 <= i < HOOGTE en 0 <= j < BREEDTE
   */
  public void wisselBevolking(int i, int j) {
    lifeCel[i][j] = !lifeCel[i][j];
  }

  /*
   * Kent aan lifecel de volgende generatie cellen toe
   */
  public void nieuweGeneratie() {
    boolean[][] nieuweCel = new boolean[HOOGTE][BREEDTE];
    for (int i = 0; i < HOOGTE; i++) {
      for (int j = 0; j < BREEDTE; j++) {
        nieuweCel[i][j] = volgendeCelWaarde(i, j);
      }
    }
    lifeCel = nieuweCel;
  }

  // private hulpmethoden

  /*
   * Bepaalt voor de cel op rij i en kolom j hoeveel buurcellen bevolkt zijn.
   */
  private int telBuren(int i, int j) {
    int buren = 0;
    int iMin = Math.max(i - 1, 0);
    int iMax = Math.min(i + 1, HOOGTE - 1);
    int jMin = Math.max(j - 1, 0);
    int jMax = Math.min(j + 1, BREEDTE - 1);
    for (int ii = iMin; ii <= iMax; ii++) {
      for (int jj = jMin; jj <= jMax; jj++) {
        // de cel zelf wordt overgeslagen
        if (!(ii == i && jj == j) && lifeCel[ii][jj]) {
          buren++;
        }
      }
    }
    return buren;
  }

  /*
   * Implementeert de regels van game of life: 1 Een bevolkte cel met geen of
   * één buur sterft uit eenzaamheid. 2 Een bevolkte cel met vier of meer buren
   * sterft door overbevolking. 3 Een bevolkte cel met twee of drie buren
   * overleeft. 4 Een onbevolkte cel met drie buren wordt bevolkt. 5 Andere
   * cellen blijven ongewijzigd.
   */
  private boolean volgendeCelWaarde(int i, int j) {
    int aantalBuren = telBuren(i, j);
    boolean bevolkt = lifeCel[i][j];
    if (bevolkt && aantalBuren < 2) {
      return false;
    }
    else if (bevolkt && aantalBuren >= 4) {
      return false;
    }
    else if (bevolkt && (aantalBuren == 2 || aantalBuren == 3)) {
      return true;
    }
    else if (!bevolkt && aantalBuren == 3) {
      return true;
    }
    else {
      return bevolkt;
    }
  }
}
