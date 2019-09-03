package test;

import telefoonteller.TelefoonTeller;

public class TelefoonTellerTest {

  /*
   * Testklasse voor klasse TelefoonTeller.
   */
  public static void main(String[] args) {
    TelefoonTeller teller = new TelefoonTeller();
    
    // Bel achtereenvolgens 1, 2 en 10 minuten en 
    // toon elke keer de kosten van het gesprek, het
    // aantal gebelde minuten en de totale kosten.
    
    double kostenGesprek = teller.bel(1); 
    System.out.println("Kosten gesprek: " + kostenGesprek);
    System.out.println("Gebelde minuten: " + teller.getGebeldeMinuten());
    System.out.println("Totale kosten: " + teller.getTotaleKosten());
    System.out.println();

    kostenGesprek = teller.bel(2); 
    System.out.println("Kosten gesprek: " + kostenGesprek);
    System.out.println("Gebelde minuten: " + teller.getGebeldeMinuten());
    System.out.println("Totale kosten: " + teller.getTotaleKosten());
    System.out.println();
    
    kostenGesprek = teller.bel(10); 
    System.out.println("Kosten gesprek: " + kostenGesprek);
    System.out.println("Gebelde minuten: " + teller.getGebeldeMinuten());
    System.out.println("Totale kosten: " + teller.getTotaleKosten());
    System.out.println();
  }
}
