package test;

import static org.junit.Assert.*;

import org.junit.Test;

import yahtzee.YahtzeeWorp;

public class YahtzeeWorpTest {
  
  @Test
  public void testYahtzeeWorp() {
    // hier zouden we kunnen testen dat verkeerde 
    // aantallen dobbelstenen of ogen op een acceptabele 
    // manier worden afgehandeld. Voorlopig vertrouwen we
    // deze methode
  }

  @Test
  public void testGetScores() {
    //we kijken naar de categorieen "3 dezelfde", 
    //"carré" en "full house"
    
    //scoort in de eerste twee categorieën maar niet 
    //in de derde
    int[] gegooid1 = {3,3,3,3,3};
    YahtzeeWorp worp = new YahtzeeWorp(gegooid1);
    int[] uitkomst1 = {15, 15, 0};
    for (int i = 0; i < 3; i++) {
      assertEquals(uitkomst1[i], worp.getScores()[i]);
    }
  }
  
  @Test
  public void testNDezelfdeScore() {
    //5 dezelfde
    int[] gegooid1 = {4,4,4,4,4}; 
    YahtzeeWorp worp = new YahtzeeWorp(gegooid1);
    assertEquals(20, worp.nDezelfdeScore(5));
    assertEquals(20, worp.nDezelfdeScore(4));
    assertEquals(20, worp.nDezelfdeScore(3));
    assertEquals(20, worp.nDezelfdeScore(2));
    assertEquals(20, worp.nDezelfdeScore(1));
    //(de laatste twee zijn niet zinvol voor Yahtzee)
    
    //4 dezelfde
    int[] gegooid2 = {4,4,4,1,4}; 
    worp = new YahtzeeWorp(gegooid2);
    assertEquals(0, worp.nDezelfdeScore(5));
    assertEquals(17, worp.nDezelfdeScore(4));
    assertEquals(17, worp.nDezelfdeScore(3));
    
    //3 dezelfde
    int[] gegooid3 = {2,4,4,1,4}; 
    worp = new YahtzeeWorp(gegooid3);
    assertEquals(0, worp.nDezelfdeScore(5));
    assertEquals(0, worp.nDezelfdeScore(4));
    assertEquals(15, worp.nDezelfdeScore(3));
    
    //geen 3 dezelfde
    int[] gegooid4 = {1,4,5,1,4}; 
    worp = new YahtzeeWorp(gegooid4);
    assertEquals(0, worp.nDezelfdeScore(5));
    assertEquals(0, worp.nDezelfdeScore(4));
    assertEquals(0, worp.nDezelfdeScore(3));
    assertEquals(15, worp.nDezelfdeScore(2));
    //(de laatste is niet zinvol voor Yahtzee)
  }

  @Test
  public void testSomVanAlleOgen() {
    //de kleinste
    int[] gegooid1 = {1,1,1,1,1};
    YahtzeeWorp worp = new YahtzeeWorp(gegooid1);
    assertEquals(5, worp.somVanAlleOgen());
    
    //de grootste
    int[] gegooid2 = {6,6,6,6,6};
    worp = new YahtzeeWorp(gegooid2);
    assertEquals(30, worp.somVanAlleOgen());
    
    //iets er tussen in
    int[] gegooid3 = {4,2,6,5,1};
    worp = new YahtzeeWorp(gegooid3);
    assertEquals(18, worp.somVanAlleOgen());
  }
  
  @Test
  public void testFullHouseScore() {
    //allemaal verschillend
    int[] gegooid1 = {1,2,3,4,5};
    YahtzeeWorp worp = new YahtzeeWorp(gegooid1);
    assertEquals(0, worp.fullHouseScore());
    
    //alleen 2 dezelfde
    int[] gegooid2 = {3,6,2,4,3};
    worp = new YahtzeeWorp(gegooid2);
    assertEquals(0, worp.fullHouseScore());
    
    //alleen 3 dezelfde
    int[] gegooid3 = {5,2,5,5,6};
    worp = new YahtzeeWorp(gegooid3);
    assertEquals(0, worp.fullHouseScore());
    
    //alleen 4 dezelfde
    int[] gegooid4 = {5,2,5,5,5};
    worp = new YahtzeeWorp(gegooid4);
    assertEquals(0, worp.fullHouseScore());
    
    //5 dezelfde
    int[] gegooid5 = {5,5,5,5,5};
    worp = new YahtzeeWorp(gegooid5);
    assertEquals(0, worp.fullHouseScore());
    
    //echte Full House
    int[] gegooid6 = {5,2,2,5,5};
    worp = new YahtzeeWorp(gegooid6);
    assertEquals(25, worp.fullHouseScore());    
  }

  @Test
  public void testTelAantal() {
    
    int[] gegooid1 = {3,3,3,3,3};
    YahtzeeWorp worp = new YahtzeeWorp(gegooid1);
    for (int i = 1; i <=6 && i != 3; i++) {
      assertEquals(0, worp.telAantal(i));
    }
    assertEquals(5, worp.telAantal(3));
    
    int[] gegooid2 = {2,4,1,6,1};
    worp = new YahtzeeWorp(gegooid2);
    assertEquals(2, worp.telAantal(1));
    assertEquals(1, worp.telAantal(2));
    assertEquals(0, worp.telAantal(3));
    assertEquals(1, worp.telAantal(4));
    assertEquals(0, worp.telAantal(5));
    assertEquals(1, worp.telAantal(6));
  }
}

