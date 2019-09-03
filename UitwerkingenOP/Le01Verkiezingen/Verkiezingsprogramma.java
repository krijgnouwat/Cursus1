import verkiezingen.Stemmachine;

/*
 * Dit programma creëert een stemmachine,
 * zet die aan, brengt enkele stemmen uit
 * en toont de uitslag per partij.
 */
public class Verkiezingsprogramma {
  public static void main(String[] args) {

    Stemmachine machine;
    String uitslag;

    machine = new Stemmachine();
    machine.zetAan();
    machine.stem("Wouter Bos");
    machine.stem("Gerda Verburg");
    machine.stem("Nebahat Albayrak");
    machine.stem("Gerda Verburg");
    machine.stem("Henk Kamp");
    uitslag = machine.geefUitslagPerPartij();
    System.out.println(uitslag); 
  }
}