package bibliotheek;

/*
 * Klasse die gegevens van een boek beheert.
 */ 
public class Boek {
  private String titel = null;
  private String auteur = null;
  
  /*
   * Creeert een nieuw boek met gegeven titel en auteur.
   */  
  public Boek(String titel, String auteur){
    this.titel = titel;
    this.auteur = auteur;
  }

  public String getAuteur() {
    return auteur;
  }

  public String getTitel() {
    return titel;
  }
}
