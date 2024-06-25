package zadatak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PrikazOrganizatora extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PrikazOrganizatora frame = new PrikazOrganizatora();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PrikazOrganizatora() {
        setTitle("Prikaz Organizatora");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);

       
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Sifra Organizatora");
        model.addColumn("Naziv Organizatora");
        model.addColumn("Kontakt Organizatora");
        model.addColumn("Lokacija Organizatora");
        table.setModel(model);


        loadData(model);
    }

    private void loadData(DefaultTableModel model) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://ucka.veleri.hr/llerga?user=llerga&password=11");

            String sql = "SELECT Sifra_organizatora, Naziv_organizatora, Kontakt_organizatora, Lokacija_organizatora FROM Organizator";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String sifra = rs.getString("Sifra_organizatora");
                String naziv = rs.getString("Naziv_organizatora");
                String kontakt = rs.getString("Kontakt_organizatora");
                String lokacija = rs.getString("Lokacija_organizatora");
                model.addRow(new Object[]{sifra, naziv, kontakt, lokacija});
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
