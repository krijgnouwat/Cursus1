package variabelveldgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VariabelVeldFrame extends JFrame {

  private JPanel contentPane;
  private JTextField variabelVeld;
  private JLabel hoogteLabel;
  private JLabel breedteLabel;
  private JSlider breedteSlider;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          VariabelVeldFrame frame = new VariabelVeldFrame();
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
  public VariabelVeldFrame() {
    initialize();
    mijnInit();
  }
  private void initialize() {
    setTitle("Variabele rechthoek");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 540, 240);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getVariabelVeld());
    contentPane.add(getHoogteLabel());
    contentPane.add(getBreedteLabel());
    contentPane.add(getBreedteSlider());
  }
  private JTextField getVariabelVeld() {
    if (variabelVeld == null) {
    	variabelVeld = new JTextField();
    	variabelVeld.setBounds(20, 15, 220, 60);
    	variabelVeld.setColumns(10);
    }
    return variabelVeld;
  }
  private JLabel getHoogteLabel() {
    if (hoogteLabel == null) {
    	hoogteLabel = new JLabel("hoogte: ");
    	hoogteLabel.setBounds(20, 80, 120, 20);
    }
    return hoogteLabel;
  }
  private JLabel getBreedteLabel() {
    if (breedteLabel == null) {
    	breedteLabel = new JLabel("breeedte: ");
    	breedteLabel.setBounds(20, 110, 120, 20);
    }
    return breedteLabel;
  }
  private JSlider getBreedteSlider() {
    if (breedteSlider == null) {
    	breedteSlider = new JSlider();
        breedteSlider.setMaximum(500);
    	breedteSlider.addChangeListener(new ChangeListener() {
    	  public void stateChanged(ChangeEvent e) {
    	    breedteSliderAction();
    	  }
    	});

    	breedteSlider.setBounds(20, 150, 220, 25);
    }
    return breedteSlider;
  }
  
  private void mijnInit() {
    hoogteLabel.setText("hoogte:  " + variabelVeld.getHeight());
    breedteLabel.setText("breedte: " + variabelVeld.getWidth());
    breedteSlider.setValue(variabelVeld.getWidth());
  }
  
  private void breedteSliderAction() {
    variabelVeld.setSize(breedteSlider.getValue(), variabelVeld.getHeight());
    breedteLabel.setText("breedte: " + variabelVeld.getWidth());
  }
}
