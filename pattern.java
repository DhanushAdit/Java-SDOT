import java.util.*;
class Main{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int no=1;
        int value=n*n+1;
        for(int i=n;i>0;i--)
        {
            for(int h=0;h<n-i;h++)
                System.out.print("--");
            for (int j=0;j<i;j++)
                System.out.print(no+++"*");
            for(int k=0;k<i-1;k++)
                System.out.print(value+++"*");
            System.out.print(value); 
            value=value-2*(i-1);
            System.out.println("");
        }
    }
}
