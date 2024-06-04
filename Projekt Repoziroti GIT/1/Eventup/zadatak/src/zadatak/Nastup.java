package zadatak;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Nastup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		
		textField = new JTextField();
		textField.setBounds(141, 28, 204, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 53, 204, 20);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 78, 204, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 103, 204, 20);
		contentPanel.add(textField_3);
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(141, 146, 204, 20);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(141, 174, 204, 20);
		contentPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(141, 208, 204, 20);
		contentPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(141, 233, 204, 20);
		contentPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(141, 261, 204, 20);
		contentPanel.add(textField_8);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
