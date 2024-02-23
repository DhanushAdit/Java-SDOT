//we place 1 in the places of queens

import java.util.*;
public class Main
{
    static int sol[][];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<4)
        {
            System.out.print("-1");
            return;
        }
        sol = new int[n][n];
        nqueen(n,0);
    }
    static boolean isSafe(int row,int col,int n)
    {
        for(int i=col;i>=0;i--)
        {
            //checking the horizontal line
            if(sol[row][i] == 1)
            {
              return false;  
            }
        }
        //for checking the upper left diagonal
        for(int i=row,j=col;i >= 0 && j >= 0;i--,j--)
            {
                if(sol[i][j]==1)
                {
                    return false;
                }
            }    
            
        //to check the lower left diagonal
        for(int i=row,j=col;i<n && j>=0;i++,j--)
        {
            if(sol[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean nqueen(int n,int col)
    {
        if(col==n)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(sol[j][i] == 1)
                    {
                        System.out.print(j+1+" ");
                    }
                }
            }
            return false;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(i,col,n))
            {
                sol[i][col] = 1;
                if(nqueen(n,col+1))
                {
                    return true;
                }
            sol[i][col] = 0;
            }
        }
        return false;
    }
}
