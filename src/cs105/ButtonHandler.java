package cs105;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
    private int row;
    private int col;
    private MineGrid mineGrid;

    public ButtonHandler(int row, int col, MineGrid mineGrid) {
        this.row = row;
        this.col = col;
        this.mineGrid = mineGrid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.mineGrid.isMine(this.row,this.col)) {
            JOptionPane.showMessageDialog(null,"Game Over!");
            System.exit(0);
        } else {
            if (e.getSource() instanceof JButton) {
                JButton button = (JButton)e.getSource();
                button.setText(String.valueOf(this.mineGrid.getCellContent(this.row,this.col)));
            }
        }
    }


}
