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
        frmEventup.setBounds(100, 100, 450, 300);
        frmEventup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnOrganizator = new JButton("Organizator");
        btnOrganizator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Organizator dialog = new Organizator();
                dialog.setVisible(true);
            }
        });
        btnOrganizator.setBounds(141, 130, 140, 37);
        frmEventup.getContentPane().setLayout(null);
        frmEventup.getContentPane().add(btnOrganizator);
        
        JButton btnIzvodac = new JButton("Izvodac");
        btnIzvodac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DlgIzvodaci dialog = new DlgIzvodaci();
                dialog.setVisible(true);
            }
        });
        btnIzvodac.setBounds(141, 34, 140, 37);
        frmEventup.getContentPane().add(btnIzvodac);
        
        JButton btnNastup = new JButton("Nastup");
        btnNastup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Nastup dialog = new Nastup();
                dialog.setVisible(true);
            }
        });
        btnNastup.setBounds(141, 82, 140, 37);
        frmEventup.getContentPane().add(btnNastup);

        JButton btnPrikazNastupa = new JButton("Prikaz Nastupa");
        btnPrikazNastupa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrikazNastupa dialog = new PrikazNastupa();
                dialog.setVisible(true);
            }
        });
        btnPrikazNastupa.setBounds(141, 180, 140, 37);
        frmEventup.getContentPane().add(btnPrikazNastupa);

        // Novo dugme za prikaz izvodaca
        JButton btnPrikazIzvodaca = new JButton("Prikaz Izvodaca");
        btnPrikazIzvodaca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrikazIzvodaca dialog = new PrikazIzvodaca();
                dialog.setVisible(true);
            }
        });
        btnPrikazIzvodaca.setBounds(141, 230, 140, 37);
        frmEventup.getContentPane().add(btnPrikazIzvodaca);
    }
}
