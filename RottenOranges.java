//TC: O(m*n) (BFS)
//SC: O(m*n) where m is the numbers of rows, n is the number of columns(BFS)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 2 - DFS
//TC: O(m*n)^2 - one call for BFS takes O(m*n) ; worst case all values in matrix can be 2. so (m*n)^2.
//SC: O(m*n) where m is the numbers of rows, n is the number of columns
class Solution {
    int[][] dirs;
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == 2){
                    dfs(grid,i,j,2,m,n);
                }
            }
        }

        int max =0;
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1)
                    return -1;

                if(grid[i][j] > 0)
                    max = Math.max(max, grid[i][j] - 2);
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int r, int c, int time, int m, int n){

        //base
        if(r < 0 || r == m || c < 0 || c == n || grid[r][c] == 0)
            return;

        if(grid[r][c] != 1 && grid[r][c] < time)
            return;


        //logic
        grid[r][c] = time;
        for(int[] dir: dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            dfs(grid,nr,nc,time+1,m,n);
        }
    }
}



//Method 1 - BFS
//TC: O(m*n) and SC: O(m*n) where m is the numbers of rows, n is the number of columns
/*
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        if(fresh == 0)
            return 0;

        int[][] dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i< size ; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        if(fresh == 0) return time +1;
                        q.add(new int[]{r,c});
                    }
                }
            }
            time++;
        }

        if(fresh != 0)
            return -1;

        else return time -1;
    }
}
*/