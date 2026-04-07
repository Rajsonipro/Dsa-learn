/*
 * LeetCode 876. Middle of the Linked List
 * Given the head of a singly linked list, return the middle node.
 * If there are two middle nodes, return the second middle node.
 */

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}

public class MiddleOfLinkedList {
	public static void printList(ListNode head) {
		ListNode curr = head;
		if (curr == null) {
			System.out.print("null");
		} else {
			while (curr != null) {
				System.out.print(curr.val);
				if (curr.next != null) System.out.print(" -> ");
				curr = curr.next;
			}
		}
		System.out.println();
	}

	public static ListNode createList(int[] vals) {
		if (vals.length == 0) return null;
		ListNode head = new ListNode(vals[0]);
		ListNode curr = head;
		for (int i = 1; i < vals.length; i++) {
			curr.next = new ListNode(vals[i]);
			curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();

		// Test 1: Odd length [1,2,3,4,5] -> 3
		int[] test1 = {1,2,3,4,5};
		ListNode head1 = createList(test1);
		System.out.print("Input: "); printList(head1);
		ListNode mid1 = sol.middleNode(head1);
		System.out.print("Middle: "); printList(mid1);

		// Test 2: Even length [1,2,3,4,5,6] -> 4
		int[] test2 = {1,2,3,4,5,6};
		ListNode head2 = createList(test2);
		System.out.print("Input: "); printList(head2);
		ListNode mid2 = sol.middleNode(head2);
		System.out.print("Middle: "); printList(mid2);

		// Test 3: Single node [1] -> 1
		int[] test3 = {1};
		ListNode head3 = createList(test3);
		System.out.print("Input: "); printList(head3);
		ListNode mid3 = sol.middleNode(head3);
		System.out.print("Middle: "); printList(mid3);

		// Test 4: Empty
		ListNode head4 = null;
		System.out.print("Input: null\nMiddle: null");
	}
}
