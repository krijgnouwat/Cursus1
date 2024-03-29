package bibliotheekgui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import bibliotheek.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Deze klasse representeert een gui voor het beheren
 * van een verzameling boeken. 
 * @author Medewerker OUNL
 *
 */
public class BibliotheekFrame extends JFrame {
  // eigen attribuut
  private Bibliotheek bieb = new Bibliotheek();
  
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JLabel titelLabel;
  private JLabel auteurLabel;
  private JTextField titelVeld;
  private JTextField auteurVeld;
  private JButton voegToeKnop;
  private JButton toonAuteurKnop;
  private JButton toonTitelsKnop;
  private JTextArea titelsGebied;
  private JScrollPane scrollVlak;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          BibliotheekFrame frame = new BibliotheekFrame();
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
  public BibliotheekFrame() {
    initialize();
  }
  private void initialize() {
    setTitle("Mijn bibliotheek");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 369);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getTitelLabel());
    contentPane.add(getAuteurLabel());
    contentPane.add(getTitelVeld());
    contentPane.add(getAuteurVeld());
    contentPane.add(getVoegToeKnop());
    contentPane.add(getToonAuteurKnop());
    contentPane.add(getToonTitelsKnop());
    contentPane.add(getScrollVlak());
  }

  private JLabel getTitelLabel() {
    if (titelLabel == null) {
    	titelLabel = new JLabel("titel");
    	titelLabel.setBounds(13, 11, 74, 15);
    }
    return titelLabel;
  }
  private JLabel getAuteurLabel() {
    if (auteurLabel == null) {
    	auteurLabel = new JLabel("auteur");
    	auteurLabel.setBounds(13, 37, 85, 20);
    }
    return auteurLabel;
  }
  private JTextField getTitelVeld() {
    if (titelVeld == null) {
    	titelVeld = new JTextField();
    	titelVeld.setBounds(119, 6, 242, 25);
    	titelVeld.setColumns(10);
    }
    return titelVeld;
  }
  private JTextField getAuteurVeld() {
    if (auteurVeld == null) {
    	auteurVeld = new JTextField();
    	auteurVeld.setBounds(119, 35, 242, 25);
    	auteurVeld.setColumns(10);
    }
    return auteurVeld;
  }
  private JButton getVoegToeKnop() {
    if (voegToeKnop == null) {
    	voegToeKnop = new JButton("voeg boek toe");
    	voegToeKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    voegToeKnopAction();
    	  }
    	});
    	voegToeKnop.setBounds(13, 80, 113, 25);
    }
    return voegToeKnop;
  }

  private JButton getToonAuteurKnop() {
    if (toonAuteurKnop == null) {
    	toonAuteurKnop = new JButton("toon auteur");
    	toonAuteurKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    toonAuteurKnopAction();
    	  }
    	});
    	toonAuteurKnop.setBounds(130, 80, 113, 25);
    }
    return toonAuteurKnop;
  }
  private JButton getToonTitelsKnop() {
    if (toonTitelsKnop == null) {
    	toonTitelsKnop = new JButton("toon titels");
    	toonTitelsKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    toonTitelsKnopAction();
    	  }
    	});
    	toonTitelsKnop.setBounds(248, 80, 113, 25);
    }
    return toonTitelsKnop;
  }
  private JTextArea getTitelsGebied() {
    if (titelsGebied == null) {
    	titelsGebied = new JTextArea();
    }
    return titelsGebied;
  }
  private JScrollPane getScrollVlak() {
    if (scrollVlak == null) {
    	scrollVlak = new JScrollPane();
    	scrollVlak.setBounds(13, 116, 272, 170);
    	scrollVlak.setViewportView(getTitelsGebied());
    }
    return scrollVlak;
  }
  
  /*
   * Event handler voor toonTitelsKnop.
   * Toont de titels van alle boeken in de bibliotheek.
   */
  private void toonTitelsKnopAction() {
    titelsGebied.setText("");
    titelsGebied.append("titels: \n");
    ArrayList<String> titels = bieb.geefTitels();
    for (String titel : titels) {
      titelsGebied.append(titel+"\n");
    }   
  }

  /*
   * Event handler voor voegToeKnop.
   * Vraagt de bibliotheek een boek toe te voegen met de 
   * ingevoerde titel en auteur.
   */
  private void voegToeKnopAction() {
    bieb.voegBoekToe(titelVeld.getText(), auteurVeld.getText());
    titelVeld.setText("");
    auteurVeld.setText("");
  }
  
  /*
   * Event handler voor toonAuteurKnop.
   * Vraagt bij de bibliotheek de auteur op van 
   * een gegevn titel en toont deze.
   */
  private void toonAuteurKnopAction() {
    String titel = titelVeld.getText();
    String auteur = bieb.geefAuteur(titel);
    auteurVeld.setText(auteur);    
  }
}
