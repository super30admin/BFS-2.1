// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//994. Rotting Oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        int level = 0;
        int[][] dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
                else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return 0;
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int i = 0; i < qsize; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr < m && nr >= 0 && nc < n && nc >= 0 && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                        freshCount-- ;
                    }
                }
            }
            level++;
        }
        if(freshCount != 0) return -1;
        return level - 1;
    }
}