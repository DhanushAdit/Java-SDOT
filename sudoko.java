mport java.io.*;
import java.util.*;

public class Main {
    static  int[][] grid;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int[][] grid=new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
                grid[i][j]=sc.nextInt();
                
        }
        
        if(sudokoSolver(grid,0,0))
        {
         for(int i=0;i<row;i++)
         {
            for(int j=0;j<col;j++)
                System.out.print(grid[i][j]+" ");
            System.out.println();
                
         }
        }
        else
            System.out.println("No Solution exists");
        
        
    }
    
    static boolean sudokoSolver(int[][] grid,int row,int col)
    {
        if(row==grid.length)
            return true;
        int nrow=0;
        int ncol=0;
        if(col!=grid.length-1)
           {
               nrow=row;
               ncol=col+1;
           }
           else
           {
               nrow=row+1;
               ncol=0;
           }
        

        if(grid[row][col]!=0)
        {
            if(sudokoSolver(grid,nrow,ncol))
                return true;
            
        }
        else
        {
            for(int i=1;i<=9;i++)
            {
                if(isSafe(grid,row,col,i))
                {
                    grid[row][col]=i;
                    if(sudokoSolver(grid,nrow,ncol))
                    {
                        return true;
                    }
                    else
                    {
                        grid[row][col]=0;
                    }
                }
                
            }
        }
         return false;  
    }
    
    static boolean isSafe(int[][] grid,int row,int col,int number)
    {
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][col]==number)
                return false;
            if(grid[row][i]==number)
                return false;
        }
        
        // 3*3 box check
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++)
            for(int j=sc;j<sc+3;j++)
                if(grid[i][j]==number)
                    return false;
        return true;
    }
}
