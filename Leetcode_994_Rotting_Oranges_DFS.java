//dfs apporach
//tc-O(m*n)^2
//sc- O(mn)^2

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        boolean found = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;

        while(found) {
            List<int[]> list = new ArrayList<>();            
            found = false;
            count++;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 2) {
                        list.add(new int[] {i, j});                        
                    }
                    else if(grid[i][j] == 1) {
                        found = true;                        
                    }
                }
            }
            for(int i = 0; i < list.size(); i++) {
                int[] curr = list.get(i);
                for(int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                    }
                }
            }
            if(count > m * n) break;
        }
        if(count > m * n) return -1;
        return count - 1;

    }
}