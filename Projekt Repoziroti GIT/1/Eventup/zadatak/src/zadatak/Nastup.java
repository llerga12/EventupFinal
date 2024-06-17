package zadatak;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Nastup extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField tfsn;
    private JTextField tfdm;
    private JTextField tfmn;
    private JTextField tfsr;
    private JTextField tfdr;
    private JTextField tfir;
    private JTextField tfsn2;
    private JComboBox<String> comboBoxOrganizatori;
    private JComboBox<String> comboBoxIzvodaci;

    /**
     * Aplikacija
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
     * Kreiranje dijaloga.
     */
    public Nastup() {
    	setTitle("Nastup");
        setBounds(100, 100, 742, 489);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblNewLabel = new JLabel("Sifra nastupa");
            lblNewLabel.setBounds(36, 37, 162, 14);
            contentPanel.add(lblNewLabel);
        }

        JLabel lblDatumnastupa = new JLabel("Datum nastupa");
        lblDatumnastupa.setBounds(36, 62, 162, 14);
        contentPanel.add(lblDatumnastupa);

        JLabel lblMjestonastupa = new JLabel("Mjesto nastupa");
        lblMjestonastupa.setBounds(36, 118, 162, 14);
        contentPanel.add(lblMjestonastupa);

        JLabel lblSifraizvodaca = new JLabel("Sifra izvodaca");
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

        comboBoxIzvodaci = new JComboBox<>();
        comboBoxIzvodaci.setBounds(211, 137, 204, 20);
        contentPanel.add(comboBoxIzvodaci);

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
                String sifraIzvodaca = getSelectedSifra(comboBoxIzvodaci);
                String sifraRacuna = tfsr.getText();
                String datumRacuna = tfdr.getText();
                String iznosRacuna = tfir.getText();
                String sifraNacinaPlacanja = tfsn2.getText();
                String sifraOrganizatora = getSelectedSifra(comboBoxOrganizatori);

                try {
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://ucka.veleri.hr/llerga?" +
                            "user=llerga&password=11");

                    // Insert u tabelu Nastup
                    String sqlNastup = "INSERT INTO Nastup (Sifra_nastupa, Datum_nastupa, Mjesto_nastupa, Sifra_izvodaca) "
                            + "VALUES (?, ?, ?, ?)";
                    PreparedStatement stmtNastup = conn.prepareStatement(sqlNastup);
                    stmtNastup.setString(1, sifraNastupa);
                    stmtNastup.setString(2, datumNastupa);
                    stmtNastup.setString(3, mjestoNastupa);
                    stmtNastup.setString(4, sifraIzvodaca);

                    stmtNastup.executeUpdate();

                    // Insert u tabelu Racun
                    String sqlRacun = "INSERT INTO Racun (Sifra_racuna, Datum_racuna, Iznos_racuna, Sifra_organizatora, Sifra_nastupa) "
                            + "VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement stmtRacun = conn.prepareStatement(sqlRacun);
                    stmtRacun.setString(1, sifraRacuna);
                    stmtRacun.setString(2, datumRacuna);
                    stmtRacun.setString(3, iznosRacuna);
                    stmtRacun.setString(4, sifraOrganizatora);
                    stmtRacun.setString(5, sifraNastupa);

                    stmtRacun.executeUpdate();

                    conn.close();

                    tfsn.setText("");
                    tfdm.setText("");
                    tfmn.setText("");
                    comboBoxIzvodaci.setSelectedIndex(-1);
                    tfsr.setText("");
                    tfdr.setText("");
                    tfir.setText("");
                    tfsn2.setText("");
                    comboBoxOrganizatori.setSelectedIndex(-1);

                    JOptionPane.showMessageDialog(null, "Podaci su uspješno uneseni.");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom unosa podataka: " + ex.getMessage(),
                            "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUnesi.setBounds(141, 385, 130, 23);
        contentPanel.add(btnUnesi);

        // Dodavanje Cancel dugmeta
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Zatvara trenutni JDialog
            }
        });
        btnCancel.setBounds(285, 385, 130, 23);
        contentPanel.add(btnCancel);

        popuniComboBoxOrganizatori(); // Poziv metode za popunjavanje combo box-a organizatorima
        popuniComboBoxIzvodaci(); // Poziv metode za popunjavanje combo box-a izvođačima
    }

    // Metoda za popunjavanje combo box-a organizatorima podacima iz baze
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
                organizatori.add(sifra); // Dodajemo samo Sifru organizatora
            }

            comboBoxOrganizatori.removeAllItems();
            for (String org : organizatori) {
                comboBoxOrganizatori.addItem(org);
            }

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Greska prilikom dohvata organizatora: " + ex.getMessage(),
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metoda za popunjavanje combo box-a izvodacima podacima iz baze
    private void popuniComboBoxIzvodaci() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://ucka.veleri.hr/llerga?" +
                    "user=llerga&password=11");

            String sql = "SELECT Sifra_izvodaca, Ime_Izvodaca FROM Izvodac";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<String> izvodaci = new ArrayList<>();
            while (rs.next()) {
                String sifra = rs.getString("Sifra_izvodaca");
                String ime = rs.getString("Ime_Izvodaca");
                izvodaci.add(sifra); // Dodajemo samo sifru izvodaca
            }

            comboBoxIzvodaci.removeAllItems();
            for (String izv : izvodaci) {
                comboBoxIzvodaci.addItem(izv);
            }

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Greska prilikom dohvata izvođača: " + ex.getMessage(),
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Pomocna metoda za dobivanje sifre iz selektiranog itema u JComboBox-u
    private String getSelectedSifra(JComboBox<String> comboBox) {
        String selectedItem = (String) comboBox.getSelectedItem();
        if (selectedItem != null) {
            // Uzimamo samo prvi dio stringa do prvog razmaka (siifra je prije razmaka)
            return selectedItem.split("\\s+")[0];
        }
        return null;
    }
}
