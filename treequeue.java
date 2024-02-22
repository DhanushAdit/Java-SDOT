//this code takes the a string of inputs for a tree and we assign it according to the diagram
//this code will also print the tree in Inorder, Postorder and Pre-order
//this code also contains a function to print the all the right voew elements of the tree
//this code contains function to find the parent nodes without 2 chils and also the 
//nodes without siblings each with different function.
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
    static void postorder(Node root)
        {
            if(root == null)
            {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
            
        }
    static void preorder(Node root)
    {
        if(root == null)
            {
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
            
    }
    static void nws(Node root) //to find the nodes without siblings
    {
        if(root == null)
        {
            return;
        }
        if(root.left!=null && root.right!=null)
        {
            nws(root.left);
            nws(root.right);
        }
        else if(root.right!=null)
        {
            System.out.print(root.right.data+" ");
            nws(root.right);
        }
        else if(root.left!=null)
        {
            System.out.print(root.left.data+" ");
            nws(root.left);
        }
            
    }
    static void findRightView(Node root,int depth,List <Integer> rightView)
    {
        if(root == null)
        {
            return;
        }
        if(depth == rightView.size())
        {
            rightView.add(root.data);
        }
        findRightView(root.right,depth+1,rightView);
        findRightView(root.left,depth+1,rightView);
    }
    static void nochild(Node root) //finding the parent node without 2 child
    {
        if(root == null)
        {
            return;
        }
        Node curr = root;
        if(curr.right == null || curr.left == null)
        {
            System.out.print(curr.data+" ");
        }
        nochild(curr.right);
        nochild(curr.left);
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
        int count = 0;
        String str = sc.nextLine();
        String[] strip = str.split(" ");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(strip[0]));
        queue.add(root);
        count++;
        for(int i=1;i<strip.length;i+=2) //as we are taking two elements for each iteration
        {
            Node curr = queue.poll();
            if(!strip[i].equals("-1")) //when the value is not equal to -1 add the value as child
            {
                curr.left = new Node(Integer.parseInt(strip[i]));
                queue.add(curr.left);
                count++;
            }
            if(!strip[i+1].equals("-1")) //when the value is not equal to -1 add the value as child
            {
                curr.right = new Node(Integer.parseInt(strip[i+1]));
                queue.add(curr.right);
                count++;
            }
        }
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        preorder(root);
        List<Integer> rightView = new ArrayList<>();
        findRightView(root,0,rightView);
        System.out.println();
        System.out.println(rightView);
        System.out.print("Nodes without siblings:");
        nws(root);
        System.out.println("Count: "+ count);
    }
}
//preorder, postorder, Inorder 3 ways of printing a binary tree
