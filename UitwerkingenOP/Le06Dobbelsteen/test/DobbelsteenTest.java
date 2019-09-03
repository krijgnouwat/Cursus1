package test;

import dobbelsteen.Dobbelsteen;

/*
 * Testklasse voor klasse Dobbelsteen.
 */
public class DobbelsteenTest {
  
  public static void main(String[] args) {
    Dobbelsteen steen = new Dobbelsteen();
    steen.werp();
    System.out.println("resultaat van een worp: " + 
                        steen.getOgen());
    steen.werp();
    System.out.println("resultaat van een worp: " + 
                        steen.getOgen());
    steen.werp();
    System.out.println("resultaaat van een worp: " + 
                        steen.getOgen());
  }
}
