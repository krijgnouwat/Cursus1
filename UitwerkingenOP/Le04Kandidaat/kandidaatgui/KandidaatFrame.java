package kandidaatgui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
import verkiezingen.Stemmachine;
import verkiezingen.Partij;
import verkiezingen.Kandidaat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * GUI-klasse voor het opzoeken van kandidaten in
 * de stemmachine. De gebruiker typt de naam van een
 * kanidaat in; als deze in de stemmachine voorkomt, 
 * worden woonplats en partij getoond. Anders
 * wordt niets getoond.
 */
public class KandidaatFrame extends JFrame {

  private Stemmachine stemmachine = new Stemmachine();
  private JPanel contentPane;
  private JLabel kandidaatLabel;
  private JTextField kandidaatVeld;
  private JLabel woonplaatsLabel;
  private JLabel partijLabel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          KandidaatFrame frame = new KandidaatFrame();
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
  public KandidaatFrame() {
    initialize();
    mijnInit();
  }
  private void initialize() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getKandidaatLabel());
    contentPane.add(getKandidaatVeld());
    contentPane.add(getWoonplaatsLabel());
    contentPane.add(getPartijLabel());
  }
  private JLabel getKandidaatLabel() {
    if (kandidaatLabel == null) {
    	kandidaatLabel = new JLabel("Type de naam van een kandidaat in");
    	kandidaatLabel.setBounds(12, 13, 266, 16);
    }
    return kandidaatLabel;
  }
  private JTextField getKandidaatVeld() {
    if (kandidaatVeld == null) {
    	kandidaatVeld = new JTextField();
    	kandidaatVeld.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    kandidaatVeldAction();
    	  }
    	});
    	kandidaatVeld.setBounds(12, 53, 266, 22);
    	kandidaatVeld.setColumns(10);
    }
    return kandidaatVeld;
  }
  private JLabel getWoonplaatsLabel() {
    if (woonplaatsLabel == null) {
    	woonplaatsLabel = new JLabel("");
    	woonplaatsLabel.setBounds(12, 103, 266, 16);
    }
    return woonplaatsLabel;
  }
  private JLabel getPartijLabel() {
    if (partijLabel == null) {
    	partijLabel = new JLabel("");
    	partijLabel.setBounds(12, 140, 266, 16);
    }
    return partijLabel;
  }
  
  private void mijnInit() {
    stemmachine.zetAan();
  }
  
  private void kandidaatVeldAction() {
    woonplaatsLabel.setText("");
    partijLabel.setText("");
    String naam = kandidaatVeld.getText();
    ArrayList<Partij> partijen = stemmachine.getPartijen();
    for (Partij partij : partijen) {
      Kandidaat kandidaat = partij.zoek(naam);
      if (kandidaat != null) {
        woonplaatsLabel.setText(kandidaat.getWoonplaats());
        partijLabel.setText(partij.getNaam());
      }
    }
  }
}
