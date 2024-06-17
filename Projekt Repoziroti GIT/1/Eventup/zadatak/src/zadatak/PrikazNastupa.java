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

public class PrikazNastupa extends JDialog {

    private JTable table;

    public PrikazNastupa() {
        setTitle("Prikaz Nastupa");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 584, 338);
        getContentPane().add(scrollPane);

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(10, 338, 574, 23);
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                popuniTabelu();
            }
        });
        getContentPane().add(btnRefresh);

        popuniTabelu();
    }

    private void popuniTabelu() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://ucka.veleri.hr/llerga?" +
                    "user=llerga&password=11");

            String sql = "SELECT * FROM Nastup";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"Sifra nastupa", "Datum nastupa", "Mjesto nastupa", "Sifra izvodaca"}, 0);

            while (rs.next()) {
                String sifraNastupa = rs.getString("Sifra_nastupa");
                String datumNastupa = rs.getString("Datum_nastupa");
                String mjestoNastupa = rs.getString("Mjesto_nastupa");
                String sifraIzvodaca = rs.getString("Sifra_izvodaca");
                model.addRow(new Object[]{sifraNastupa, datumNastupa, mjestoNastupa, sifraIzvodaca});
            }

            table.setModel(model);
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Greska prilikom dohvata podataka: " + ex.getMessage(),
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
}
