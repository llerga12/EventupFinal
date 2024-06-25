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

public class BrisanjeOrganizatora extends JFrame {

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
                    BrisanjeOrganizatora frame = new BrisanjeOrganizatora();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BrisanjeOrganizatora() {
        setTitle("Brisanje Organizatora");
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
                    String sifraOrganizatora = parts[0].trim();
                    
                    try {
                        Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://ucka.veleri.hr/llerga?user=llerga&password=11");

                        String sql = "DELETE FROM Organizator WHERE Sifra_organizatora = ?";
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, sifraOrganizatora);

                        stmt.executeUpdate();
                        conn.close();

                        JOptionPane.showMessageDialog(null, "Organizator je uspješno obrisan.");
                        comboBox.removeItem(selected);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Greška prilikom brisanja organizatora: " + ex.getMessage(),
                                "Greška", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        loadOrganizatori();
    }

    private void loadOrganizatori() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://ucka.veleri.hr/llerga?user=llerga&password=11");

            String sql = "SELECT Sifra_organizatora, Naziv_organizatora FROM Organizator";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String sifra = rs.getString("Sifra_organizatora");
                String naziv = rs.getString("Naziv_organizatora");
                comboBox.addItem(sifra + " - " + naziv);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
