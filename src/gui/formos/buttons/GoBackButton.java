package gui.formos.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoBackButton extends JPanel {
    private JButton goBackButton;

    public GoBackButton(){
        goBackButton = new JButton();
        goBackButton.setText("Grįžti atgal");
        goBackButton.addActionListener(new GoBackAction());
    }

    public void putButton(int x, int y){

    }

    class GoBackAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
