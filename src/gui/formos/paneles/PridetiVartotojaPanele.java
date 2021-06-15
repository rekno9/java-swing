package gui.formos.paneles;

import javax.swing.*;
import java.awt.*;

public class PridetiVartotojaPanele extends JPanel {
    private JLabel newLoginLabel;
    private JTextField newLoginText;
    private JLabel newPswLabel;
    private JTextField newPswText;
    private JButton createUserButton;

    private JFrame mainFrame;

    public PridetiVartotojaPanele(){
        newLoginLabel = new JLabel();
        newLoginText = new JTextField();
        newPswLabel = new JLabel();
        newPswText = new JPasswordField();
        createUserButton = new JButton();
    }

    public void nustatytiPanele(){
        newLoginLabel.setText("Ivesti vartotojo varda");
        newPswLabel.setText("Ivesti vartotojo slaptazodi");
        createUserButton.setText("Sukurti vartotoja");

        this.setLayout(new GridLayout(3,1,10,10));
        this.add(newLoginLabel);
        this.add(newLoginText);
        this.add(newPswLabel);
        this.add(newPswText);
        this.add(createUserButton);
    }




    public void setMainFrame(JFrame mainFrame){
        this.mainFrame = mainFrame;
    }


}


