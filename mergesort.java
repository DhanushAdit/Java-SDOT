//this program is to merge some sorted linked list

import java.util.*;

class summa{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int s1, s2;
        s1 = sc.nextInt();
        LinkedList l1 = new LinkedList();
        for(int i = 0; i < s1; i++){
            l1.insertAtEnd(sc.nextInt());
        }
        s2 = sc.nextInt();
        LinkedList l2 = new LinkedList();
        for(int i = 0; i < s2; i++){
            l2.insertAtEnd(sc.nextInt());
        } 
        merge(l1, l2);
        sc.close();
    }

    static void merge(LinkedList l1, LinkedList l2){
        LinkedList merged = new LinkedList();
        Node h1 = l1.head;
        Node h2 = l2.head;
        while(h1 != null && h2 != null){
            if(h1.data <= h2.data){
                merged.insertAtEnd(h1.data);
                h1 = h1.next;
            }
            else{
                merged.insertAtEnd(h2.data);
                h2 = h2.next;
            }
        }
        // Append remaining elements of l1
        while(h1 != null){
            merged.insertAtEnd(h1.data);
            h1 = h1.next;
        }
        // Append remaining elements of l2
        while(h2 != null){
            merged.insertAtEnd(h2.data);
            h2 = h2.next;
        }
        print(merged);
    }

    static void print(LinkedList ll){
        Node temp = ll.head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static class LinkedList{
        Node head = null;
        Node tail = null;
        
        void insertAtEnd(int data){
            Node newNode = new Node(data);
            if(tail == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("NULL");
        }
    }

    static class Node{
        int data;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }
}
