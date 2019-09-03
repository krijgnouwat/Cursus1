package telefoontellergui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import telefoonteller.TelefoonTeller;

public class TelefoonFrame extends JFrame {

  private TelefoonTeller telefoonteller = new TelefoonTeller();
  
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JLabel duurLabel;
  private JLabel gesprekskostenLabel;
  private JLabel totalekostenLabel;
  private JLabel gebeldeminutenLabel;
  private JTextField duurVeld;
  private JTextField gesprekskostenVeld;
  private JTextField totalekostenVeld;
  private JTextField gebeldeminutenVeld;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TelefoonFrame frame = new TelefoonFrame();
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
  public TelefoonFrame() {
    initialize();
  }
  private void initialize() {
    setTitle("Bel simulatie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 320, 320);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getDuurLabel());
    contentPane.add(getGesprekskostenLabel());
    contentPane.add(getTotalekostenLabel());
    contentPane.add(getGebeldeminutenLabel());
    contentPane.add(getDuurVeld());
    contentPane.add(getGesprekskostenVeld());
    contentPane.add(getTotalekostenVeld());
    contentPane.add(getGebeldeminutenVeld());
  }
  private JLabel getDuurLabel() {
    if (duurLabel == null) {
    	duurLabel = new JLabel("duur van een gesprek");
    	duurLabel.setBounds(17, 15, 150, 24);
    }
    return duurLabel;
  }
  private JLabel getGesprekskostenLabel() {
    if (gesprekskostenLabel == null) {
    	gesprekskostenLabel = new JLabel("gesprekskosten");
    	gesprekskostenLabel.setBounds(17, 54, 150, 24);
    }
    return gesprekskostenLabel;
  }
  private JLabel getTotalekostenLabel() {
    if (totalekostenLabel == null) {
    	totalekostenLabel = new JLabel("totale kosten");
    	totalekostenLabel.setBounds(17, 93, 150, 24);
    }
    return totalekostenLabel;
  }
  private JLabel getGebeldeminutenLabel() {
    if (gebeldeminutenLabel == null) {
    	gebeldeminutenLabel = new JLabel("totaal gebelde minuten");
    	gebeldeminutenLabel.setBounds(17, 132, 150, 24);
    }
    return gebeldeminutenLabel;
  }
  private JTextField getDuurVeld() {
    if (duurVeld == null) {
    	duurVeld = new JTextField();
    	duurVeld.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    duurVeldAction();
    	  }
    	});
    	duurVeld.setBounds(183, 15, 100, 24);
    	duurVeld.setColumns(10);
    }
    return duurVeld;
  }
  private JTextField getGesprekskostenVeld() {
    if (gesprekskostenVeld == null) {
    	gesprekskostenVeld = new JTextField();
    	gesprekskostenVeld.setEditable(false);
    	gesprekskostenVeld.setColumns(10);
    	gesprekskostenVeld.setBounds(183, 54, 100, 24);
    }
    return gesprekskostenVeld;
  }
  private JTextField getTotalekostenVeld() {
    if (totalekostenVeld == null) {
    	totalekostenVeld = new JTextField();
    	totalekostenVeld.setEditable(false);
    	totalekostenVeld.setColumns(10);
    	totalekostenVeld.setBounds(183, 93, 100, 24);
    }
    return totalekostenVeld;
  }
  private JTextField getGebeldeminutenVeld() {
    if (gebeldeminutenVeld == null) {
    	gebeldeminutenVeld = new JTextField();
    	gebeldeminutenVeld.setEditable(false);
    	gebeldeminutenVeld.setColumns(10);
    	gebeldeminutenVeld.setBounds(183, 132, 100, 24);
    }
    return gebeldeminutenVeld;
  }
  
  protected void duurVeldAction() {
    int duur = Integer.parseInt(duurVeld.getText());
    double kosten = telefoonteller.bel(duur);
    gesprekskostenVeld.setText("" + kosten);
    gebeldeminutenVeld.setText("" + telefoonteller.getGebeldeMinuten());
    totalekostenVeld.setText("" + telefoonteller.getTotaleKosten());
  }
}
