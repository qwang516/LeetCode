package wangqi.binarytree;

import java.util.ArrayList;

import wangqi.data.model.ListNode;
import wangqi.data.model.TreeNode;

public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		int len = 0;
		while (cur != null) {
			cur = cur.getNext();
			len++;
		}
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		list.add(head);
		return helper(list, 0, len - 1);

	}

	private TreeNode helper(ArrayList<ListNode> list, int left, int right) {
		if (left > right) {
			return null;
		}
		int m = (left + right) / 2;
		TreeNode node = new TreeNode(list.get(0).getValue());
		node.setLeft(helper(list, left, m - 1));
		list.set(0, list.get(0).getNext());
		node.setRight(helper(list, m + 1, right));
		return node;
	}
}
