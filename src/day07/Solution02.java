package day07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution02 {
    private boolean flag = false;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        boolean[][] check = new boolean[board.length][board[0].length];
        for (String word : words) {
            flag = false;
            if (word.length() == 0) {
                res.add(word);
                continue;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        check[i][j] = true;
                        dfs(res, board, i, j, check, word, 1);
                        check[i][j] = false;
                    }
                }
            }
        }
        return new ArrayList<>(new HashSet<>(res));
    }

    public void dfs(List<String> res, char[][] board, int y, int x, boolean[][] check, String word, int index) {
        if (index == word.length()) {
            res.add(word);
            flag = true;
            return;
        }
        if (flag) return;
        if (y - 1 >= 0 && !check[y - 1][x] && board[y - 1][x] == word.charAt(index)) {
            check[y - 1][x] = true;
            dfs(res, board, y - 1, x, check, word, index + 1);
            check[y - 1][x] = false;
        }
        if (flag) return;
        if (x - 1 >= 0 && !check[y][x - 1] && board[y][x - 1] == word.charAt(index)) {
            check[y][x - 1] = true;
            dfs(res, board, y, x - 1, check, word, index + 1);
            check[y][x - 1] = false;
        }
        if (flag) return;
        if (y + 1 < board.length && !check[y + 1][x] && board[y + 1][x] == word.charAt(index)) {
            check[y + 1][x] = true;
            dfs(res, board, y + 1, x, check, word, index + 1);
            check[y + 1][x] = false;
        }
        if (flag) return;
        if (x + 1 < board[0].length && !check[y][x + 1] && board[y][x + 1] == word.charAt(index)) {
            check[y][x + 1] = true;
            dfs(res, board, y, x + 1, check, word, index + 1);
            check[y][x + 1] = false;
        }
        if (flag) return;
    }
}
