// Time Complexity: find oranges O(mn) + bfs O(mn) -> O(mn)
// Space Complexity: queue O(mn)

// BFS
public class RottingOranges {
    public int orangesRotting(int[][] grid)
    {
         if(grid == null || grid.length == 0)
             return 0;
        
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][] { {0,1}, {0, -1}, {1,0}, {-1, 0}};
        int freshOranges = 0;
        int time = 0;
     
        // create queue of rotten oranges
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i ++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(grid[i][j] == 1)
                {
                    freshOranges++;
                }
                else if(grid[i][j] == 2)
                {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        // if there are no fresh oranges
        if(freshOranges == 0)
            return time;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size ; i ++)
            {
                int [] curr = q.poll();
                for(int dir[] : dirs)
                {
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r >= 0 && r < m && c >=0 && c < n && grid[r][c] == 1)
                    {
                        grid[r][c] = 2;
                        freshOranges--;
                        q.offer(new int[]{r,c}); // to find fresh oranges of the newly rotten oranges
                    }
                }
            }
            time++; 
        }
    
        //we still have fresh oranges left
        if(freshOranges != 0)
            return -1;
        
        return time-1; // since we increase time after every level and after last level we need not increase time
        }
}

// DFS (can be more than one entry point for rotting and any could lead to less time and need to backtrack)
