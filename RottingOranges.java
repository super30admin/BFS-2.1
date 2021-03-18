// Time Complexity : O(n*m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We are using a BFS approach here.We iterate at all levels and whenever we see the right most element at any level , we add that to the result .
class Solution {
    public int orangesRotting(int[][] grid) {
      
      if(grid == null || grid.length ==0 || grid[0]==null || grid[0].length==0)
      {
        return 0;
      }
      
      Queue<int[]> queue = new LinkedList<>();
      
      int n = grid.length;
      int m = grid[0].length;
      //variable to store the number of fresh oranges
      int fresh = 0;
      
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<m;j++)
        {
          //for rotten oranges add index to queue
          if(grid[i][j]==2)
          {
            queue.add(new int[]{i,j});
          }
          //count number of fresh oranges
          if(grid[i][j]==1)
          {
            
            fresh++;
          }
        }
      }
      
      int time = 0;
      //array to check four directions
      int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
      while(!queue.isEmpty())
      {
        int size = queue.size();
        
        for(int x=0;x<size;x++)
        {
          int[] pair = queue.poll();
          
          for(int[] dir:dirs)
          {

            int i = dir[0]+pair[0];
            int j = dir[1]+pair[1];
            //make the fresh orange as rotten orange
            if(i>=0 && i<n && j>=0 && j<m && grid[i][j]==1)
            {
              grid[i][j]=2;
              queue.add(new int[]{i,j});
              //fresh orange made rotten
              fresh--;
            }
          }
        }
        time++;
      }
      //not all fresh oranges were made rotten
      if(fresh!=0)
      {
        return -1;
      }
      if(time>0)
      {
      return time-1;
      }
      else
      {
        return time;
      }
    }
}