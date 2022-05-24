package cs105;

import javax.swing.*;
import java.awt.*;

public class MineSweeperGUI extends JPanel {
    public MineSweeperGUI(int numRows, int numCols, int numMines) {
        setLayout(new GridLayout(numRows, numCols));
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                JButton button = new JButton();
                add(button);
            }
        }
    }
}
