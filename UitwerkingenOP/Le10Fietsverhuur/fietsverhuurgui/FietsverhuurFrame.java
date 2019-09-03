package fietsverhuurgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fietsverhuur.Huurprijscalculator;
import fietsverhuur.Huurprijscalculator.Fietssoort;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

/*
 * GUI voor de klasse Huurprijscalculator.
 * Merk op, dat er geen aparte private methoden zijn voor event handling;
 * er is alleen de private methode toonHuurprijs() die direct wordt 
 * aangeroepen. Dit wijkt af van de eerder gezette standaard. 
 * Bij het volgen van de standaardaanpak (wat natuurlijk ook goed is),
 * krijgen we zes event handlers die niets anders doen dan toonHuurprijs()
 * aanroepen:
 * 
 * private void stadsfietsRadioKnopAction(){
 *   toonHuurprijs();
 * }
 * 
 * private void weekendCheckBoxAction() {
 *   toonHuurprijs();
 * }
 * 
 * private void urenVeldAction() {
 *   toonHuurprijs();
 * }
 * 
 * enzovoort.
 * 
 * In deze implementatie hebben we er voor gekozen toonHuurprijs() steeds 
 * direct vanuit de gegenereerde code aan te roepen, wat efficiënter is.
 */
public class FietsverhuurFrame extends JFrame {

  // eigen attributen
  private ButtonGroup soortgroep = new ButtonGroup();  
  private DecimalFormat bedragFormaat = new DecimalFormat("##.00");
  
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JRadioButton stadsfietsRadioKnop;
  private JRadioButton versnellingsfietsRadioKnop;
  private JRadioButton kinderfietsRadioKnop;
  private JCheckBox verzekeringCheckBox;
  private JCheckBox weekendCheckBox;
  private JTextField urenVeld;
  private JLabel urenLabel;
  private JLabel huurprijsLabel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          FietsverhuurFrame frame = new FietsverhuurFrame();
          frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public FietsverhuurFrame() {
    initialize();
    mijnInit();
  }
  private void initialize() {
    setTitle("Huurprijscalculator voor fiets");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 400, 240);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getStadsfietsRadioKnop());
    contentPane.add(getVersnellingsfietsRadioKnop());
    contentPane.add(getKinderfietsRadioKnop());
    contentPane.add(getVerzekeringCheckBox());
    contentPane.add(getWeekendCheckBox());
    contentPane.add(getUrenVeld());
    contentPane.add(getUrenLabel());
    contentPane.add(getHuurprijsLabel());
  }

  private JRadioButton getStadsfietsRadioKnop() {
    if (stadsfietsRadioKnop == null) {
    	stadsfietsRadioKnop = new JRadioButton("Stadsfiets");
    	stadsfietsRadioKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    toonHuurprijs();
    	  }
    	});
    	stadsfietsRadioKnop.setBounds(12, 15, 180, 25);
    }
    return stadsfietsRadioKnop;
  }
  private JRadioButton getVersnellingsfietsRadioKnop() {
    if (versnellingsfietsRadioKnop == null) {
    	versnellingsfietsRadioKnop = new JRadioButton("Fiets met versnellingen");
    	versnellingsfietsRadioKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    toonHuurprijs();
    	  }
    	});
    	versnellingsfietsRadioKnop.setBounds(12, 45, 180, 25);
    }
    return versnellingsfietsRadioKnop;
  }
  private JRadioButton getKinderfietsRadioKnop() {
    if (kinderfietsRadioKnop == null) {
    	kinderfietsRadioKnop = new JRadioButton("Kinderfiets");
    	kinderfietsRadioKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    toonHuurprijs();
    	  }
    	});
    	kinderfietsRadioKnop.setBounds(12, 75, 180, 25);
    }
    return kinderfietsRadioKnop;
  }
  private JCheckBox getVerzekeringCheckBox() {
    if (verzekeringCheckBox == null) {
    	verzekeringCheckBox = new JCheckBox("Verzekering");
    	verzekeringCheckBox.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    toonHuurprijs();
    	  }
    	});
    	verzekeringCheckBox.setBounds(210, 15, 100, 25);
    }
    return verzekeringCheckBox;
  }
  private JCheckBox getWeekendCheckBox() {
    if (weekendCheckBox == null) {
    	weekendCheckBox = new JCheckBox("Weekend");
    	weekendCheckBox.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    toonHuurprijs();
    	  }
    	});
    	weekendCheckBox.setBounds(210, 45, 100, 25);
    }
    return weekendCheckBox;
  }
  private JTextField getUrenVeld() {
    if (urenVeld == null) {
    	urenVeld = new JTextField();
    	urenVeld.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    toonHuurprijs();
    	  }
    	});
    	urenVeld.setBounds(210, 75, 40, 25);
    	urenVeld.setColumns(10);
    }
    return urenVeld;
  }
  private JLabel getUrenLabel() {
    if (urenLabel == null) {
    	urenLabel = new JLabel("Aantal uur");
    	urenLabel.setBounds(300, 75, 80, 25);
    }
    return urenLabel;
  }
  private JLabel getHuurprijsLabel() {
    if (huurprijsLabel == null) {
    	huurprijsLabel = new JLabel("Huurprijs: 0,00");
    	huurprijsLabel.setBounds(100, 120, 120, 25);
    }
    return huurprijsLabel;
  }
  
  private void mijnInit() {
    soortgroep.add(stadsfietsRadioKnop);
    soortgroep.add(versnellingsfietsRadioKnop);
    soortgroep.add(kinderfietsRadioKnop);
  }
  
  /*
   * Toon de huurprijs, als tenminste het soort fiets en het aantal
   * uren is ingevuld. Is dat niet het geval, keer dan terug zonder
   * iets te doen. De methode controleert of het ingevulde aantal uren
   * positief is, maar geeft geen foutmelding.
   */
  private void toonHuurprijs() {
    // lees soort
    Fietssoort soort;
    if (stadsfietsRadioKnop.isSelected()) {
      soort = Fietssoort.STADSFIETS;
    }
    else if (versnellingsfietsRadioKnop.isSelected()) {
      soort = Fietssoort.VERSNELLINGSFIETS;
    }
    else if (kinderfietsRadioKnop.isSelected()) {
      soort = Fietssoort.KINDERFIETS;
    }
    else // soort is nog niet gekozen
      return;
    
    // lees uren
    int uren;
    if (urenVeld.getText().equals("")) {
      // Uren zijn nog niet ingevuld
      return;   
    } 
    uren = Integer.parseInt(urenVeld.getText());  
    if (uren < 0 || uren > 16) {
      // aantal uren is onjuist
      huurprijsLabel.setText("Onjuist aantal uren");
      return;
    }
    
    // lees weekend en verzekering
    boolean verzekering = verzekeringCheckBox.isSelected();
    boolean weekend = weekendCheckBox.isSelected();

    // Als we zover zijn, kan er een huurprijs berekend worden.
    double huurprijs = Huurprijscalculator.bepaalHuurprijs(soort, uren, weekend, verzekering);
    huurprijsLabel.setText("Huurprijs: " + bedragFormaat.format(huurprijs));
  }
}
