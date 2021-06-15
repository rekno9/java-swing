package gui.formos.paneles;

import db.entities.Vartotojas;
import db.veiksmai.DuombazesVeiksmai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginPanele extends JPanel
{
    private JButton loginButton;
    private JTextField loginText;
    private JLabel loginLabel;
    private JPasswordField pswText;
    private JLabel pswLabel;

    private JFrame mainFrame;               // reference/adresas i main frame objekta, kuris yra main programos dalyje
    private MeniuPanele meniuPanele;             // reference/adresas i meniu panele, kuria iskvies paspaudus mygtuka (jei duomenys yra teisingai ivesti)

    public LoginPanele()
    {
        loginButton = new JButton();
        loginText = new JTextField();
        loginLabel = new JLabel();
        pswText = new JPasswordField();
        pswLabel = new JLabel();
    }


    public void nustatytiPanele()
    {
        // Mygtuko parametrai
        loginButton.setText("Prisijungti");
        loginButton.setFont(new Font("Serif", Font.BOLD, 36));
        loginButton.addActionListener(new LoginButtonListener());


        // Login labelio parmaetrai
        loginLabel.setText("Įveskite savo prisijungimo vardą:");

        // Slaptažodžio labelio parametrai
        pswLabel.setText("Įveskite savo slaptažodį:");

        // Paneles nustatymai
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();



        //------------------Layout parametrai--------------
        // Login labelio LAYOUT parametrai
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        loginLabel.setPreferredSize(new Dimension(100, 30));
        this.add(loginLabel, c);

        // Login texto LAYOUT parametrai
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 20, 0);
        loginText.setPreferredSize(new Dimension(100, 30));
        this.add(loginText, c);


        // Psw labelio LAYOUT parametrai
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        pswLabel.setPreferredSize(new Dimension(100, 30));
        this.add(pswLabel, c);


        // Psw teksto LAYOUT parametrai
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 20, 0);
        pswText.setPreferredSize(new Dimension(100,30));
        this.add(pswText, c);


        // Mygtuko LAYOUT parametrai
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        loginButton.setPreferredSize(new Dimension(200, 50));
        this.add(loginButton, c);







        // Komponentu sudejimas i panele
        //   this.add(loginLabel);
        //   this.add(loginText);
        //   this.add(pswLabel);
        //   this.add(pswText);
        //   this.add(loginButton);
    }

    class LoginButtonListener implements ActionListener
    {
        private int arTinkaVart;         // ar tinka ivestas vartotojas paspaudus mygtuka
        public LoginButtonListener() {}

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String login = loginText.getText();
            char[] pswChar = pswText.getPassword();
            String psw = String.valueOf(pswChar);

            Vartotojas ivestasVart = new Vartotojas(login, psw);
            arTinkaVart = 0;
            try
            {
                Connection jungtis = DuombazesVeiksmai.sukurtiDuombaze();
                arTinkaVart = DuombazesVeiksmai.palygintiVartDuomenis(jungtis, ivestasVart);

                if (arTinkaVart == 1)
                {
                    mainFrame.getContentPane().removeAll();
                    mainFrame.repaint();

                    //Dviguba deklaracija viena yra MainFrame klasej
                    //meniuPanele.nustatytiPanele();

                    //mainFrame.getContentPane().add(meniuPanele);
                    mainFrame.add(meniuPanele);
                    mainFrame.repaint();
                    mainFrame.printAll(mainFrame.getGraphics());
                }
            }
            catch (SQLException exc)
            {
                exc.printStackTrace();
                System.out.println("Nepavyko prisijungti prie DB");
            }
        }
    }



    //----------------Getteriai setteriai


    public void setMainFrame(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }

    public void setMeniuPanele(MeniuPanele meniuPanele)
    {
        this.meniuPanele = meniuPanele;
    }
}