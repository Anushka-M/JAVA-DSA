/** Leetcode: 289- The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.**/


class Solution {
    public void gameOfLife(int[][] b) {
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b[0].length;j++)
            {
                int count =0;
                if(i-1>=0 && j-1>=0 && Math.abs(b[i-1][j-1])==1)
                    count++;
                if(i-1>=0 && Math.abs(b[i-1][j])==1)
                    count++;
                if(j-1>=0 && Math.abs(b[i][j-1])==1)
                    count++;
                if(i+1<b.length && j-1>=0 && Math.abs(b[i+1][j-1])==1)
                    count++;
                if(i+1<b.length && j+1<b[0].length && Math.abs(b[i+1][j+1])==1)
                    count++;
                if(i-1>=0 && j+1<b[0].length && Math.abs(b[i-1][j+1])==1)
                    count++;
                if(i+1<b.length && Math.abs(b[i+1][j])==1)
                    count++;
                if(j+1<b[0].length && Math.abs(b[i][j+1])==1)
                    count++;
                if(b[i][j]==0 && count==3)
                    b[i][j]=2;
                else if (b[i][j]==1 && (count < 2 || count > 3))
					b[i][j] = -1;
            }
        }
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b[0].length;j++)
            {
                if(b[i][j]==-1)
                    b[i][j]=0;
                else if(b[i][j]==2)
                    b[i][j]=1;
            }
        }
    }
}