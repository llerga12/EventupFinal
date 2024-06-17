package zadatak;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

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
    private JComboBox<String> comboBoxOrganizatori;

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
            lblNewLabel.setBounds(36, 37, 162, 14);
            contentPanel.add(lblNewLabel);
        }
        
        JLabel lblDatumnastupa = new JLabel("Datum_nastupa");
        lblDatumnastupa.setBounds(36, 62, 162, 14);
        contentPanel.add(lblDatumnastupa);
        
        JLabel lblMjestonastupa = new JLabel("Mjesto_nastupa");
        lblMjestonastupa.setBounds(36, 118, 162, 14);
        contentPanel.add(lblMjestonastupa);
        
        JLabel lblSifraizvodaca = new JLabel("Sifra_izvodaca");
        lblSifraizvodaca.setBounds(36, 143, 162, 14);
        contentPanel.add(lblSifraizvodaca);
        
        tfsn = new JTextField();
        tfsn.setBounds(211, 31, 204, 20);
        contentPanel.add(tfsn);
        tfsn.setColumns(10);
        
        tfdm = new JTextField();
        tfdm.setColumns(10);
        tfdm.setBounds(211, 56, 204, 20);
        contentPanel.add(tfdm);
        
        tfmn = new JTextField();
        tfmn.setColumns(10);
        tfmn.setBounds(211, 112, 204, 20);
        contentPanel.add(tfmn);
        
        tfsi = new JTextField();
        tfsi.setColumns(10);
        tfsi.setBounds(211, 137, 204, 20);
        contentPanel.add(tfsi);
        
        JLabel lblNewLabel_1 = new JLabel("Sifra_racuna");
        lblNewLabel_1.setBounds(36, 171, 162, 14);
        contentPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Datum_racuna");
        lblNewLabel_1_1.setBounds(36, 199, 162, 14);
        contentPanel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Iznos_racuna");
        lblNewLabel_1_2.setBounds(36, 346, 163, 14);
        contentPanel.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Sifra_nacina_placanja");
        lblNewLabel_1_3.setBounds(36, 314, 163, 14);
        contentPanel.add(lblNewLabel_1_3);
        
        tfsr = new JTextField();
        tfsr.setColumns(10);
        tfsr.setBounds(211, 165, 204, 20);
        contentPanel.add(tfsr);
        
        tfdr = new JTextField();
        tfdr.setColumns(10);
        tfdr.setBounds(211, 193, 204, 20);
        contentPanel.add(tfdr);
        
        tfir = new JTextField();
        tfir.setColumns(10);
        tfir.setBounds(211, 340, 204, 20);
        contentPanel.add(tfir);
        
        tfsn2 = new JTextField();
        tfsn2.setColumns(10);
        tfsn2.setBounds(211, 308, 204, 20);
        contentPanel.add(tfsn2);
        
        JLabel lblSifraorganizatora = new JLabel("Sifra_organizatora");
        lblSifraorganizatora.setBounds(36, 280, 144, 14);
        contentPanel.add(lblSifraorganizatora);
        
        comboBoxOrganizatori = new JComboBox<>();
        comboBoxOrganizatori.setBounds(211, 277, 204, 20);
        contentPanel.add(comboBoxOrganizatori);
        
        JLabel lblNewLabel_2 = new JLabel("*Datum mora biti formata: \"YYYY-MM-DD\"");
    	lblNewLabel_2.setForeground(Color.RED);
    	lblNewLabel_2.setBounds(36, 224, 379, 14);
    	contentPanel.add(lblNewLabel_2);
    	
    	JLabel lblNewLabel_2_1 = new JLabel("*Datum mora biti formata: \"YYYY-MM-DD\"");
    	lblNewLabel_2_1.setForeground(Color.RED);
    	lblNewLabel_2_1.setBounds(46, 87, 369, 14);
    	contentPanel.add(lblNewLabel_2_1);
        
        JButton btnUnesi = new JButton("Unesi");
        btnUnesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sifraNastupa = tfsn.getText();
                String datumNastupa = tfdm.getText();
                String mjestoNastupa = tfmn.getText();
                String sifraIzvodaca = tfsi.getText();
                String sifraRacuna = tfsr.getText();
                String datumRacuna = tfdr.getText();
                String iznosRacuna = tfir.getText();
                String sifraNacinaPlacanja = tfsn2.getText();
                String sifraOrganizatora = (String) comboBoxOrganizatori.getSelectedItem();
                
                try {
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://ucka.veleri.hr/llerga?" +
                            "user=llerga&password=11");
    
                    String sql = "INSERT INTO Nastup (Sifra_nastupa, Datum_nastupa, Mjesto_nastupa, Sifra_izvodaca, Sifra_racuna, Datum_racuna, Iznos_racuna, Sifra_nacina_placanja, Sifra_organizatora) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, sifraNastupa);
                    stmt.setString(2, datumNastupa);
                    stmt.setString(3, mjestoNastupa);
                    stmt.setString(4, sifraIzvodaca);
                    stmt.setString(5, sifraRacuna);
                    stmt.setString(6, datumRacuna);
                    stmt.setString(7, iznosRacuna);
                    stmt.setString(8, sifraNacinaPlacanja);
                    stmt.setString(9, sifraOrganizatora);
    
                    stmt.executeUpdate();
    
                    conn.close();
    
                    tfsn.setText("");
                    tfdm.setText("");
                    tfmn.setText("");
                    tfsi.setText("");
                    tfsr.setText("");
                    tfdr.setText("");
                    tfir.setText("");
                    tfsn2.setText("");
                    comboBoxOrganizatori.setSelectedIndex(-1);
    
                    JOptionPane.showMessageDialog(null, "Podaci su uspješno uneseni.");
    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Greška prilikom unosa podataka: " + ex.getMessage(),
                            "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUnesi.setBounds(285, 385, 130, 23);
        contentPanel.add(btnUnesi);
        
        popuniComboBoxOrganizatori(); // Poziv metode za popunjavanje combo box-a
    }
    
    // Metoda za popunjavanje combo box-a podacima iz baze
    private void popuniComboBoxOrganizatori() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://ucka.veleri.hr/llerga?" +
                    "user=llerga&password=11");

            String sql = "SELECT Sifra_organizatora, Naziv_organizatora FROM Organizator";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<String> organizatori = new ArrayList<>();
            while (rs.next()) {
                String sifra = rs.getString("Sifra_organizatora");
                String naziv = rs.getString("Naziv_organizatora");
                organizatori.add(sifra + " - " + naziv);
            }

            comboBoxOrganizatori.removeAllItems();
            for (String org : organizatori) {
                comboBoxOrganizatori.addItem(org);
            }

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Greška prilikom dohvata organizatora: " + ex.getMessage(),
                    "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }
}
