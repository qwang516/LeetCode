package wangqi.binarytree;

import wangqi.data.model.TreeNode;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class SortedArrayToBST {
	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}

	private static TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode treeNode = new TreeNode(nums[mid]);
		treeNode.setLeft(helper(nums, left, mid - 1));
		treeNode.setRight(helper(nums, mid + 1, right));
		return treeNode;
	}
}
