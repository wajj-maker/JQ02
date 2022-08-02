package day19;

import java.util.*;

public class Solution06 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val).append(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                stringBuilder.append("null").append(" ");
            } else {
                stringBuilder.append(node.left.val).append(" ");
                queue.offer(node.left);
            }
            if (node.right == null) {
                stringBuilder.append("null").append(" ");
            } else {
                stringBuilder.append(node.right.val).append(" ");
                queue.offer(node.right);
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] splits = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!splits[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(splits[index]));
                queue.offer(node.left);
                index++;
            } else {
                index++;
            }
            if (!splits[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(splits[index]));
                queue.offer(node.right);
                index++;
            } else {
                index++;
            }
        }
        return root;
    }
}
