package wangqi.binarysearch;

/*
 * Given a sorted array and a target value,
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsert {
	public static int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] nullNums = null;
		System.out.println(searchInsert(nullNums, 5)); // 0
		int[] emptyNums = new int[] {};
		System.out.println(searchInsert(emptyNums, 2)); // 0
		int[] nums = new int[] { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 5)); // 2
		System.out.println(searchInsert(nums, 2)); // 1
		System.out.println(searchInsert(nums, 7)); // 4
		System.out.println(searchInsert(nums, 0)); // 0
	}
}
