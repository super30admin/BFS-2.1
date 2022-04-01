// Time Complexity : O(m * n) where m and n are dimensions of grid
// Space Complexity : O(m * n) for queue max possible
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will find all the positions where the orange is rotten and add in a queue
// Now we will run loop while queue is not empty and mark all the neighbors which are fresh as rotten
// On exit we will check whether any of the oranges are fresh or not
// If we find any fresh orange we will return -1 otherwise we will return the result integer value which is the sum of level
// of queues  we explored

class Solution {
    int[][] directions = {{0,-1}, {0,1}, {1,0}, {-1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
        }
        }
        boolean firstTime = true;
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                int[] pos = q.poll();
                for(int[] dir: directions){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                         q.add(new int[]{x,y});
                    }
                }     
            }
            if(!firstTime)
                res++;
            firstTime = false;
        }
            
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return res;
        
    }
}