class Solution {
    public int orangesRotting(int[][] grid) {
        
        //edge case
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        
        
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        
        //adding rotten oranges position into queue 
        //also counting number of fresh oranges 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j ++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        
        int time = 0;
        
        //directions array
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        //iterating until the queue is not empty
        while(!queue.isEmpty()){
            int size = queue.size();
            
            //iterating through a level
            for(int x = 0; x < size; x++){
                int[] pair = queue.poll();
                
                // check all the possible direcyions which are valid and add it to the queue
                for(int[] dir: dirs){
                    int i = dir[0]+pair[0];
                    int j = dir[1]+pair[1];
                    
                    if(i >=0 && i < n && j >= 0 && j < m && grid[i][j] == 1){
                        grid[i][j] = 2;
                        queue.add(new int[]{i,j});
                        //every time u add elements in queue decrement the fresh count
                        fresh--;
                    }
                }
            }//level ends
            
            //increment time after every iteration
            time++;
        }
        
        //if fresh count is still not 0 return -1
        if(fresh!=0){
            return -1;
        } 
        
        //return 
        return time > 0 ? time - 1 : time;
    }
}

//TC : O(n*m)
//SC : O(1)