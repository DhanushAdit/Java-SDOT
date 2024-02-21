//this program is to create a samplle custom LinkedList class

import java.util.*;
public class linkedlist{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ele; 
        LinkedList ll = new LinkedList();
        while((ele = sc.nextInt())!= -1){
            ll.insertAtEnd(ele);
        }
        ll.insertAtMid(3, 20);
        ll.print();
        sc.close();
       
    }
    static class LinkedList{
        Node head = null; // used in insert at the beginning
        Node tail = null; //used in insert at last
        void insertAtBeg(int data){
            Node newNode = new Node(data);
            if(head == null){
                newNode = head;
            }
            else{
                newNode.next = head;
                head = newNode;
            }
        }
        void insertAtEnd(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
                
            }
        }
        void insertAtMid(int pos, int data){
            if(pos==0){
                insertAtBeg(data);
                return;
            }
            Node newNode = new Node(data);
            Node temp = head;
            for(int i=0;i<pos-1;i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next=newNode;
        }

        void print(){
            Node temp = head;
            System.out.println("Hi");
            while(temp!=null){
                
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
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
