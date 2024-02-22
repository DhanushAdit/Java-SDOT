//this code takes the a string of inputs for a tree and we assign it according to the diagram

import java.util.*;
class Main
{
    static void inorder(Node root)
        {
            if(root == null)
            {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    static class Node
        {
            int data;
            Node left = null;
            Node right = null;
            Node(int data)
            {
                this.data = data;
            }
        }
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strip = str.split(" ");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(strip[0]));
        queue.add(root);
        for(int i=1;i<strip.length;i+=2) //as we are taking two elements for each iteration
        {
            Node curr = queue.poll();
            if(!strip[i].equals("-1")) //when the value is not equal to -1 add the value as child
            {
                curr.left = new Node(Integer.parseInt(strip[i]));
                queue.add(curr.left);
            }
            if(!strip[i+1].equals("-1")) //when the value is not equal to -1 add the value as child
            {
                curr.right = new Node(Integer.parseInt(strip[i+1]));
                queue.add(curr.right);
            }
            
        }
        inorder(root);
    }
}
//preorder, postorder, Inorder 3 ways of printing a binary tree
