package array;

public class Array {
  /**
   * Geeft een m bij n array terug die de getransponeerde 
   * is van een meegegeven n bij m array.
   * Voorwaarde: n en m zijn groter dan 0.
   * Voorwaarde: alle rijen van de array zijn even lang.
   * @param array de oorspronkelijke n bij m array
   * @return een m bij n array die de getransponeerde is 
   * van array
   */
  public static int[][] transponeer(int[][] array) {
    int n = array.length;
    int m = array[0].length;
    int[][] getransponeerde = new int[m][n];
    for (int rij = 0; rij < m; rij++) {
      for (int kolom = 0; kolom < n; kolom++) {
        getransponeerde[rij][kolom] = array[kolom][rij];
      }
    }
    return getransponeerde;
  }
}

