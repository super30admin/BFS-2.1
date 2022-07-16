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
    *   Time complexity:  2 O(mn) -> O(mn)
    *       Whole array need to be traversed to find rotten oranges O(mn) + 
    *       Max no.of rotten oranges that need to be processed to find the time elapsed. O(mn) ie all           *       oranges rotten -> O(mn)
    *`          
    *   Space complexity: Max no of oranges can be queued. O(mn)
    *
    *   
    *
    **/
    
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int timeElapsed = -1;
        int freshOranges = 0;
        
        
        // Base case   
        if(grid == null || grid.length == 0)
            return 0;
        
        int [][] dirs = new int [][] {{0,-1}, {-1,0}, {1,0}, {0,1}};
        
        // Queue is a List of array of indices
        Queue <int []> q = new LinkedList<>();
        
        //Put all the already exisiting rotten oranges in the queue
        for(int i=0; i<m; i++) { // O(mn)
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2)   {
                    q.add(new int[] {i,j});
                }
                // At the end all our fresh oranges should be 0, if not return -1
                if(grid[i][j] == 1)   {
                    freshOranges++;
                }
            }   
        }
        
        // If no rotten oranges are present at the beggining, rotting cannot start
        if(freshOranges == 0) 
            return 0;
        
        while(!q.isEmpty()) { 
            
            // Q size to track the level
            int size = q.size();
            
            // Traverse all the elements in that level
            for(int k = 0; k < size; k++) { //O(mn) -> Each element can go in to queue at max once.
                
                int [] curr = q.poll();
                
                // Iteratively check neighbours of current element.
                for(int [] dir: dirs) {  // O(4)   -> Constant time.
                    // Neighbours row and coulmn
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                        
                    // Bound check 
                    // For top left corner elements r >=0 && c >=0 
                    //For bottom right corner elements r < m && c < n
                    
                     if(r >=0 && c >=0 && r < m && c < n && grid[r][c] == 1) {
                         
                         // Reduce fresh orange count
                         freshOranges--;
                         
                         //Since the neighbour is next to rotten orange, mark it as rotten
                         // And add to queue
                         grid[r][c] = 2;
                         // Add the position of the newly rotten element to the queue.
                         q.add(new int[]{r, c}); 
                     }     
                }
            }
            
            // After completion of each level, increment time elapsed.
            timeElapsed++;
        }      
        
        if(freshOranges == 0) return timeElapsed; 
    
        return -1;
    }
}
