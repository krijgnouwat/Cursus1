package test;

import java.util.ArrayList;
import bibliotheek.Bibliotheek;

/*
 * Testklasse voor Bibliotheek.
 */
public class BibliotheekTest {

  public static void main(String[] args) {
    Bibliotheek bieb = new Bibliotheek();
    
    // voeg drie boeken toe
    bieb.voegBoekToe("Jip en Janneke",
                     "Annie M.G.Schmidt"); 
    bieb.voegBoekToe("De onzichtbare indiaan",
                     "Janosch"); 
    bieb.voegBoekToe("Alleen op de wereld",
                     "Hector Malot");
    
    // test geefTitels
    ArrayList<String> titels = bieb.geefTitels();
    System.out.println("titels: "+ titels);
    
    // test geefAuteur
    System.out.println("auteur van Jip en Janneke: "
              + bieb.geefAuteur("Jip en Janneke") );
    System.out.println("auteur van Janneke en Jip: "
              + bieb.geefAuteur("Janneke en Jip: ") );
  }
}
