package zadatak;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Nastup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfsn;
	private JTextField tfdm;
	private JTextField tfmn;
	private JTextField tfsi;
	private JTextField tfsr;
	private JTextField tfdr;
	private JTextField tfir;
	private JTextField tfsn2;
	private JTextField tfso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Nastup dialog = new Nastup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Nastup() {
		setBounds(100, 100, 742, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Sifra_nastupa");
			lblNewLabel.setBounds(36, 31, 95, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblDatumnastupa = new JLabel("Datum_nastupa");
		lblDatumnastupa.setBounds(36, 56, 95, 14);
		contentPanel.add(lblDatumnastupa);
		
		JLabel lblMjestonastupa = new JLabel("Mjesto_nastupa");
		lblMjestonastupa.setBounds(36, 81, 95, 14);
		contentPanel.add(lblMjestonastupa);
		
		JLabel lblSifraizvodaca = new JLabel("Sifra_izvodaca");
		lblSifraizvodaca.setBounds(36, 106, 95, 14);
		contentPanel.add(lblSifraizvodaca);
		
		tfsn = new JTextField();
		tfsn.setBounds(141, 28, 204, 20);
		contentPanel.add(tfsn);
		tfsn.setColumns(10);
		
		tfdm = new JTextField();
		tfdm.setColumns(10);
		tfdm.setBounds(141, 53, 204, 20);
		contentPanel.add(tfdm);
		
		tfmn = new JTextField();
		tfmn.setColumns(10);
		tfmn.setBounds(141, 78, 204, 20);
		contentPanel.add(tfmn);
		
		tfsi = new JTextField();
		tfsi.setColumns(10);
		tfsi.setBounds(141, 103, 204, 20);
		contentPanel.add(tfsi);
		
		JLabel lblNewLabel_1 = new JLabel("Sifra_racuna");
		lblNewLabel_1.setBounds(36, 149, 103, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datum_racuna");
		lblNewLabel_1_1.setBounds(36, 177, 103, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Iznos_racuna");
		lblNewLabel_1_2.setBounds(36, 211, 103, 14);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sifra_organizatora");
		lblNewLabel_1_3.setBounds(36, 236, 103, 14);
		contentPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Sifra_nastupa");
		lblNewLabel_1_4.setBounds(36, 261, 103, 14);
		contentPanel.add(lblNewLabel_1_4);
		
		tfsr = new JTextField();
		tfsr.setColumns(10);
		tfsr.setBounds(141, 146, 204, 20);
		contentPanel.add(tfsr);
		
		tfdr = new JTextField();
		tfdr.setColumns(10);
		tfdr.setBounds(141, 174, 204, 20);
		contentPanel.add(tfdr);
		
		tfir = new JTextField();
		tfir.setColumns(10);
		tfir.setBounds(141, 208, 204, 20);
		contentPanel.add(tfir);
		
		tfsn2 = new JTextField();
		tfsn2.setColumns(10);
		tfsn2.setBounds(141, 261, 204, 20);
		contentPanel.add(tfsn2);
		
		tfso = new JTextField();
		tfso.setBounds(141, 233, 204, 20);
		contentPanel.add(tfso);
		tfso.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sifraN = tfsn.getText();
						String datumN = tfdm.getText();
						String mjestoN = tfmn.getText();
						String sifraI = tfsi.getText();
						String sifraR = tfsr.getText();
						String datumR = tfdr.getText();
						String iznosR = tfir.getText();
						String sifraO = tfso.getText();
						String sifraN2 = tfsn2.getText();

						try {						
						 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							  Connection conn = DriverManager.getConnection 
				("jdbc:mysql://ucka.veleri.hr:3306/llerga?" +
				 "user=llerga&password=11");
							  //id, Sifra_nastupa, Datum_nastupa, Mjesto_nastupa, Sifra_izvodaca
							  String sql = "INSERT INTO Nastup VALUES(?,?,?,?);";

							  PreparedStatement stmt = conn.prepareStatement(sql);
							  stmt.setString(1,sifraN);
							  stmt.setString(2,datumN);
							  stmt.setString(3,mjestoN);
							  stmt.setString(4,sifraI);
				  			  stmt.execute();
											
							  conn.close();
										
							  tfsn.setText("");
							  tfdm.setText("");
							  tfmn.setText("");
							  tfsi.setText("");
											
							} catch(Exception ex) {
							  JOptionPane.showMessageDialog(null, 
				   ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
							}

						try {						
						 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							  Connection conn = DriverManager.getConnection 
				("jdbc:mysql://ucka.veleri.hr:3306/llerga?" +
				 "user=llerga&password=11");
							  //id, Sifra_racuna, Datum_racuna, Iznos_racuna, Sifra_nastupa
							  String sql = "INSERT INTO Racun VALUES(?,?,?,?,?);";

							  PreparedStatement stmt = conn.prepareStatement(sql);
							  stmt.setString(1,sifraR);
							  stmt.setString(2,datumR);
							  stmt.setString(3,iznosR);
							  stmt.setString(4,sifraO);
							  stmt.setString(5,sifraN2);
				  			  stmt.execute();
											
							  conn.close();
										
							  
							  tfsr.setText("");
							  tfdr.setText("");
							  tfir.setText("");
							  tfsn2.setText("");
											
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
