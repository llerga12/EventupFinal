package zadatak;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

    private JFrame frmEventup;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GlavniProzor window = new GlavniProzor();
                    window.frmEventup.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GlavniProzor() {
        initialize();
    }

    private void initialize() {
        frmEventup = new JFrame();
        frmEventup.setTitle("EVENT-UP");
        frmEventup.setBounds(100, 100, 590, 281); 
        frmEventup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnOrganizator = new JButton("Organizator");
        btnOrganizator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Organizator dialog = new Organizator();
                dialog.setVisible(true);
            }
        });
        btnOrganizator.setBounds(28, 125, 140, 37);
        frmEventup.getContentPane().setLayout(null);
        frmEventup.getContentPane().add(btnOrganizator);
        
        JButton btnIzvodac = new JButton("Izvodac");
        btnIzvodac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DlgIzvodaci dialog = new DlgIzvodaci();
                dialog.setVisible(true);
            }
        });
        btnIzvodac.setBounds(28, 29, 140, 37);
        frmEventup.getContentPane().add(btnIzvodac);
        
        JButton btnNastup = new JButton("Nastup");
        btnNastup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Nastup dialog = new Nastup();
                dialog.setVisible(true);
            }
        });
        btnNastup.setBounds(28, 77, 140, 37);
        frmEventup.getContentPane().add(btnNastup);

        JButton btnPrikazNastupa = new JButton("Prikaz Nastupa");
        btnPrikazNastupa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrikazNastupa dialog = new PrikazNastupa();
                dialog.setVisible(true);
            }
        });
        btnPrikazNastupa.setBounds(194, 77, 140, 37);
        frmEventup.getContentPane().add(btnPrikazNastupa);

        JButton btnPrikazIzvodaca = new JButton("Prikaz Izvodaca");
        btnPrikazIzvodaca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrikazIzvodaca dialog = new PrikazIzvodaca();
                dialog.setVisible(true);
            }
        });
        btnPrikazIzvodaca.setBounds(194, 29, 140, 37);
        frmEventup.getContentPane().add(btnPrikazIzvodaca);

        JButton btnPrikazOrganizatora = new JButton("Prikaz Organizatora");
        btnPrikazOrganizatora.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrikazOrganizatora dialog = new PrikazOrganizatora();
                dialog.setVisible(true);
            }
        });
        btnPrikazOrganizatora.setBounds(194, 125, 140, 37);
        frmEventup.getContentPane().add(btnPrikazOrganizatora);

        JButton btnBrisanjeIzvodaca = new JButton("Brisanje Izvodaca");
        btnBrisanjeIzvodaca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BrisanjeIzvodaca dialog = new BrisanjeIzvodaca();
                dialog.setVisible(true);
            }
        });
        btnBrisanjeIzvodaca.setBounds(358, 29, 140, 37);
        frmEventup.getContentPane().add(btnBrisanjeIzvodaca);

        JButton btnBrisanjeOrganizatora = new JButton("Brisanje Organizatora");
        btnBrisanjeOrganizatora.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BrisanjeOrganizatora dialog = new BrisanjeOrganizatora();
                dialog.setVisible(true);
            }
        });
        btnBrisanjeOrganizatora.setBounds(358, 125, 140, 37);
        frmEventup.getContentPane().add(btnBrisanjeOrganizatora);
    }
}
