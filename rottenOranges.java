class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) 
            return 0;
        int fresh = 0;
        Queue<int [] > q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int [] {i, j}); //pushing rotten oranges in queue
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) return 0;
        //directions array
        int [][] dirs = {{1,0}, {-1,0}, {0, 1}, {0,-1}}; 
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int [] curr = q.poll();
                for(int [] d : dirs){
                    int r = d[0] + curr[0];
                    int c = d[1] + curr[1];
                    
                    if(r >= 0 && r < grid.length && c >= 0 &&
                       c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int [] {r, c});
                        fresh --;
                    }
                }
            }
            time++;
        }
        //if still fresh oranges remain
        if (fresh > 0) return -1;
        return time - 1;
    }
}
