import java.util.ArrayList;
import verkiezingen.Stemmachine;
import verkiezingen.Partij;
import verkiezingen.Kandidaat;

/*
 * Dit programma toont alle kandidaten op
 * alle lijsten in een stemmachine
 */
public class Herhalingsprogramma {
  public static void main(String[] args) {
    Stemmachine machine = new Stemmachine();
    machine.zetAan();
    ArrayList<Partij> partijlijst = machine.getPartijen();
    for (Partij p: partijlijst){
      System.out.println(p.getNaam());
      ArrayList<Kandidaat> kandidaatlijst = p.getKandidaten();
      int nummer = 1;
      for (Kandidaat k: kandidaatlijst){
        System.out.println(
            "  " + nummer + ". " + k.getNaam() 
            + " uit " + k.getWoonplaats()
        );        
        nummer = nummer + 1;
      }
      System.out.println();
    }
  }
}