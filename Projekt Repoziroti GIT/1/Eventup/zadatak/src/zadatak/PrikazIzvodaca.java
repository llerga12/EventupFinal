package zadatak;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrikazIzvodaca extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

    public PrikazIzvodaca() {
        setTitle("Prikaz Izvodaca");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        popuniTabelu();
    }

    private void popuniTabelu() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://ucka.veleri.hr/llerga?" +
                    "user=llerga&password=11");

            String sql = "SELECT * FROM Izvodac";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"Sifra izvodaca", "Ime izvodaca", "Prezime_izvodaca", "UmjetnickoIme_izvodaca", "Kontakt_izvodaca"}, 0);

            while (rs.next()) {
                String sifraIzvodaca = rs.getString("Sifra_izvodaca");
                String imeIzvodaca = rs.getString("Ime_Izvodaca");
                String prezimeIzvodaca = rs.getString("Prezime_izvodaca");
                String umjetnickoImeIzvodaca = rs.getString("UmjetnickoIme_izvodaca");
                String kontaktIzvodaca = rs.getString("Kontakt_izvodaca");
                model.addRow(new Object[]{sifraIzvodaca, imeIzvodaca, prezimeIzvodaca, umjetnickoImeIzvodaca, kontaktIzvodaca});
            }

            table.setModel(model);
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Greska prilikom dohvata podataka: " + ex.getMessage(),
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
}
