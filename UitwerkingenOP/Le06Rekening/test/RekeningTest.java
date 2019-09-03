package test;

import rekening.Rekening;

/*
 * Testklasse voor klasse Rekening.
 */
public class RekeningTest {

  public static void main(String[] args) {
    String naam = "OUNL";
    int nummer = 1111;
    double storting = 12.50;
    double opname = 7.00; 
    
    // Creëer een rekening en toon naam, nummer en saldo
    Rekening mijnRekening = new Rekening(naam, nummer);
    
    System.out.println("naam: " + mijnRekening.getNaam());
    System.out.println("nummer: " + 
                                mijnRekening.getNummer());
    System.out.println("saldo: "+ 
                                 mijnRekening.getSaldo());
    
    // Stort een bedrag en bekijk het saldo.
    mijnRekening.stort(storting);
    System.out.println("saldo na storting van " + storting
                        + ": " + mijnRekening.getSaldo());
    
    // Neem een bedrag op en bekijk het saldo
    mijnRekening.neemOp(opname);
    System.out.println("saldo na opname van " + opname
                        + ": " + mijnRekening.getSaldo());
  }
}

