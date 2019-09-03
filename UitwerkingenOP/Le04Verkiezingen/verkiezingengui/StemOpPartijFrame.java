package verkiezingengui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import verkiezingen.Stemmachine;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class StemOpPartijFrame extends JFrame {

  private Stemmachine stemmachine = new Stemmachine();
  private JPanel contentPane;
  private JButton cdaKnop;
  private JButton pvdaKnop;
  private JButton vvdKnop;
  private JButton uitslagKnop;
  private JTextArea uitslagGebied;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          StemOpPartijFrame frame = new StemOpPartijFrame();
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
  public StemOpPartijFrame() {
    initialize();
    mijnInit();
  }
  private void initialize() {
    setTitle("grafische stemmachine");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 314);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getCdaKnop());
    contentPane.add(getPvdaKnop());
    contentPane.add(getVvdKnop());
    contentPane.add(getUitslagKnop());
    contentPane.add(getUitslagGebied());
  }
  private JButton getCdaKnop() {
    if (cdaKnop == null) {
    	cdaKnop = new JButton("CDA");
    	cdaKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    cdaKnopAction();
    	  }
    	});
    	cdaKnop.setBounds(35, 38, 97, 25);
    }
    return cdaKnop;
  }
  private JButton getPvdaKnop() {
    if (pvdaKnop == null) {
    	pvdaKnop = new JButton("PvdA");
    	pvdaKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    pvdaKnopAction();
    	  }
    	});
    	pvdaKnop.setBounds(167, 38, 97, 25);
    }
    return pvdaKnop;
  }
  private JButton getVvdKnop() {
    if (vvdKnop == null) {
    	vvdKnop = new JButton("VVD");
    	vvdKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    vvdKnopAction();
    	  }
    	});
    	vvdKnop.setBounds(299, 38, 97, 25);
    }
    return vvdKnop;
  }
  private JButton getUitslagKnop() {
    if (uitslagKnop == null) {
    	uitslagKnop = new JButton("Uitslag");
    	uitslagKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    uitslagKnopAction();
    	  }
    	});
    	uitslagKnop.setBounds(143, 100, 144, 25);
    }
    return uitslagKnop;
  }
  private JTextArea getUitslagGebied() {
    if (uitslagGebied == null) {
    	uitslagGebied = new JTextArea();
    	uitslagGebied.setBounds(35, 154, 361, 70);
    }
    return uitslagGebied;
  }
  
  private void mijnInit() {
    stemmachine.zetAan();
  }
  
  private void cdaKnopAction() {
    stemmachine.stemOpNummer(1, 1);
  }
  
  private void pvdaKnopAction() {
    stemmachine.stemOpNummer(2, 1);
  }
  
  private void vvdKnopAction() {
    stemmachine.stemOpNummer(3, 1);
  }
  
  private void uitslagKnopAction() {
    String uitslag = stemmachine.geefUitslagPerPartij();
    uitslagGebied.setText(uitslag);
  }
  
}
