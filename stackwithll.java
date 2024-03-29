import java.util.*;
public class stackwithll 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String ip = sc.next();
            if(ip.equals("push"))
            {
                ll.insertAtEnd(sc.nextInt());
            }
            if(ip.equals("pop"))
            {
                ll.pop();
            }
            if(ip.equals("print"))
            {
                ll.print();
            }
        }
        sc.close();
    }
    static class LinkedList
    {
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
            System.out.println();
        }
        void pop()
        {
            if(head==null)
            {
                System.out.print("Empty stack");
            }
            Node temp = head;
            while(temp.next.next!=null)
            {
                temp = temp.next;
            }
            int rem = tail.data;
            System.out.println("The data to be removed is:"+rem);
            temp.next = null;
            tail = temp;
        }

    }

    static class Node
    {
        int data;
        Node next = null;
        Node(int data)
        {
            this.data = data;
        }
    }
}

