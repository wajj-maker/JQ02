package day01;

import java.util.ArrayList;
import java.util.List;

public class Solution04 {

}

class BSTIterator {

    int index = 0;
    List<Integer> list = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        midOrder(list, root);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        if (index >= list.size()) {
            return false;
        }
        return true;
    }

    public void midOrder(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            midOrder(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            midOrder(list, root.right);
        }
    }
}

