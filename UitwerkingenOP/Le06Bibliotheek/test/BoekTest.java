package test;

import bibliotheek.Boek;

/*
 * Testklasse voor klasse Boek.
 */ 
public class BoekTest {

  public static void main(String[] args) {
    Boek boek = new Boek ("Jip en Janneke", "Annie.M.G. Schmidt");
    System.out.println("titel: " + boek.getTitel());
    System.out.println("auteur: " + boek.getAuteur());
  }
}
