package knoppengui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Een GUI-klasse die twee knoppen bevat waarvan er steeds 
 * één zichtbaar is. Bij klikken op de zichtbare knop wordt
 * deze onzichtbaar en de andere zichtbaar.
 */
public class KnoppenFrame extends JFrame {

  private JPanel contentPane;
  private JButton knop1;
  private JButton knop2;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          KnoppenFrame frame = new KnoppenFrame();
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
  public KnoppenFrame() {
    initialize();
  }
  private void initialize() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getKnop1());
    contentPane.add(getKnop2());
  }

  private JButton getKnop1() {
    if (knop1 == null) {
    	knop1 = new JButton("knop1");
    	knop1.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    knop1Action();
    	  }
    	});
    	knop1.setBounds(26, 42, 97, 25);
    }
    return knop1;
  }
  private JButton getKnop2() {
    if (knop2 == null) {
    	knop2 = new JButton("knop2");
    	knop2.setVisible(false);
    	knop2.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    knop2Action();
    	  }
    	});
    	knop2.setBounds(160, 42, 97, 25);
    }
    return knop2;
  }
  
  private void knop1Action() {
    knop1.setVisible(false);
    knop2.setVisible(true);
  }
  
  private void knop2Action() {
    knop1.setVisible(true);
    knop2.setVisible(false);
  }
}
