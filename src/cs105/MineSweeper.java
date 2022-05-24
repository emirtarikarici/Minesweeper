package cs105;

import javax.swing.*;

public class MineSweeper {

    private static final int NUMBER_OF_MINES = 100;
    private static final int SIZE = 20;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Minesweeper | # number of mines: " + NUMBER_OF_MINES);
        frame.add(new MineSweeperGUI(SIZE, SIZE, NUMBER_OF_MINES));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setVisible(true);

    }
}
