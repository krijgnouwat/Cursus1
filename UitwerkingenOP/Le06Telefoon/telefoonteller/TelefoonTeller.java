package telefoonteller;

/*
 * Klasse die verantwoordelijk is voor het bijhouden 
 * van gebelde minuten en de kosten hiervan. 
 */ 
public class TelefoonTeller {
  
  private int gebeldeMinuten = 0;
  private double totaleKosten = 0;
  private static double basistarief = 0.40;
  private static double perMinuut = 0.25;
  
  // Constructor niet nodig; de standaardconstructor 
  // volstaat
  
  public int getGebeldeMinuten() {
    return gebeldeMinuten;
  }
  
  public double getTotaleKosten() {
    return totaleKosten;
  }
  
  /* 
   * Registreert het voeren van een gesprek van het gegeven aantal 
   * minuten en geeft de kosten van dit geprek terug. 
   */
  public double bel(int minuten){
    double  kosten = basistarief + minuten * perMinuut;
    totaleKosten = totaleKosten + kosten;    
    gebeldeMinuten = gebeldeMinuten + minuten;
    return kosten;    
  }
}
