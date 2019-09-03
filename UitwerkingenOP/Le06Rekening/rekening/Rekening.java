package rekening;

/* 
 * Klasse die verantwoordelijk is voor het beheer van het 
 * saldo van een bankrekening.
 */
public class Rekening {
  private static final double INLEGKADO = 5.00;
  private String naam = null;
  private int nummer = 0;
  private double saldo = INLEGKADO;
  
  /*
   * Maakt een nieuwe Rekening aan met gegeven naam en 
   * gegeven nummer.
   */
  public Rekening(String naam, int nummer){
    this.naam = naam;
    this.nummer = nummer;
  }

  public String getNaam(){
    return naam;
  }

  public int getNummer(){
    return nummer;
  }

  public double getSaldo(){
    return saldo;
  }

  /*
   * Verhoogt het saldo van deze Rekening met een gegeven
   * bedrag.
   */
  public void stort(double bedrag){
    saldo = saldo + bedrag;
  }

  /*
   * Verlaagt het saldo van deze Rekening met een gegeven 
   * bedrag.
   */
  public void neemOp(double bedrag){
    saldo = saldo - bedrag;
  }
}


