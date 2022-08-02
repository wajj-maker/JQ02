package day12;

public class Solution01 {
    public void gameOfLife(int[][] board) {
        int[][] life = new int[board.length][board[0].length];
        int[] DX = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] DY = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int y = i;
                int x = j;
                int lif = 0;
                for (int k = 0; k < 8; k++) {
                    if (x + DX[k] < 0 || x + DX[k] >= board[0].length || y + DY[k] < 0 || y + DY[k] >= board.length) {
                        continue;
                    }
                    lif += board[y + DY[k]][x + DX[k]];
                }
                if (lif < 2) {
                    life[i][j] = 0;
                } else if (lif == 2) {
                    life[i][j] = board[i][j];
                } else if (lif == 3) {
                    life[i][j] = 1;
                } else {
                    life[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < life.length; i++) {
            for (int j = 0; j < life[0].length; j++) {
                board[i][j] = life[i][j];
            }
        }
    }
}
