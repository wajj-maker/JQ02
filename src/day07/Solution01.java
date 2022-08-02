package day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution01 {

}

class DictTreeNode {
    private static final int SIZE = 26;
    public boolean isWord = false;
    public DictTreeNode[] child;
    public DictTreeNode () {
        child = new DictTreeNode[SIZE];
    }
}

class WordDictionary {
    DictTreeNode root;
    public WordDictionary() {
        root = new DictTreeNode();
    }

    public void addWord(String word) {
        DictTreeNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new DictTreeNode();
            }
            node = node.child[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        DictTreeNode node = root;
        return dfs(node, word, 0);
    }

    public boolean dfs(DictTreeNode root, String word, int index) {
        if (index >= word.length()) {
            return root.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (DictTreeNode ch : root.child) {
                if (ch != null && dfs(ch, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (root.child[c - 'a'] != null) {
                return dfs(root.child[c - 'a'], word, index + 1);
            } else {
                return false;
            }
        }
    }
}
