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

public class Racun extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfSifraRacuna;
	private JTextField tfIznosRacuna;
	private JTextField tfSifraOrganizatora;
	private JTextField tfSifraNastupa;
	private JTextField tfDatumRac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Racun dialog = new Racun();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Racun() {
		setTitle("Racun");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sifra_Racuna");
		lblNewLabel.setBounds(25, 25, 100, 15);
		contentPanel.add(lblNewLabel);
		
		tfSifraRacuna = new JTextField();
		tfSifraRacuna.setBounds(150, 25, 200, 20);
		contentPanel.add(tfSifraRacuna);
		tfSifraRacuna.setColumns(10);
		{
			JLabel lblNazivorganizatora = new JLabel("Iznos_Racuna");
			lblNazivorganizatora.setBounds(25, 50, 100, 15);
			contentPanel.add(lblNazivorganizatora);
		}
		{
			tfIznosRacuna = new JTextField();
			tfIznosRacuna.setColumns(10);
			tfIznosRacuna.setBounds(150, 50, 200, 20);
			contentPanel.add(tfIznosRacuna);
		}
		{
			tfSifraOrganizatora = new JTextField();
			tfSifraOrganizatora.setColumns(10);
			tfSifraOrganizatora.setBounds(150, 75, 200, 20);
			contentPanel.add(tfSifraOrganizatora);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Sifra_Organizatora");
			lblNewLabel_1.setBounds(25, 75, 100, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Sifra_Nastupa");
			lblNewLabel_1.setBounds(25, 100, 100, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			tfSifraNastupa = new JTextField();
			tfSifraNastupa.setColumns(10);
			tfSifraNastupa.setBounds(150, 100, 200, 20);
			contentPanel.add(tfSifraNastupa);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Datum_Racuna");
		lblNewLabel_1.setBounds(25, 125, 100, 15);
		contentPanel.add(lblNewLabel_1);
		
		tfDatumRac = new JTextField();
		tfDatumRac.setColumns(10);
		tfDatumRac.setBounds(150, 125, 200, 20);
		contentPanel.add(tfDatumRac);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sifra_rac = tfSifraRacuna.getText();
						String iznos_rac = tfIznosRacuna.getText();
						String sifra_org = tfSifraOrganizatora.getText();
						String sifra_nast = tfSifraNastupa.getText();
						String datum_rac = tfDatumRac.getText();

						try {						
						 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							  Connection conn = DriverManager.getConnection 
				("jdbc:mysql://ucka.veleri.hr/llerga?" +
				 "user=llerga&password=11");
							  //id, Sifra_Racuna, Datum_racuna, Iznos_racuna, Sifra_organizatora, Sifra_nastupa
							  String sql = "INSERT INTO Organizator VALUES(?,?,?,?,?);";

							  PreparedStatement stmt = conn.prepareStatement(sql);
							  stmt.setString(1,sifra_rac);
							  stmt.setString(2,iznos_rac);
							  stmt.setString(3,sifra_org);
							  stmt.setString(4,sifra_nast);
							  stmt.setString(5,datum_rac);
				  			  stmt.execute();
											
							  conn.close();
										
							  tfSifraRacuna.setText("");
							  tfIznosRacuna.setText("");
							  tfSifraOrganizatora.setText("");
							  tfSifraNastupa.setText("");
											
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
