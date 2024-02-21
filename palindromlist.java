import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList lst = new LinkedList();
        for (int i = 0; i < n; i++) {
            lst.insertAtEnd(sc.nextInt());
        }
        sc.close();
        if (lst.palindrome()) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }

    static class LinkedList {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        boolean palindrome() {
            if (head == null || head.next == null) {
                return true;
            }
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node secondhalf = reverse(slow);
            Node firsthalf = head;

            while (secondhalf != null) {
                if (firsthalf.data != secondhalf.data) {
                    return false;
                }
                firsthalf = firsthalf.next;
                secondhalf = secondhalf.next;
            }
            return true; // This return statement indicates it's a palindrome
        }

        Node reverse(Node temp) {
            Node prev = null;
            Node curr = temp;
            Node next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        void print(Node temp) {
            while (temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
            }
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
