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

public class Organizator extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfsifra;
	private JTextField tfnaziv;
	private JTextField tfkontakt;
	private JTextField tflokacija;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Organizator dialog = new Organizator();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Organizator() {
		setTitle("Organizator");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sifra_Organizatora");
		lblNewLabel.setBounds(24, 28, 126, 17);
		contentPanel.add(lblNewLabel);
		
		tfsifra = new JTextField();
		tfsifra.setBounds(160, 26, 226, 20);
		contentPanel.add(tfsifra);
		tfsifra.setColumns(10);
		{
			JLabel lblNazivorganizatora = new JLabel("Naziv_Organizatora");
			lblNazivorganizatora.setBounds(24, 63, 126, 17);
			contentPanel.add(lblNazivorganizatora);
		}
		{
			tfnaziv = new JTextField();
			tfnaziv.setColumns(10);
			tfnaziv.setBounds(160, 61, 226, 20);
			contentPanel.add(tfnaziv);
		}
		{
			tfkontakt = new JTextField();
			tfkontakt.setColumns(10);
			tfkontakt.setBounds(160, 104, 226, 20);
			contentPanel.add(tfkontakt);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Kontakt_Organizatora");
			lblNewLabel_1.setBounds(24, 106, 126, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Lokacija_Organizatora");
			lblNewLabel_1.setBounds(24, 154, 126, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			tflokacija = new JTextField();
			tflokacija.setColumns(10);
			tflokacija.setBounds(160, 152, 226, 20);
			contentPanel.add(tflokacija);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sifra = tfsifra.getText();
						String naziv = tfnaziv.getText();
						String kontakt = tfkontakt.getText();
						String lokacija = tflokacija.getText();

						try {						
						 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							  Connection conn = DriverManager.getConnection 
				("jdbc:mysql://ucka.veleri.hr/llerga?" +
				 "user=llerga&password=11");
							  //id, Sifra_organizatora, Naziv_organizatora, Kontakt_organizatora, Lokacija_organizatora
							  String sql = "INSERT INTO Organizator VALUES(?,?,?,?);";

							  PreparedStatement stmt = conn.prepareStatement(sql);
							  stmt.setString(1,sifra);
							  stmt.setString(2,naziv);
							  stmt.setString(3,kontakt);
							  stmt.setString(4,lokacija);
				  			  stmt.execute();
											
							  conn.close();
										
							  tfsifra.setText("");
							  tfnaziv.setText("");
							  tfkontakt.setText("");
							  tflokacija.setText("");
											
							} catch(Exception ex) {
							  JOptionPane.showMessageDialog(null, 
				   ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
							}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
