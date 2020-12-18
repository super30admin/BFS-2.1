// Time - O(MN)
// Space - O(MN)

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return -1;
        }
        int fresh = 0, total = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[] { i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] el = q.poll();                            
                for(int[] dir : dirs) {
                    int r = el[0] + dir[0];
                    int c = el[1] + dir[1];

                    if(r < grid.length && r>= 0 && c < grid[0].length && c >=0) {
                        if(grid[r][c] == 1) {
                            grid[r][c] = 2;    
                            q.add(new int[] {r,c});
                            fresh--;
                        }
                    }                
                }
            }
            
            total++;
        }
        if(fresh > 0) {
            return -1;
        }
        
        return total - 1;
    }
}
