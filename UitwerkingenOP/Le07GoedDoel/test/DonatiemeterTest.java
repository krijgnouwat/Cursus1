package test;

import inzamelactie.Donatiemeter;

/*
 * Testklasse voor klasse Donatiemeter
 */
public class DonatiemeterTest {

  public static void main(String[] args) {
    // Creëer Donatiemeter en vraag het streefbedrag op
    Donatiemeter dm = new Donatiemeter(500);
    System.out.println("streefbedrag " + dm.getStreefbedrag() ); 
    
    // Voeg twee giften toe, vraag het totaal op (36.90)
    // en vraag of het streefbedrag bereikt is (false)
    double d = 12.50;
    dm.voegToe(d);
    System.out.println("toegevoegd: " + d);
    d = 24.40;
    dm.voegToe(d);
    System.out.println("toegevoegd: "+ d ); 
    System.out.println("totaal bedrag: " + dm.totaalbedrag());
    System.out.println("streefbedrag bereikt: " + dm.streefbedragBereikt());

    // Voeg nog een gift toe, vraag het totaal op (536.90)
    // en vraag of het streefbedrag bereikt is (true)
    d = 500;
    dm.voegToe(d);
    System.out.println("toegevoegd: " + d ); 
    System.out.println("totaal bedrag: " + dm.totaalbedrag());
    System.out.println("streefbedrag bereikt: " + dm.streefbedragBereikt());
  }

}
