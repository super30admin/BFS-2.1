// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes, tough problem to understand though, still learning

// Three line explanation of solution in plain english
// Creating a queue for all bad oranges and then iterate until no bad oranges are left
// Iterate over the grid several times and each iteration is 1 unit of time.

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int []> q = new LinkedList<>();//create int
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int [] {i,j});//add all bad oranges to queue
                }
                if(grid[i][j] == 1) fresh++;  
            }
                      
        }
        if(fresh == 0) return 0;
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){//only iterating over the bad orange's neighbors
                int [] curr = q.poll();
                for(int [] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r>=0 && c>= 0 && r<m && c<n && grid[r][c] ==1){//has to be in bounds of m*n
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                    
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time-1;
    }
}