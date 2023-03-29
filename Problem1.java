// Time Complexity : O(m^2 * n^2)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
 * Keep a direction array and traverse all the neighbors if orange is rotten. 
 * Add all the oranges which are rotten at a particular level. 
 * Traverse the child nodes of it using BFS and add it to the queue and change the oranges that are 1 to 2. 
 * Return time + 1 for each level and subtract 1 at the end to ignore the time taken to move from last node to out of bounds. 
 */

class Problem1 {
    int dirs[][]= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int m = grid.length; 
        int n = grid[0].length; 
        if( grid == null)
            return 0; 
        int fresh = 0; 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh == 0)
            return 0; 
        int time = 0; 
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr[] = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh != 0)
            return -1;
        return time - 1;
    }
}