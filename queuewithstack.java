//this is code for representing a Queue using Stack
//queue has a seperate class
import java.util.Stack;
class Main
{
    public static void  main(String[] args)
    {
        Queue q1 = new Queue();
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.remove();
        q1.print();
    }
}
class Queue
    {
        int data;
        Stack<Integer> stpush = new Stack<Integer>();
        Stack<Integer> stpop = new Stack<Integer>();
        void add(int data)
        {
            stpush.push(data);
        }
        void remove()
        {
            if(!stpop.isEmpty())
            {
                stpop.pop();
            }
            else
            {
                while(!stpush.isEmpty())
                {
                    int a = stpush.pop();
                    stpop.push(a);
                }
                stpop.pop();
            }
        }
        void print() 
        {
            while (!stpush.isEmpty()) 
            {
            int a = stpush.pop();
            stpop.push(a);
            }
            while (!stpop.isEmpty()) 
            {
            int a = stpop.pop();
            System.out.print(a + " ");
            }
        }

    }
