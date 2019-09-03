package inzamelactiegui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inzamelactie.Donatiemeter;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonatiemeterFrame extends JFrame {

  // attributen voor de donatiemeter en decimal format
  private Donatiemeter dm = new Donatiemeter(500);
  private DecimalFormat df = new DecimalFormat("##.00");
  
  private JPanel contentPane;
  private JTextField bedragVeld;
  private JButton schenkKnop;
  private JLabel totaalLabel;
  private JTextField totaalVeld;
  private JProgressBar giftenProgressBar;
  private JLabel infoLabel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DonatiemeterFrame frame = new DonatiemeterFrame();
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
  public DonatiemeterFrame() {
    initialize();
    mijnInit();
  }
  private void initialize() {
    setTitle("Inzamelactie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 366, 236);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getBedragVeld());
    contentPane.add(getSchenkKnop());
    contentPane.add(getTotaalLabel());
    contentPane.add(getTotaalVeld());
    contentPane.add(getGiftenProgressBar());
    contentPane.add(getInfoLabel());
  }

  private JTextField getBedragVeld() {
    if (bedragVeld == null) {
    	bedragVeld = new JTextField();
    	bedragVeld.setBounds(20, 15, 75, 24);
    	bedragVeld.setColumns(10);
    }
    return bedragVeld;
  }
  private JButton getSchenkKnop() {
    if (schenkKnop == null) {
    	schenkKnop = new JButton("schenk!");
    	schenkKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    schenkKnopAction();
    	  }
    	});
    	schenkKnop.setBounds(110, 15, 100, 24);
    }
    return schenkKnop;
  }
  private JLabel getTotaalLabel() {
    if (totaalLabel == null) {
    	totaalLabel = new JLabel("Totaal aan giften:");
    	totaalLabel.setBounds(20, 50, 100, 24);
    }
    return totaalLabel;
  }
  private JTextField getTotaalVeld() {
    if (totaalVeld == null) {
    	totaalVeld = new JTextField();
    	totaalVeld.setBounds(140, 50, 75, 24);
    	totaalVeld.setColumns(10);
    }
    return totaalVeld;
  }
  private JProgressBar getGiftenProgressBar() {
    if (giftenProgressBar == null) {
    	giftenProgressBar = new JProgressBar();
    	giftenProgressBar.setBounds(20, 80, 320, 40);
    }
    return giftenProgressBar;
  }
  private JLabel getInfoLabel() {
    if (infoLabel == null) {
    	infoLabel = new JLabel("");
    	infoLabel.setBounds(20, 150, 320, 24);
    }
    return infoLabel;
  }
  
  private void mijnInit() {
    giftenProgressBar.setStringPainted(true);
    giftenProgressBar.setMaximum((int)dm.getStreefbedrag());
    giftenProgressBar.setMinimum(0); //eigenlijk overbodig, standaardwaarde
    controleerStreefbedrag();
  }
  
  private void schenkKnopAction() {
    double bedrag = Double.parseDouble(bedragVeld.getText());
    dm.voegToe(bedrag);
    double totaal = dm.totaalbedrag();
    totaalVeld.setText("" + df.format(totaal));
    giftenProgressBar.setValue((int)totaal);
    controleerStreefbedrag();   
    bedragVeld.setText("");
  }
  
  private void controleerStreefbedrag() {
    String res = "";
    if (!dm.streefbedragBereikt()) { 
      res = "nog niet ";
    }  
    infoLabel.setText("Het streefbedrag van "+ df.format(dm.getStreefbedrag()) + 
                      " euro is " + res + "bereikt." );
  }
  
}
