package gui.formos.paneles;

import db.veiksmai.DuombazesVeiksmai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class PridetiUzsakymaPanel extends JPanel{
    //Labels
    private JLabel imonesPavLabel;
    private JLabel uzsakymoDataLabel;
    private JLabel uzsakymoAprasasLabel;

    //Text
    private JTextField imonesPavField;
    private JTextArea uzsakymoAprasymasArea;

    //Numbers for date
    private JFormattedTextField dateField;

    //button
    private JButton patvirtintiButton;

    //refferances
    private JFrame mainFrame;
    private MeniuPanele meniuPanele;

    public PridetiUzsakymaPanel(){
        imonesPavLabel = new JLabel();
        uzsakymoDataLabel = new JLabel();
        uzsakymoAprasasLabel = new JLabel();

        imonesPavField = new JTextField();
        uzsakymoAprasymasArea = new JTextArea();

        dateField = new JFormattedTextField();
        dateField.setValue(new Date());

        patvirtintiButton = new JButton();
    }

    public void nustatytiPanel(){
        imonesPavLabel.setText("Iveskite imones pavadinima");
        uzsakymoDataLabel.setText("Iveskite uzsakymo data");
        uzsakymoAprasasLabel.setText("Iveskite uzsakymo aprasyma");
        patvirtintiButton.setText("Patvirtinti");
        patvirtintiButton.addActionListener(new PridetiUzsakymaListener());


        this.setLayout(new GridLayout(4,2,10,10));
        this.add(imonesPavLabel);
        this.add(imonesPavField);//ivedamas tekstas
        this.add(uzsakymoDataLabel);
        this.add(dateField);//ivedama data
        this.add(uzsakymoAprasasLabel);
        this.add(uzsakymoAprasymasArea);//ivedamas aprasymas
        this.add(patvirtintiButton);//patvirtinam ir siunciam toliau arba atgal i meniu panele
    }

    class PridetiUzsakymaListener implements ActionListener{
        PridetiUzsakymaListener(){};

        @Override
        public void actionPerformed(ActionEvent e) {
            String imonesPav = imonesPavField.getText();
            String uzsakymoData = dateField.getText();
            String uzsakymoAprasymas = uzsakymoAprasymasArea.getText();

            int ivedemIrasa = 0;
            try{
                Connection jungtis = DuombazesVeiksmai.sukurtiDuombaze();
                ivedemIrasa = DuombazesVeiksmai.PridetiUzsakyma(jungtis, imonesPav, uzsakymoData, uzsakymoAprasymas);
                if(ivedemIrasa == 1){
                    System.out.println("gristame is prideti uzsakyma i meniu panele");
                    mainFrame.getContentPane().removeAll();
                    mainFrame.repaint();

                    mainFrame.add(meniuPanele);
                    mainFrame.repaint();
                    mainFrame.printAll(mainFrame.getGraphics());
                }
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void setMainFrame(JFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void setMeniuPanele(MeniuPanele meniuPanele){
        this.meniuPanele = meniuPanele;
    }
}
