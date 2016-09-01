package smallcompany;

/**
 * There is a sorted array, can you find the magic index such that a[i] equals i.
 * Follow up:
 * There is an array composed of positive integers. Find the magic index such that the sum of all numbers on this index's left is equal to
 * the sum of right.
 * Follow up: Can you optimize your solution? (If interviewer uses brute force). Hint: Binary Search.
 * @author cchen
 *
 */
public class MagicIndex {

}

class MagicIndexVersion1Solution{
	public static int findMagicIndex(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (array[middle] == middle) {
				return middle;
			} else if (array[middle] < middle) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}
}

/**
 * To make the question more clear, we assume that for the boundaries, for example, index is 0, we say the sum of left is 0. Same
 * for right boundary.
 * To make the question simple, we assume that an magic index should have >0 number of elements on both sides.
 * @author cchen
 *
 */
class MagicIndexVersion2Solution {
	/**
	 * This is a brute force solution. Time complexity is O(n^2).
	 * @param arrar
	 * @return
	 */
	public static int findMagicIndex(int[] array) {
		if (array == null || array.length < 3) {
			return -1;
		}
		for (int i = 1; i < array.length - 1; i++) {
			if (getSum(array, 0, i - 1) == getSum(array, i + 1, array.length - 1)) {
				return i;
			}
		}
		return -1;
	}
	
	private static int getSum(int[] array, int startIndex, int endIndex) {
		int sum = 0;
		for (int current = startIndex; current <= endIndex; current++) {
			sum += array[current];
		}
		return sum;
	}
	
	/**
	 * This method is using extra buffer so time complexity could be improved to O(n + n).
	 * @param array
	 * @return
	 */
	public static int findMagicIndex2(int[] array) {
		if (array == null || array.length < 3) {
			return -1;
		}
		int[] sumArray = getSumArray(array);
		//question is: how about {3}? In this case, is 0 a magic index? no!
		for (int i = 1; i < sumArray.length - 1; i++) {
			if (sumArray[i - 1] == sumArray[sumArray.length - 1] - sumArray[i]) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This method is using extra buffer but the time complexity is O(n) + O(lgn).
	 * @param array
	 * @return
	 */
	public static int findMagicIndex3(int[] array) {
		if (array == null || array.length < 3) {
			return -1;
		}
		int[] sumArray = getSumArray(array);
		int left = 1, right = sumArray.length - 2;
		while (left <= right) {
			int middle = left + (right - left) / 2; // <-- this little trick can be used to ask interviewers.
			int leftSum = sumArray[middle - 1], rightSum = sumArray[sumArray.length - 1] - sumArray[middle];
			if (leftSum == rightSum) {
				return middle;
			} else if (leftSum < rightSum) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}
	
	/**
	 * The time complexity of this helper function is O(n)
	 * @param array
	 * @return
	 */
	private static int[] getSumArray(int[] array) {
		int[] sumArray = new int[array.length];	//in this sumArray, each value is corresponding to the sum of all the elements on the left and itself.
		int sum = 0;
		for (int index = 0; index < array.length; index++) {
			sum += array[index];
			sumArray[index] = sum;
		}
		return sumArray;
	}
}
