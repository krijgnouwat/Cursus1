import tegels.Tegel;

public class Tegelprogramma {
  public static void main(String[] args) {

    Tegel tegel1 = new Tegel (10, "*", "O");
    tegel1.toon();
    tegel1.toonErnaast(tegel1);
    tegel1.toonErnaast(tegel1);
    
  }
}