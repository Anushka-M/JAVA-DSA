/** Coun the number of Connected Islands - Variation of Connected Components in Unweighted Undirected Graph**/



// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    int count =0;
    
    public boolean isValid(int i,int j,int r,int c,char[][] grid,boolean[][] v)
    {
        return (i>=0 && j>=0 && i<r && j<c && (grid[i][j] == '1' && !v[i][j]));
    }
    
    
    public void DFSutil(char[][] g,boolean[][] v,int i,int j,int r,int c)
    {
        int[] rInc = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] cInc = { -1, 0, 1, -1, 1, -1, 0, 1 };
        
        v[i][j] = true;
        
        for(int k=0;k<8;k++)
        {
            if(isValid(i+rInc[k],j+cInc[k],r,c,g,v))
                DFSutil(g,v,i+rInc[k],j+cInc[k],r,c);
        }
    }
    
    
    public int numIslands(char[][] grid)
    {
        // Code here
        int r = grid.length;
        int c = grid[0].length;
        boolean v[][] = new boolean[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='1' && !v[i][j])
                {
                    DFSutil(grid,v,i,j,r,c);
                    count++;
                }
                
            }
        }
        return count;
    }
}