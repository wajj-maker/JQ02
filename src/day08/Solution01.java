package day08;

import java.util.ArrayList;
import java.util.List;

public class Solution01 {
    public List<String> findWords(char[][] board, String[] words) {
        //����һ���ֵ���
        TrieTree trieTree = new TrieTree();
        TrieTreeNode root = trieTree.root;
        //���ֵ��������������
        for (String word : words) {
            trieTree.insert(word);
        }
        //����𰸵ļ���
        List<String> res = new ArrayList<>();
        //�жϲ����ظ��ļ���
        boolean[][] check = new boolean[board.length][board[0].length];
        //�ҵ�����ƥ��ĵ���
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.child[board[i][j] - 'a'] != null) {
                    check[i][j] = true;
                    dfs(res, check, board, i, j, root.child[board[i][j] - 'a']);
                    check[i][j] = false;
                }
            }
        }
        return res;
    }

    public void dfs(List<String> res, boolean[][] check, char[][] board, int y, int x, TrieTreeNode node) {
        if (node.isEnd) {
            res.add(node.val);
            node.isEnd = false;
        }
        if (y - 1 >= 0 && !check[y - 1][x] && node.child[board[y - 1][x] - 'a'] != null) {
            check[y - 1][x] = true;
            dfs(res, check, board, y - 1, x, node.child[board[y - 1][x] - 'a']);
            check[y - 1][x] = false;
        }
        if (x - 1 >= 0 && !check[y][x - 1] && node.child[board[y][x - 1] - 'a'] != null) {
            check[y][x - 1] = true;
            dfs(res, check, board, y, x - 1, node.child[board[y][x - 1] - 'a']);
            check[y][x - 1] = false;
        }
        if (y + 1 <= board.length && !check[y + 1][x] && node.child[board[y + 1][x] - 'a'] != null) {
            check[y + 1][x] = true;
            dfs(res, check, board, y + 1, x, node.child[board[y + 1][x] - 'a']);
            check[y + 1][x] = false;
        }
        if (x + 1 <= board[0].length && !check[y][x + 1] && node.child[board[y][x + 1] - 'a'] != null) {
            check[y][x + 1] = true;
            dfs(res, check, board, y, x + 1, node.child[board[y][x + 1] - 'a']);
            check[y][x + 1] = false;
        }
    }

}

class TrieTree {
    TrieTreeNode root = new TrieTreeNode();
    //���ֵ�������ķ���
    public void insert(String word) {
        TrieTreeNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new TrieTreeNode();
            }
            node = node.child[c - 'a'];
        }
        node.isEnd = true;
        node.val = word;
    }
}

class TrieTreeNode {
    final int SIZE = 26;
    TrieTreeNode[] child;
    boolean isEnd;
    String val;
    public TrieTreeNode (){
        child = new TrieTreeNode[SIZE];
        isEnd = false;
    }
}
