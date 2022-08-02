package day19;

import java.util.ArrayList;
import java.util.List;

public class Solution07 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        List<Integer> fortList = new ArrayList<>();
        fortFor(fortList, root);
        List<Integer> midList = new ArrayList<>();
        midFor(midList, root);
        if (key < midList.get(0) || key > midList.get(midList.size() - 1)) {
            return root;
        }
        int index = fortList.indexOf(key);
        fortList.remove(index);
        if (index == -1) {
            return root;
        }
        index = midList.indexOf(key);
        midList.remove(index);
        if (midList.size() == 0) {
            return null;
        }
        TreeNode rot = new TreeNode(fortList.get(0));
        createTree(rot, fortList, midList, 0);
        return rot;
    }

    public void createTree(TreeNode root, List<Integer> fortList, List<Integer> midList, int index) {
        if (midList.size() == 1) {
            return;
        }
        int index1 = midList.indexOf(fortList.get(index));
        if (index1 > 0) {
            List<Integer> leftList = midList.subList(0, index1);
            for (int i = index + 1; i < fortList.size(); i++) {
                if (leftList.contains(fortList.get(i))) {
                    root.left = new TreeNode(fortList.get(i));
                    createTree(root.left, fortList, leftList, i);
                    break;
                }
            }
        }

        if (index1 < midList.size() - 1) {
            List<Integer> rightList = midList.subList(index1 + 1, midList.size());
            for (int i = index + 1; i < fortList.size(); i++) {
                if (rightList.contains(fortList.get(i))) {
                    root.right = new TreeNode(fortList.get(i));
                    createTree(root.right, fortList, rightList, i);
                    break;
                }
            }
        }
    }

    public void fortFor(List<Integer> list, TreeNode root) {
        list.add(root.val);
        if (root.left != null) {
            fortFor(list, root.left);
        }
        if (root.right != null) {
            fortFor(list, root.right);
        }
    }

    public void midFor(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            midFor(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            midFor(list, root.right);
        }
    }
}
