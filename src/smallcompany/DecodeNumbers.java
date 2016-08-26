package smallcompany;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Question: https://docs.google.com/document/d/1nNuY2KOkwXXMfOVW8zSSzgMG5CE4BHBKIkaHStO3W4I/edit
 *
 * @author Jian Xu
 *
 */
public class DecodeNumbers {

	public static String decodeString(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		int head = 0;
		int tail = 0;
		StringBuilder strBuilder = new StringBuilder();
		Queue<Character> decodeQueue = new LinkedList<>();
		for (Character ch : s.toCharArray()) {
			tail++;
			decodeQueue.offer(ch);
		}
				
		while (head < tail) {
			// every round first populate character.
			head++;
			strBuilder.append(decodeQueue.poll());
			// every round move second character to end.
			decodeQueue.offer(decodeQueue.poll());
			tail++;
			head++;
		}
		return strBuilder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(decodeString("631758924"));
	}
}
