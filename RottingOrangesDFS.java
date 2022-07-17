class Solution {
    
   /*
    * Procedure: BFS, connected components.
    *
    * 1. Find all rotten oranges by traversing the grid and add them to queue
    * 2. While 'Q' is not empty, keep dequeue-ing rotten oranges, belonging to that level.
    * 3. For each rotten orange
    * 4. Add all the newly rotten oranges to the Q.
    * 5. Once a level is finished increment the count.
    *
    *
    *   grid[i][j] -> Visualization.
    *
    *               j     j+1     j+2  
    *   grid[i]    [2      1       1]
    *   grid[i+1]  [1      1       0]
    *   grid[i+2]  [0      1       1]   
    *
    *   
    *   dirs -> Representation.Neighbhours of X represented using
    *
    *    dir[i]        [ 0        1] -> Right
    *    dir[i+1]      [ 0       -1] -> Left
    *    dir[i+2]      [-1        0] -> Top
    *    dir[i+3]      [ 1        0] -> Bottom
    *
    *   
    *   grid[i]    [0                   Top {-1,0}                            0]
    *   grid[i+1]  [Left {0,-1}            X                        Right {0,1}]
    *   grid[i+1]  [0                   Bottom {1,0}                          0]   
    *
    *
    *   Time complexity:  O(mn)^2 
    *       We are intiating DFS at all the rotten oranges. Each DFS takes O(mn) time.
    *       So complexity can be =>    dfs on all mn nodes => mn * O(mn) => O(mn)^2
    *           
    *`          
    *   Space complexity: O(mn) -> All except one orange are rotten, so the dfs at max can got to depth of       *.  all nodes
    *
    *   
    *
    **/
    
    private int [][] dirs = new int [][] {{0,-1}, {-1,0}, {1,0}, {0,1}};
    private int m = -1;
    private int n = -1;
    
    
    public int orangesRotting(int[][] grid) {
        
        boolean atLeastOneOrangeFound = false;
        int timeElapsed = -1;
        
        // Base case   
        if(grid == null || grid.length == 0)
            return 0;
        
        m = grid.length;
        n = grid[0].length;
        
        
        int p= -1; int q = -1;
        for(int i = 0; i< m; i++) {
            for(int j =0; j<n; j++) {
                //Found rotten orange
               if(grid[i][j] == 2)
                // time is initially 2 because we are overriding fresh oranges with time,
                // instead of storing the clock ticks separately
                // (1 -> fresh orange, 0 -> no orange, 2-> rotten at 0, 3 or more -> rotten at time-2 )    
                   
                dfs(grid, i, j, 2);
            }
        }
        
        
        for(int i = 0; i< m; i++) {
            System.out.println();
            for(int j =0; j<n; j++) {
                System.out.print(grid[i][j]); 
              if(grid[i][j] == 1) 
                  return -1;
                
               timeElapsed = Math.max(grid[i][j], timeElapsed); 
            }
        }
        
        if(timeElapsed == 0) 
            return 0;
        
        return timeElapsed - 2;
    }
    
    
    private void dfs(int [][] grid, int r, int c, int time) {
        
        // base case
        if( r >= m || c >= n || r < 0 || c < 0 ) 
            return;
        
        if(grid[r][c] == 0) return;
        
        
        // Override current cell only if that orange can be rotten quicker in the current direction.
        if(grid[r][c] > 1 && grid[r][c] < time)
            return;
        
        
        else {
        
            grid[r][c] = time;

            for(int [] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                dfs(grid, nr, nc, time+1);
            }    
        }
        
        
        return;
        
    }
    
    
}
