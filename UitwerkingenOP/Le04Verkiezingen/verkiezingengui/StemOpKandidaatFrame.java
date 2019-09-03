package verkiezingengui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import verkiezingen.Kandidaat;
import verkiezingen.Partij;
import verkiezingen.Stemmachine;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StemOpKandidaatFrame extends JFrame {

  private Stemmachine stemmachine = new Stemmachine();
  private JPanel contentPane;
  private JLabel partijLabel;
  private JLabel kandidaatLabel;
  private JComboBox partijKeuze;
  private JComboBox kandidaatKeuze;
  private JButton stemKnop;
  private JButton uitslagKnop;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          StemOpKandidaatFrame frame = new StemOpKandidaatFrame();
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
  public StemOpKandidaatFrame() {
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
    contentPane.add(getPartijLabel());
    contentPane.add(getKandidaatLabel());
    contentPane.add(getPartijKeuze());
    contentPane.add(getKandidaatKeuze());
    contentPane.add(getStemKnop());
    contentPane.add(getUitslagKnop());
  }
  private JLabel getPartijLabel() {
    if (partijLabel == null) {
    	partijLabel = new JLabel("Kies een partij");
    	partijLabel.setBounds(12, 13, 103, 16);
    }
    return partijLabel;
  }
  private JLabel getKandidaatLabel() {
    if (kandidaatLabel == null) {
    	kandidaatLabel = new JLabel("Kies een kandidaat");
    	kandidaatLabel.setBounds(196, 13, 127, 16);
    }
    return kandidaatLabel;
  }
  private JComboBox getPartijKeuze() {
    if (partijKeuze == null) {
    	partijKeuze = new JComboBox();
    	partijKeuze.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    partijKeuzeAction();
    	  }
    	});
    	partijKeuze.setBounds(12, 54, 137, 22);
    }
    return partijKeuze;
  }
  private JComboBox getKandidaatKeuze() {
    if (kandidaatKeuze == null) {
    	kandidaatKeuze = new JComboBox();
    	kandidaatKeuze.setBounds(196, 54, 137, 22);
    }
    return kandidaatKeuze;
  }
  private JButton getStemKnop() {
    if (stemKnop == null) {
    	stemKnop = new JButton("Stem");
    	stemKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    stemKnopAction();
    	  }
    	});
    	stemKnop.setBounds(119, 131, 97, 25);
    }
    return stemKnop;
  }
  private JButton getUitslagKnop() {
    if (uitslagKnop == null) {
    	uitslagKnop = new JButton("Uitslag");
    	uitslagKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    uitslagKnopAction();
    	  }
    	});
    	uitslagKnop.setBounds(12, 215, 97, 25);
    }
    return uitslagKnop;
  }
  
  private void mijnInit() {
    stemmachine.zetAan();
    ArrayList<Partij> partijen = stemmachine.getPartijen();
    for (Partij partij : partijen) {
      partijKeuze.addItem(partij.getNaam());
    }
    partijKeuze.setSelectedIndex(-1);
    kandidaatKeuze.setSelectedIndex(-1);
  }
  
  private void partijKeuzeAction() {
    int nummer = partijKeuze.getSelectedIndex();
    if (nummer != -1) {
      kandidaatKeuze.removeAllItems();
      ArrayList<Partij> partijen = stemmachine.getPartijen();
      Partij gekozenPartij = partijen.get(nummer);
      ArrayList<Kandidaat> kandidaten = gekozenPartij.getKandidaten();
      for (Kandidaat kandidaat : kandidaten) {
        kandidaatKeuze.addItem(kandidaat.getNaam());
      }
    }
    kandidaatKeuze.setSelectedIndex(-1);
  }
  
  private void stemKnopAction() {
    int partijnr = partijKeuze.getSelectedIndex() + 1;
    int kandidaatnr = kandidaatKeuze.getSelectedIndex() + 1;
    if (partijnr != 0 && kandidaatnr != 0) {
      stemmachine.stemOpNummer(partijnr, kandidaatnr);
    }
    partijKeuze.setSelectedIndex(-1);
    kandidaatKeuze.removeAllItems();
  }
  
  private void uitslagKnopAction() {
    String uitslag = stemmachine.geefUitslagPerKandidaat();
    System.out.println(uitslag);
  }
}
