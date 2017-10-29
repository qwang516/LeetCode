package wangqi.binarytree;

import java.util.HashMap;
import java.util.Map;

import wangqi.data.model.TreeNode;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTree {
	public TreeNode construtBinaryTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i = 0;
		for (int num : inorder) {
			map.put(num, i++);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	}

	private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight,
			Map<Integer, Integer> map) {
		if (inLeft > inRight || preLeft > preRight) {
			return null;
		}
		TreeNode treeNode = new TreeNode(preorder[preLeft]);
		int index = map.get(preorder[preLeft]);
		treeNode.setLeft(helper(preorder, preLeft + 1, preLeft + index - inLeft, inorder, inLeft, index - 1, map));
		treeNode.setRight(helper(preorder, preLeft + index - inLeft + 1, preRight, inorder, index + 1, inRight, map));
		return treeNode;
	}
}
