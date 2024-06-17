package zadatak;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Organizator extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldSifra;
    private JTextField textFieldNaziv;
    private JTextField textFieldKontakt;
    private JTextField textFieldLokacija;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Organizator frame = new Organizator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Organizator() {
        setTitle("Organizator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblSifra = new JLabel("Sifra Organizatora");
        lblSifra.setBounds(37, 41, 120, 14);
        contentPane.add(lblSifra);
        
        JLabel lblNaziv = new JLabel("Naziv Organizatora");
        lblNaziv.setBounds(37, 86, 120, 14);
        contentPane.add(lblNaziv);
        
        JLabel lblKontakt = new JLabel("Kontakt Organizatora");
        lblKontakt.setBounds(37, 131, 120, 14);
        contentPane.add(lblKontakt);
        
        JLabel lblLokacija = new JLabel("Lokacija Organizatora");
        lblLokacija.setBounds(37, 176, 120, 14);
        contentPane.add(lblLokacija);
        
        textFieldSifra = new JTextField();
        textFieldSifra.setBounds(167, 38, 213, 20);
        contentPane.add(textFieldSifra);
        textFieldSifra.setColumns(10);
        
        textFieldNaziv = new JTextField();
        textFieldNaziv.setColumns(10);
        textFieldNaziv.setBounds(167, 83, 213, 20);
        contentPane.add(textFieldNaziv);
        
        textFieldKontakt = new JTextField();
        textFieldKontakt.setColumns(10);
        textFieldKontakt.setBounds(167, 128, 213, 20);
        contentPane.add(textFieldKontakt);
        
        textFieldLokacija = new JTextField();
        textFieldLokacija.setColumns(10);
        textFieldLokacija.setBounds(167, 173, 213, 20);
        contentPane.add(textFieldLokacija);
        
        JButton btnUnesi = new JButton("Unesi");
        btnUnesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sifra = textFieldSifra.getText();
                String naziv = textFieldNaziv.getText();
                String kontakt = textFieldKontakt.getText();
                String lokacija = textFieldLokacija.getText();
                
                try {
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://ucka.veleri.hr/llerga?" +
                            "user=llerga&password=11");
    
                    String sql = "INSERT INTO Organizator (Sifra_organizatora, Naziv_organizatora, Kontakt_organizatora, Lokacija_organizatora) "
                            + "VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, sifra);
                    stmt.setString(2, naziv);
                    stmt.setString(3, kontakt);
                    stmt.setString(4, lokacija);
    
                    stmt.executeUpdate();
    
                    conn.close();
    
                    textFieldSifra.setText("");
                    textFieldNaziv.setText("");
                    textFieldKontakt.setText("");
                    textFieldLokacija.setText("");
    
                    JOptionPane.showMessageDialog(null, "Podaci su uspješno uneseni.");
    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Greška prilikom unosa podataka: " + ex.getMessage(),
                            "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUnesi.setBounds(210, 227, 80, 23);
        contentPane.add(btnUnesi);
        
        // Dodavanje Cancel dugmeta
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Zatvara trenutni JFrame
            }
        });
        btnCancel.setBounds(300, 227, 80, 23);
        contentPane.add(btnCancel);
    }
}
