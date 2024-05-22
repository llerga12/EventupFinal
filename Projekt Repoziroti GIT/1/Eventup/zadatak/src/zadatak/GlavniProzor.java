package zadatak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

	private JFrame frmEventup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frmEventup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProzor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventup = new JFrame();
		frmEventup.setTitle("EVENT-UP");
		frmEventup.setBounds(100, 100, 450, 300);
		frmEventup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Organizator");
		btnNewButton.setBounds(141, 130, 140, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Organizator dlg = new Organizator();
				dlg.setVisible(true);
			}
		});
		frmEventup.getContentPane().setLayout(null);
		frmEventup.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izvodac");
		btnNewButton_1.setBounds(141, 34, 140, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgIzvodaci dlg = new DlgIzvodaci();
				dlg.setVisible(true);
			}
		});
		frmEventup.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Nastup");
		btnNewButton_2.setBounds(141, 82, 140, 37);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frmEventup.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Racun");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Racun dlg = new Racun();
				dlg.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(141, 178, 140, 37);
		frmEventup.getContentPane().add(btnNewButton_3);
	}
}
