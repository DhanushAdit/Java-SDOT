import java.util.*;
public class stackwithll {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            ll.insertAtEnd(sc.nextInt());
        }
        ll.print();
    }
    static class LinkedList{
        Node head = null;
        Node tail = null;
        void insertAtEnd(int data)
        {
            Node newNode = new Node(data);
            if(head == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                tail.next = newNode;
                tail = newNode;
            }
        }
        void print()
        {
            Node temp = head;
            while(temp!=null)
            {
                System.out.print(temp.data);
                temp = temp.next;
            }
        }
        void pop()
        {
            for(int i=0;i<;i++)
            {

            }
        }

    }

    static class Node{
        int data;
        Node next = null;
        Node(int data)
        {
            this.data = data;
        }
    }
}

