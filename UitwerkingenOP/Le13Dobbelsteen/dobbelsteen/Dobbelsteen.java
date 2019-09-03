package dobbelsteen;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Klasse die verantwoordelijk is voor het genereren en 
 * toegankelijk maken van een willekeurig getal tussen 
 * 1 en 6
 */
public class Dobbelsteen {
  private int ogen = 0;
  
  /*
   * Maakt een nieuwe Dobbelsteen-instantie en genereert en 
   * bewaart een waarde tussen 1 en 6 
   */
  public Dobbelsteen(){
    this.werp();
  }
  
  public int getOgen(){
    return ogen;
  }
  
  /*
   * Genereert en bewaart een waarde tussen 1 en 6.
   */
  public void werp(){
    Random r= new Random();
    ogen = r.nextInt(6) + 1;
  }
  
  @Test
  public void testWerp() {
    Dobbelsteen steen = new Dobbelsteen();
    int[] aantalGegooid = {-1, 0, 0, 0, 0, 0, 0};  
        //aantalGegooid[0] niet gebruiken
    int ogen;
    int aantalKeer = 1000;
      
    //aantalKeer keer gooien
    for (int i = 1; i <= aantalKeer; i++) {
      steen.werp();
      ogen = steen.getOgen();
      
      //aantal ogen moet steeds tussen 1 en 6 liggen
      assertTrue(ogen >= 1);
      assertTrue(ogen <= 6);
       
      //houd bij hoe vaak ieder aantal ogen gegooid wordt
      aantalGegooid[ogen]++;
    }
      
    //druk overzicht gegooide aantallen ogen af
    System.out.println("Van de " + aantalKeer + 
                       " keer gooien");
    for (int i = 1; i <= 6; i++) {
      System.out.println("aantal keer " + i + " gegooid: " + 
                         aantalGegooid[i]);
    }
  }
}
