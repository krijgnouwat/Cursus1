import java.util.ArrayList;
import verkiezingen.Kandidaat;
import verkiezingen.Partij;
import verkiezingen.Stemmachine;

/*
 * Dit programma brengt een aantal stemmen uit (waarbij
 * er vaker gestemd wordt op een grotere partijen en 
 * vaker op een kandidaten hoger op de lijst),  
 * bepaalt welke kandidaat de meest stemmen heeft
 * gekregen en toont daarvan de gegevens.
 */
public class Winnaarprogramma {
  public static void main(String[] args) {
    // Maak een stemmachine, zet die aan en breng 
    // stemmen uit
    Stemmachine machine = new Stemmachine();
    machine.zetAan();
    machine.stemNKeer(1000, 20);
    
    // Declareer variabelen voor de winnaar en voor diens
    // partij 
    int maxAantalStemmen = 0;
    Kandidaat winnaar = null;
    Partij partijVanWinnaar = null;

    // Loop door alle kandidaten van alle partijen, en zoek
    // de winnaar
    ArrayList<Partij> partijen = machine.getPartijen();
    for (Partij p: partijen) {
      ArrayList<Kandidaat> kandidaten = p.getKandidaten();
      for (Kandidaat k: kandidaten){
        int aantalStemmen = k.getAantalStemmen();
        if (aantalStemmen > maxAantalStemmen) {
          maxAantalStemmen = aantalStemmen;
          winnaar = k;
          partijVanWinnaar = p;
        }
      }
    }

    if (winnaar == null) {
      System.out.println(
         "Er zijn geen stemmen uitgebracht");
    } 
    else { 
      System.out.println(
        "De meeste stemmen kreeg " + winnaar.getNaam() +
        " (" + partijVanWinnaar.getNaam() + "): " + 
        maxAantalStemmen);
    }
  }
	
}
