import java.util.*;

public class stackwithcoll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {   
            String ip = sc.next();
            if(ip.equals("push")) 
        {
            list.add(sc.nextInt());
        } 
        else if(ip.equals("pop")) 
        {
            if(list.isEmpty()) 
            {
                System.out.print("-1");
            } 
            else 
            {
                int rem = list.remove(list.size() - 1);
                System.out.println(rem);
            }
        }
        else if(ip.equals("print"))
        {
            if(list.isEmpty())
            {
                System.out.print("Empty");
            }
            else
            {
                for(int j=0;j<=list.size()-1;j++)
                {
                    System.out.print(list.get(j));
                }
            }
        }  
        }
        
    }
}
