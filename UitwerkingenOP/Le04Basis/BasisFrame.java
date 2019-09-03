import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * GUI-klasse met tekstveld en label.
 * Als in het tekstveld een naam x wordt ingevoerd en op
 * ENTER gedrukt, dan verschijnt de tekst "Hallo x!"
 */
public class BasisFrame extends JFrame {

  private JPanel contentPane;
  private JLabel halloLabel;
  private JTextField naamVeld;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          BasisFrame frame = new BasisFrame();
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
  public BasisFrame() {
    initialize();
  }
  private void initialize() {
    setTitle("BasisFrame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getHalloLabel());
    contentPane.add(getNaamVeld());
  }
  private JLabel getHalloLabel() {
    if (halloLabel == null) {
    	halloLabel = new JLabel("Hallo ?");
    	halloLabel.setBounds(37, 95, 98, 29);
    }
    return halloLabel;
  }
  private JTextField getNaamVeld() {
    if (naamVeld == null) {
    	naamVeld = new JTextField();
    	naamVeld.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    naamVeldAction();
    	  }
    	});
    	naamVeld.setBounds(37, 35, 179, 22);
    	naamVeld.setColumns(10);
    }
    return naamVeld;
  }
  
  private void naamVeldAction() {
    String tekst = naamVeld.getText();
    halloLabel.setText("Hallo " + tekst + "!");
  }
}
