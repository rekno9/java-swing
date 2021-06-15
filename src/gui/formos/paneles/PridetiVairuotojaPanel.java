package gui.formos.paneles;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class PridetiVairuotojaPanel extends JPanel {
    //Labels
    private JLabel vardasLabel;
    private JLabel pavardeLabel;
    private JLabel algaLabel;
    private JLabel pamainosLabel;

    //TextFields
    private JTextField vardasText;
    private JTextField pavardeText;
    private JFormattedTextField algaText;
    private JFormattedTextField pamainaText;//Gal naudoti JComboBox

    //Patvirtinti
    private JButton patvirtintiButton;

    private JFrame mainFrame;
    private MeniuPanele meniuPanele;

    public PridetiVairuotojaPanel(){
        vardasLabel = new JLabel();
        pavardeLabel = new JLabel();
        algaLabel = new JLabel();
        pamainosLabel = new JLabel();

        vardasText = new JTextField();
        pavardeText = new JTextField();
        algaText = new JFormattedTextField();
        pamainaText = new JFormattedTextField();

        patvirtintiButton = new JButton();
    }

    public void nustatytiPanele(){
        vardasLabel.setText("Iveskite darbuotoja varda");
        pavardeLabel.setText("Iveskite darbuotojo pavarde");
        algaLabel.setText("Iveskite darbuotojo alga, o kam?");
        pamainosLabel.setText("Iveskite pamaina, bet kolkas nereikia nes ner ka su ja daryti");

        patvirtintiButton.setText("Patvirtinti");

        this.setLayout(new GridLayout(5,2,10,10));
        this.add(vardasLabel);
        this.add(pavardeLabel);
        this.add(algaLabel);
        this.add(pamainosLabel);
        this.add(patvirtintiButton);
    }

    public void setMainFrame(JFrame mainFrame){this.mainFrame = mainFrame;}

    public void setMeniuPanele(MeniuPanele meniuPanele){this.meniuPanele = meniuPanele;}
}
