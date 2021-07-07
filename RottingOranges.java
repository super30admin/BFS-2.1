// Time Complexity : O(m * n)
// Space Complexity : O(m * n)

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n;j++){
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
            }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if(fresh == 0)
            return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                int[] element = q.poll();
                for(int[] dir:dirs){
                    int r = element[0] + dir[0]; 
                    int c = element[1] + dir[1];
                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){
                        q.add(new int[]{r,c});
                        grid[r][c] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0? time - 1: -1;
    }
}