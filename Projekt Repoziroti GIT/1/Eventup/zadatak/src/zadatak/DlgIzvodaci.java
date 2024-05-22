package zadatak;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DlgIzvodaci extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField SIzvodaca;
	private JTextField IIzvodaca;
	private JTextField PIzvodaca;
	private JTextField UIIzvodaca;
	private JTextField KIzvodaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgIzvodaci dialog = new DlgIzvodaci();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIzvodaci() {
		setTitle("Izvodaci");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblI = new JLabel("Sifra Izvodaca");
		lblI.setBounds(30, 42, 91, 14);
		contentPanel.add(lblI);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ime Izvodaca");
		lblNewLabel_3_1.setBounds(30, 84, 91, 14);
		contentPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Prezime Izvodaca");
		lblNewLabel_3_2.setBounds(30, 125, 91, 14);
		contentPanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Umjetnicko Ime");
		lblNewLabel_3_3.setBounds(30, 163, 91, 14);
		contentPanel.add(lblNewLabel_3_3);
		
		SIzvodaca = new JTextField();
		SIzvodaca.setBounds(150, 39, 213, 20);
		contentPanel.add(SIzvodaca);
		SIzvodaca.setColumns(10);
		
		IIzvodaca = new JTextField();
		IIzvodaca.setColumns(10);
		IIzvodaca.setBounds(150, 81, 213, 20);
		contentPanel.add(IIzvodaca);
		
		PIzvodaca = new JTextField();
		PIzvodaca.setColumns(10);
		PIzvodaca.setBounds(150, 122, 213, 20);
		contentPanel.add(PIzvodaca);
		
		UIIzvodaca = new JTextField();
		UIIzvodaca.setColumns(10);
		UIIzvodaca.setBounds(150, 160, 213, 20);
		contentPanel.add(UIIzvodaca);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Kontakt Izvodaca");
		lblNewLabel_3_3_1.setBounds(30, 200, 91, 14);
		contentPanel.add(lblNewLabel_3_3_1);
		
		KIzvodaca = new JTextField();
		KIzvodaca.setColumns(10);
		KIzvodaca.setBounds(150, 197, 213, 20);
		contentPanel.add(KIzvodaca);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String SIzvodac = SIzvodaca.getText();
						String IIzvodac = IIzvodaca.getText();
						String PIzvodac = PIzvodaca.getText();
						String UIIzvodac = UIIzvodaca.getText();
						String KIzvodac = KIzvodaca.getText();
						
						try {						
					 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						  Connection conn = DriverManager.getConnection 
			("jdbc:mysql://ucka.veleri.hr/rda?" +
			 "user=vdavid&password=11");
						  //id, Sifra_izvodaca, Ime_izvodaca, Prezime_izvodaca, UmjetnickoIme_izvodaca,Kontakt_izvodaca
						  String sql = "INSERT INTO film VALUES(NULL,?,?,?,?);";
						  PreparedStatement stmt = conn.prepareStatement(sql);
						  stmt.setString(1,SIzvodac);
						  stmt.setString(2, IIzvodac);
						  stmt.setString(3, PIzvodac);
						  stmt.setString(4, UIIzvodac);
						  stmt.setString(5, KIzvodac);
			  			  stmt.execute();
										
						  conn.close();
									
						  SIzvodaca.setText("");
						  IIzvodaca.setText("");
						  PIzvodaca.setText("");
						  UIIzvodaca.setText("");
						  KIzvodaca.setText("");
										
						} catch(Exception ex) {
						  JOptionPane.showMessageDialog(null, 
			   ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
						}
					}
				});

		}
	}
}
}
