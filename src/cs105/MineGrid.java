package cs105;

import java.util.Random;

public class MineGrid {
    private static final int MINE = -1;
    private int[][] mineInformation;

    public MineGrid(int numberOfRows, int numberOfColumns, int numberOfMines) {
        this.mineInformation = new int[numberOfRows][numberOfColumns];
        this.initializeCells();
        this.placeMines(numberOfMines);
    }

    private void initializeCells() {
        for (int i = 0; i < this.mineInformation.length; ++i) {
            for (int j = 0; j < this.mineInformation.length; ++j) {
                this.mineInformation[i][j] = 0;
            }
        }
    }

    private void placeMines(int numberOfMines) {
        Random random = new Random();
        for (int i = 0; i < numberOfMines; ++i) {
            int row = random.nextInt(this.mineInformation.length);
            int col = random.nextInt(this.mineInformation[0].length);
            if (this.mineInformation[row][col] != MineGrid.MINE) {
                this.mineInformation[row][col] = MineGrid.MINE;
            } else {
                --i;
            }
        }
    }

    private void setMineInformation() {
        for (int i = 0; i < this.mineInformation.length; ++i) {
            for (int j = 0; j < this.mineInformation.length; ++j) {
                if (this.mineInformation[i][j] == MineGrid.MINE) {
                    this.incrementMineCountAt(i-1,j-1);
                    this.incrementMineCountAt(i-1,j);
                    this.incrementMineCountAt(i-1,j+1);
                    this.incrementMineCountAt(i,j-1);
                    this.incrementMineCountAt(i,j+1);
                    this.incrementMineCountAt(i+1,j-1);
                    this.incrementMineCountAt(i+1,j);
                    this.incrementMineCountAt(i+1,j+1);
                }
            }
        }
    }

    private void incrementMineCountAt(int rowIndex, int colIndex) {
        if ((this.isInsideGrid(rowIndex,colIndex)) && !this.isMine(rowIndex, colIndex)) {
            ++this.mineInformation[rowIndex][colIndex];
        }
    }

    private boolean isInsideGrid(int i, int j) {
        return (i >= 0 && i < this.mineInformation.length) && (j >= 0 && j < this.mineInformation[0].length);
    }

    private boolean isMine(int i, int j) {
        return this.mineInformation[i][j] == MineGrid.MINE;
    }
}
