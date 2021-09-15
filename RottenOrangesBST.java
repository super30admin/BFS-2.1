// Time Complexity : O(mn) no of rows n coulmns
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : too almost one hour to get to the solution


// Your code here along with comments explaining your approach
//using bfs
    // 1. add all the rotten oranges in q if you encounter fresh oranges inc the fesh orange counter
    // 2.untill q is empty for each matrix index in q check all 4 directions ans see if there is any fresh orange 
//3. if fresh orange found : Dec fresh count by 1 , make it rotten and assign it to q
// here in matrix all diagonal elements will be considered on a same level so we will increase the minute only if we move to next level

class Solution {
    
    public int orangesRotting(int[][] grid) {
        int fresh =0;
        int minutes = -1;
        if(grid == null) return -1;
        int[][] dir =  {{0,-1},{0,1},{1,0},{-1,0}}; 
        Queue<int[]> q = new LinkedList<>();
        for(int row = 0 ; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {  
                if(grid[row][col] ==1)
                    fresh++;
               else if(grid[row][col] ==2)
                {
                    q.add(new int[]{row,col});
                }
            }
        }
        
        // if there is no fresh oranges it means it will take 0 mins to make entire matrix rotten
        if(fresh ==0) return 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for( int i = 0 ; i < size ; i++)
            {
                int[] curr = q.poll();
                 for(int[] dirs : dir)
                 {
                     int r  = curr[0] + dirs[0];
                     int c = curr[1] + dirs[1];
                     
                     if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1)
                     {
                         
                         grid[r][c] = 2;
                         fresh--;
                         q.add(new int[] {r,c});
                     }
                 }
            }
           minutes++;
        }
        
        if(fresh ==0)
          return  minutes;
        else return -1;
        
      
    }
}