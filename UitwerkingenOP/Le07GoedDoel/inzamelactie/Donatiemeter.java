package inzamelactie;

import java.util.ArrayList;

/*
 * Klasse Donatiemeter registreert giften en gaat na
 * of een streefbedrag is bereikt.
 */
public class Donatiemeter {
  
  // giften worden afzonderlijk bijghouden in een lijst
  private ArrayList<Double> giften = new ArrayList<>();
  
  // het streefbedrag
  private double streefbedrag = 0; 
  
  /*
   * De constructor geeft het streefbedrag een
   * nieuwe waarde.
   */
  public Donatiemeter(double streefbedrag) {
    this.streefbedrag = streefbedrag;
  }
  
  public double getStreefbedrag() {
    return streefbedrag;
  }
  
  /*
   * Voegt een gegeven bedrag toe als donatie.
   */
  public void voegToe(double bedrag){
    giften.add(bedrag);
  }

  /*
   * Berekent het totaal aan giften.
   */
  public double totaalbedrag(){
    double totaal = 0;
    for (double d: giften){
      totaal = totaal + d;
    }
    return totaal;
  }
  /*
   * Gaat na of het streefbedrag is bereikt.
   */
  public boolean streefbedragBereikt(){
    return totaalbedrag() >= streefbedrag; 
  }
}
