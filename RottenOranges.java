// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
            return -1;
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        int rows=grid.length;
        int cols = grid[0].length;
        
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                if(grid[i][j]==1)
                    freshOranges++;
                else if(grid[i][j]==2)
                    q.add(new int[]{i,j});
        
        int mins = 0;
        
        while(freshOranges>0 && !q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                int[] badOrange = q.remove();
                int r = badOrange[0];
                int c = badOrange[1];
                
                if(r-1>=0 && grid[r-1][c]==1) {
                    grid[r-1][c]=2;
                    freshOranges--;
                    q.add(new int[]{r-1,c});
                }
                
                if(r+1<rows && grid[r+1][c]==1) {
                    grid[r+1][c]=2;
                    freshOranges--;
                    q.add(new int[]{r+1,c});
                }
                
                if(c-1>=0 && grid[r][c-1]==1) {
                    grid[r][c-1]=2;
                    freshOranges--;
                    q.add(new int[]{r,c-1});
                }
                
                if(c+1<cols && grid[r][c+1]==1) {
                    grid[r][c+1]=2;
                    freshOranges--;
                    q.add(new int[]{r,c+1});
                }
            }
            mins++;
        }
        
        return freshOranges>0 ? -1: mins;
    }
}