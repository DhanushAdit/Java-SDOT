//this program is to merge n number of linkedlist of different sizes to a single list
//using seperate custom LinkedList class
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}

public class klists {
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        List<ListNode> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ListNode head = new ListNode(scanner.nextInt());
            ListNode current = head;
            int num;
            while ((num = scanner.nextInt()) != -1) {
                current.next = new ListNode(num);
                current = current.next;
            }
            lists.add(head);
        }
        ListNode mergedList = mergeKLists(lists);
        printLinkedList(mergedList);
        scanner.close();
    }
}
