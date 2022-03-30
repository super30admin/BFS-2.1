// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null)    return 0;
        
        int m = grid.length; int n = grid[0].length;
        
        int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        int freshOr = 0;
        
        //Calculating the fresh oranges and adding the rotten oranges in the Queue
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 1) freshOr++;
                if(grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        
        if(queue.isEmpty() && freshOr == 0) return 0;
        
        int time = 0;
        
        //Using BFS
        while(!queue.isEmpty()){
            
            int s = queue.size();
            
            for(int i = 0; i< s; i++){
                
                int[] temp = queue.poll(); //POLLING EACH PAIR OF ROTTEN ORANGE FROM QUEUE
                for(int[] curr : d){   //CHECKING 4 NEIGHBOURS OF THAT CELL 
                    int x = temp[0] + curr[0];
                    int y = temp[1] + curr[1];
                    
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1){  //If it is fresh, add that indices pair in queue
                        queue.add(new int[]{x, y}); 
                        grid[x][y] = 2; // Make it rotten and decrement the no. of fresh oranges by 1
                        freshOr-- ;
                    } 
                }
            }
            
            time++;
        }
        
        if(freshOr != 0)    return -1;
        
        return time-1;  //Return time-1 counter which specifies no. of minutes needed.
    }
}

