// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Go through the matrix and add all the rotting oranges index to the queue, also maintain the cnt of fresh oranges, then bfs on the values of the queue, maintain the level and add the fresh oranges to the queueu and reduce its cnt, the end if cnt != 0 return -1 else return level-1; innitially level start at 0 index
// Your code here along with comments explaining your approach
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = new int [][] {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int []> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int []{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int  i = 0; i < size; i++){
                int [] curr = q.poll();
                for(int [] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n
                       && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int [] {nr,nc});
                    }
                }
            }
            level++;
        }
        if(fresh > 0) return -1;
        return level-1;
    }
}
