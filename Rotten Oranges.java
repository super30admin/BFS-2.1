// Time Complexity = O(M*N)
// Space Complexity = O(m*n)


class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length ==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = new int [][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        Queue<int []> q = new LinkedList<>();
        
        int fresh = 0;
        int time = 0;
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new int []{i,j});
                }
                else if (grid[i][j] == 1){
                    fresh ++;
                }
            }
        }
        if(q.isEmpty() && fresh == 0) return 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i< size; i++){
                int [] curr = q.poll();
                for(int [] dir:dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if(nc >= 0 && nr >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                        q.add(new int[] {nr, nc});
                        grid[nr][nc] = 2;
                        fresh --;
                    }
                }
            }
            time++;
        }
        if(fresh == 0) return time-1;
        return -1;
    }
}