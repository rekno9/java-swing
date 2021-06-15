package gui.formos;

import javax.swing.*;

public class PakeistiLanga {
    private JFrame jframe;
    private JPanel jpanel;

    /**
     *
     * @param jframe - main frame
     * @param jpanel - persokti is esamo lango i nurodyta langa
     */
    public static void Patvirtinimas(JFrame jframe, JPanel jpanel){
        jframe.getContentPane().removeAll();
        jframe.repaint();
        jframe.add(jpanel);
        jframe.repaint();
        jframe.printAll(jframe.getGraphics());
    }
}
