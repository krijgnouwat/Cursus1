import tegels.Tegel;

/*
 * Dit programma tekent vier tegels op standaard uitvoer
 */
public class Tegelprogramma {
  public static void main(String[] args) {

    // type na deze regel de opdrachten in

    Tegel tegel1;
    Tegel tegel2;

    tegel1 = new Tegel(11, "88", "..");
    tegel2 = new Tegel(11, "^^", "##");
    tegel1.toonErnaast(tegel2);
    tegel2.toonErnaast(tegel1);
    
    // Voor vier gelijke tegels moeten de volgende
    // opdrachten gebruikt worden:
    /* 
    Tegel tegel;
    tegel = new Tegel(11, "00", "..");
    tegel.toonErnaast(tegel);
    tegel.toonErnaast(tegel);
     */
  }
}