import java.util.ArrayList;
import verkiezingen.Stemmachine;
import verkiezingen.Partij;
import verkiezingen.Kandidaat;

/*
 * Dit programma toont de gegevens (naam, woonplaats,
 * aantal stemmen) van de laatste kandidaat op de
 * laatste lijst.
 */
public class LijstProgramma {
  public static void main(String[] args) {	        
    Stemmachine machine = new Stemmachine();
    machine.zetAan();
    ArrayList<Partij> partijlijst = machine.getPartijen();
    int aantalPartijen = partijlijst.size();
    Partij laatstePartij = partijlijst.get(aantalPartijen - 1);  
    ArrayList<Kandidaat> kandidaatlijst = laatstePartij.getKandidaten();
    int aantalKandidaten = kandidaatlijst.size();
    Kandidaat laatsteKandidaat = kandidaatlijst.get(aantalKandidaten - 1);
    System.out.println("De laatste kandidaat van de laatste lijst heet "
        + laatsteKandidaat.getNaam()
        + ", woont in "
        + laatsteKandidaat.getWoonplaats()
        + " en heeft "
        + laatsteKandidaat.getAantalStemmen()
        + " stemmen gekregen");

  }
}
