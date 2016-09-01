package smallcompany;

/**
 * Question: How to solve Fibonacci? Given an input n, get the nth fibonacci number. The beginning sequence is:
 * 1, 1, 2, 3, 5...
 * Follow up: Analyze the time complexity and ask for better solution. Hint: Memorization.
 * @author cchen
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(FibonacciSolution.getNthNumber2(5));
	}
	
}

class FibonacciSolution {
	/**
	 * Using recursion to solve this problem. The time complexity is O(2^n).
	 * @param n
	 * @return
	 */
	public static int getNthNumber(int n) {
		if (n < 2) return 1;
		return getNthNumber(n - 1) + getNthNumber(n - 2);
	}
	
	/**
	 * Using a for loop to solve this problem with multiple variables. This method will take O(n);
	 * @param n
	 * @return
	 */
	public static int getNthNumber2(int n) {
		if (n < 2) return 1;
		int res = 0;
		int beforebefore = 1, before = 1;
		for (int i = 2; i <= n; i++) {
			res = beforebefore + before;
			beforebefore = before;
			before = res;
		}
		return res;
	}
	//actually this is hard to extend to memoization, so this question is not recommended to ask interviewers.
}
