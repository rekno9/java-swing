package gui.formos.frame;

import gui.formos.paneles.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame
{
    private JFrame mainFrame;

    private LoginPanele loginPanele;
    private MeniuPanele meniuPanele;
    private PridetiUzsakymaPanel pridetiUzsakymaPanel;
    private PridetiVartotojaPanele pridetiVartotojaPanele;
    private PridetiVairuotojaPanel pridetiVairuotojaPanel;


    public MainFrame()
    {
        mainFrame = new JFrame();
        loginPanele = new LoginPanele();
        meniuPanele = new MeniuPanele();
        pridetiUzsakymaPanel = new PridetiUzsakymaPanel();
        pridetiVartotojaPanele = new PridetiVartotojaPanele();
        pridetiVairuotojaPanel = new PridetiVairuotojaPanel();



        loginPanele.setMainFrame(mainFrame);
        loginPanele.setMeniuPanele(meniuPanele);
        loginPanele.nustatytiPanele();

        meniuPanele.setMainFrame(mainFrame);
        meniuPanele.setPridetiUzsakymaPanel(pridetiUzsakymaPanel);
        meniuPanele.setPridetiVairuotojaPanel(pridetiVairuotojaPanel);
        meniuPanele.setPridetiVartotojaPanele(pridetiVartotojaPanele);
        meniuPanele.nustatytiPanele();

        pridetiUzsakymaPanel.setMainFrame(mainFrame);
        pridetiUzsakymaPanel.setMeniuPanele(meniuPanele);
        pridetiUzsakymaPanel.nustatytiPanel();

        pridetiVairuotojaPanel.setMainFrame(mainFrame);
        pridetiVairuotojaPanel.setMeniuPanele(meniuPanele);
        pridetiVairuotojaPanel.nustatytiPanele();

        pridetiVartotojaPanele.setMainFrame(mainFrame);
        pridetiVartotojaPanele.nustatytiPanele();


        //pagrindinis - loginPanele
        //mainFrame.add(loginPanele);

        //--------testuojamos Panels
        mainFrame.add(meniuPanele);


        mainFrame.setSize(new Dimension(500, 500));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setTitle("Logistikos imones programa");
        mainFrame.setVisible(true);
    }


    public static void main(String[] args)
    {
        new MainFrame();
    }
}