class RottingOranges {
    
    // Time Complexity: O(nm)   (where n -> no. of rows and m -> no. of columns)
    // Space Complexity: O(nm)
    
    public int orangesRotting(int[][] grid) {
        // Edge Case Checking
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        // Intitalizing Queue for BFS
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        
        // Getting the count of fresh oranges and adding rotten oranges to queue
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2)
                    q.offer(new int[]{i,j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        
        int time = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Start from the rotten orange in the queue - traverse in all four directions to find fresh oranges -> turn it into rotten orange and continue the process.
        // Decrement the count of fresh orange count everytime it is converted to rotten orange
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] pair = q.poll();
                
                for(int[] dir : dirs){
                    int row = dir[0] + pair[0];
                    int col = dir[1] + pair[1];
                    
                    if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row,col});
                        fresh--;
                    }
                }
            }
            
            // After each level - increase the time
            time++;
        }
        
        // If we still have fresh oranges in the grid - return -1 
        if(fresh != 0)
            return -1;
        
        // If no fresh oranges and our time is greater than zero -> return time-1 else return time (special case --> [[0]])
        return time > 0 ? time - 1 : time;
    }
}