void main() {
    Solution s = new Solution();
    ListNode c = new ListNode(3, null);
    ListNode b = new ListNode(2, c);
    ListNode a = new ListNode(1, b);

    System.out.println(a);

    ListNode newList = s.reverseList(a);

    System.out.println(newList);
    System.out.println("first: " + newList.val);
    System.out.println("second: " + newList.next.val);
    System.out.println("third: " + newList.next.next.val);
}

public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode[" + "val = " + val + ", next = " + (next != null ? next.toString() : null) + ']';
    }
}

class Solution {
    public ListNode reverseList(final ListNode originalHead) {
        if (originalHead == null) return null;
        if (originalHead.next == null) return originalHead;

        ListNode current = originalHead.next;
        originalHead.next = null;

        ListNode previous = originalHead;
        while (current != null) {
            ListNode newCurrent = current.next;
            current.next = previous;
            previous = current;
            current = newCurrent;
        }

        return previous;
    }
}
