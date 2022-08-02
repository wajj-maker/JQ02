package day09;

import java.util.ArrayList;
import java.util.List;

public class Solution06 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        midOrder(list, root);
        return list.get(k - 1);
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
