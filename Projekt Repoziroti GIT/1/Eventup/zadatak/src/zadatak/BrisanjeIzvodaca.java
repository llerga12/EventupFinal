package zadatak;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BrisanjeIzvodaca extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BrisanjeIzvodaca frame = new BrisanjeIzvodaca();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BrisanjeIzvodaca() {
        setTitle("Brisanje Izvođača");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        comboBox = new JComboBox<>();
        comboBox.setBounds(50, 50, 300, 30);
        contentPane.add(comboBox);
        
        JButton btnObrisi = new JButton("Obrisi");
        btnObrisi.setBounds(50, 100, 100, 30);
        contentPane.add(btnObrisi);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 100, 100, 30);
        contentPane.add(btnCancel);
        
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnObrisi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                if (selected != null) {
                    String[] parts = selected.split("-");
                    String sifraIzvodaca = parts[0].trim();
                    
                    try {
                        Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://ucka.veleri.hr/llerga?user=llerga&password=11");

                        String sql = "DELETE FROM Izvodac WHERE Sifra_izvodaca = ?";
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, sifraIzvodaca);

                        stmt.executeUpdate();
                        conn.close();

                        JOptionPane.showMessageDialog(null, "Izvođač je uspješno obrisan.");
                        comboBox.removeItem(selected);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Greška prilikom brisanja izvođača: " + ex.getMessage(),
                                "Greška", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        loadIzvodaci();
    }

    private void loadIzvodaci() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://ucka.veleri.hr/llerga?user=llerga&password=11");

            String sql = "SELECT Sifra_izvodaca, Ime_izvodaca FROM Izvodac";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String sifra = rs.getString("Sifra_izvodaca");
                String ime = rs.getString("Ime_izvodaca");
                comboBox.addItem(sifra + " - " + ime);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
