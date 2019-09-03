package bibliotheek;

import java.util.ArrayList;

/*
 * Klasse die verantwoordelijk is voor het beheer van boeken.
 */ 
public class Bibliotheek {
  // de lijst met boeken
  private ArrayList<Boek> boekenlijst = new ArrayList<>();

  /*
   * Voegt een boek met gegeven titel en auteur toe aan 
   * deze bibliotheek.
   */
  public void voegBoekToe(String titel, String auteur) {
    Boek boek = new Boek(titel, auteur);
    boekenlijst.add(boek);
  }

  /*
   * Geeft de titels in deze bibliotheek.
   */
  public ArrayList<String> geefTitels() {
    ArrayList<String> titels = new ArrayList<>();
    for (Boek boek : boekenlijst) {
      String titel = boek.getTitel();
      titels.add(titel);
    }
    return titels;
  }
  
  /*
   * Geeft de auteur bij een gegeven titel.
   */
  public String geefAuteur(String titel){
    String res = "titel niet gevonden";
    for (Boek boek : boekenlijst) {
      if (boek.getTitel().equals(titel)){
	// boek met gevraagde titel gevonden
	res = boek.getAuteur();
      }     
    }
    return res;
  }
}
