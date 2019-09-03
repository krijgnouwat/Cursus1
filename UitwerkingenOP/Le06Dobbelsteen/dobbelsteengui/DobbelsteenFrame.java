package dobbelsteengui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dobbelsteen.Dobbelsteen;

public class DobbelsteenFrame extends JFrame {
  private Dobbelsteen dobbelsteen = new Dobbelsteen();
  
  private JPanel contentPane;
  private JButton gooiKnop;
  private JTextField ogenVeld;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DobbelsteenFrame frame = new DobbelsteenFrame();
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
  public DobbelsteenFrame() {
    initialize();
  }
  private void initialize() {
    setTitle("Dobbelsteen simulatie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 250, 140);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getGooiKnop());
    contentPane.add(getOgenVeld());
  }
  private JButton getGooiKnop() {
    if (gooiKnop == null) {
    	gooiKnop = new JButton("gooi!");
    	gooiKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    gooiKnopAction();
    	  }
    	});
    	gooiKnop.setBounds(19, 16, 81, 35);
    }
    return gooiKnop;
  }
  private JTextField getOgenVeld() {
    if (ogenVeld == null) {
    	ogenVeld = new JTextField();
    	ogenVeld.setFont(new Font("Dialog", Font.BOLD, 72));
    	ogenVeld.setBounds(122, 16, 94, 73);
    	ogenVeld.setColumns(10);
    }
    return ogenVeld;
  }
  
  /*
   * Toon meteen een eerste worp.
   */
  private void mijnInit(){
    ogenVeld.setText("" + dobbelsteen.getOgen());
  }
  
  /*
   * Event handler voor gooiKnop.
   * Gooit de dobbelsteen en toon de waarde
   */
  private void gooiKnopAction(){
    dobbelsteen.werp();
    ogenVeld.setText("" + dobbelsteen.getOgen());
  }
}
