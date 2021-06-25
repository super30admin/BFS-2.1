class Solution {
    // Time Complexity: O(n)
    // Space complexity: O(n)
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        
        
        int step = -1;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                grid[x][y] = 2;
                
                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1 && !visited[nx][ny]){
                        
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
                
            }
            
            step += 1;
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return step == -1? 0:step;
        
        
    }
}