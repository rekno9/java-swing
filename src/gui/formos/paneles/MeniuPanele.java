package gui.formos.paneles;

import gui.formos.PakeistiLanga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeniuPanele extends JPanel
{
    //Labels for buttons
    private JLabel reisasLabel;
    private JLabel vairuotojaiLabel;
    private JLabel transportoLabel;
    private JLabel paskirstytGrafikaLabel;

    //Buttons
    private JButton pridetiReisaButton;
    private JButton redaguotiReisaButton;
    private JButton pridetiVairuotojaButton;
    private JButton redaguotiVairuotojaButton;
    private JButton pridetiTransPriemButton;
    private JButton redaguotTransPriemButton;
    private JButton paskirstytGrafikusButton;

    // reference/adresas i main frame objekta, kuris yra main programos dalyje
    private JFrame mainFrame;
    //referance prideti/redaguoti uzsakyma
    private PridetiUzsakymaPanel pridetiUzsakymaPanel;
    //prideti vairuotoja
    private PridetiVairuotojaPanel pridetiVairuotojaPanel;
    // reference/adresas i pridetiVartotoja panele, kuria iskvies paspaudus mygtuka (jei duomenys yra teisingai ivesti)
    private PridetiVartotojaPanele pridetiVartotojaPanele;
    //referance prideti/redaguoti transporto piremones
    private PridetiTransPriemPanel pridetiTransPriemPanel;
    //reisu grafiko redagavimo mygtukas/meniu kazkas bus


    public MeniuPanele()
    {
        reisasLabel = new JLabel();
        vairuotojaiLabel = new JLabel();
        transportoLabel = new JLabel();
        paskirstytGrafikaLabel = new JLabel();

        pridetiReisaButton = new JButton();
        redaguotiReisaButton = new JButton();
        pridetiVairuotojaButton = new JButton();
        redaguotiVairuotojaButton = new JButton();
        pridetiTransPriemButton = new JButton();
        redaguotTransPriemButton = new JButton();
        paskirstytGrafikusButton = new JButton();
    }


    public void nustatytiPanele()
    {
        //Labels ir buttons su ActionListener reisam redaguoti
        reisasLabel.setText("Užsakymų meniu");
        pridetiReisaButton.setText("Pridėti naują");
        redaguotiReisaButton.setText("Redaguoti esamą");
        pridetiReisaButton.addActionListener(new PridetiReisaListener());
        redaguotiReisaButton.addActionListener(new RedaguotiReisaListener());

        //Labels ir buttons vairuotojams redaguoti
        vairuotojaiLabel.setText("Vairuotojų meniu");
        pridetiVairuotojaButton.setText("Pridėti naują");
        redaguotiVairuotojaButton.setText("Redaguoti esamą");
        pridetiVairuotojaButton.addActionListener(new PridetiVairuotojaListener());
        redaguotiVairuotojaButton.addActionListener(new RedaguotiVairuotojaListener());

        //
        transportoLabel.setText("Tranporto meniu");
        pridetiTransPriemButton.setText("Prideti naują");
        redaguotTransPriemButton.setText("Redaguoti esamą");
        pridetiTransPriemButton.addActionListener(new PridetiTransPriemListener());
        redaguotTransPriemButton.addActionListener(new RedaguotTransPriemListener());

        //
        paskirstytGrafikaLabel.setText("Raiso grafikų paskirstymas");
        paskirstytGrafikusButton.setText("Reisai");
        paskirstytGrafikusButton.addActionListener(new PaskirstytGrafikusListener());

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Insets bottom20 = new Insets(0, 0, 20, 0);
        Insets resetInsets = new Insets(0,0,0,0);
        Dimension dimensionLabel = new Dimension(150,30);
        Dimension dimensionButton = new Dimension(150,33);

        //---------------LAYOUT parametrai
        //label LAYOUT
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = resetInsets;
        reisasLabel.setPreferredSize(dimensionLabel);
        this.add(reisasLabel, c);
        //Reiso buttons LAYOUT
        //prideti nauja
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = bottom20;
        pridetiReisaButton.setPreferredSize(dimensionButton);
        this.add(pridetiReisaButton, c);
        //redaguoti esama
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = bottom20;
        redaguotiReisaButton.setPreferredSize(dimensionButton);
        this.add(redaguotiReisaButton, c);

        //Vairuotoju layoutas
        //label
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = resetInsets;
        vairuotojaiLabel.setPreferredSize(dimensionLabel);
        this.add(vairuotojaiLabel, c);
        //prideti nauja
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = bottom20;
        pridetiVairuotojaButton.setPreferredSize(dimensionButton);
        this.add(pridetiVairuotojaButton, c);
        //redaguoti esama
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = bottom20;
        redaguotiVairuotojaButton.setPreferredSize(dimensionButton);
        this.add(redaguotiVairuotojaButton, c);

        //Transporto priemoniu layoutas
        //label
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = resetInsets;
        transportoLabel.setPreferredSize(dimensionLabel);
        this.add(transportoLabel, c);
        //prideti transporto priemone
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = bottom20;
        pridetiTransPriemButton.setPreferredSize(dimensionButton);
        this.add(pridetiTransPriemButton, c);
        //redaguoti esama transporto priemone
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = bottom20;
        redaguotTransPriemButton.setPreferredSize(dimensionButton);
        this.add(redaguotTransPriemButton, c);

        //grafiko meniu
        //grafiko label
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.insets = resetInsets;
        paskirstytGrafikaLabel.setPreferredSize(dimensionLabel);
        this.add(paskirstytGrafikaLabel, c);
        //paskirtyti grafika button
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.insets = bottom20;
        paskirstytGrafikusButton.setPreferredSize(dimensionButton);
        this.add(paskirstytGrafikusButton, c);




        //prideti visus komponentus
//        this.add(reisasLabel);
//        this.add(pridetiReisaButton);
//        this.add(redaguotiReisaButton);
//        this.add(vairuotojaiLabel);
//        this.add(pridetiVairuotojaButton);
//        this.add(redaguotiVairuotojaButton);
//        this.add(transportoLabel);
//        this.add(pridetiTransPriemButton);
//        this.add(redaguotTransPriemButton);
//        this.add(paskirstytGrafikaLabel);
//        this.add(paskirstytGrafikusButton);
    }

    class PridetiReisaListener implements ActionListener{

        PridetiReisaListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Pereiname i prideti uzsakyma panel'e");
            PakeistiLanga.Patvirtinimas(mainFrame, pridetiUzsakymaPanel);
        }
    }

    class RedaguotiReisaListener implements ActionListener{
        RedaguotiReisaListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class PridetiVairuotojaListener implements ActionListener{
        PridetiVairuotojaListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Pereiname i prideto vairuotja panele");
            PakeistiLanga.Patvirtinimas(mainFrame, pridetiVairuotojaPanel);
        }
    }

    class RedaguotiVairuotojaListener implements ActionListener{
        RedaguotiVairuotojaListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class PridetiTransPriemListener implements ActionListener{
        PridetiTransPriemListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class RedaguotTransPriemListener implements ActionListener{
        RedaguotTransPriemListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class PaskirstytGrafikusListener implements ActionListener{
        PaskirstytGrafikusListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    //---------getters setter
    public void setMainFrame(JFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void setPridetiUzsakymaPanel(PridetiUzsakymaPanel pridetiUzsakymaPanel){
        this.pridetiUzsakymaPanel = pridetiUzsakymaPanel;
    }

    public void setPridetiVartotojaPanele(PridetiVartotojaPanele pridetiVartotojaPanele){
        this.pridetiVartotojaPanele = pridetiVartotojaPanele;
    }

    public void setPridetiVairuotojaPanel(PridetiVairuotojaPanel pridetiVairuotojaPanel){
        this.pridetiVairuotojaPanel = pridetiVairuotojaPanel;
    }
}

