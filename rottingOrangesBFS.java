class Solution {
    //BFS APPRAOCH
    //tc: o(m * n) sc: o(m * n)
    //classic bfs problem where we are concerned with immediate neightbours (children nodes) 
    //make the immediate children rot based on a parent rotten orange
    //made use of size variable to keep track of 'minutes' which is nothing but we are keeping track of level of the tree
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        int time = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        q.add(new int[] {r, c});
                        grid[r][c] = 2;
                        fresh--; // we keep track of fresh variable to keep track if all fresh oranges are rotten as req. by the question
                    }
                }
            }
            time++;
        }
        if(fresh != 0) {
            return -1;
        }
        return time - 1; // it is time - 1 cuz when the last orange comes in we won't be entering the if condition in line 38 but we will end up adding time++
        // which results in one more level to bring it back we do time - 1
    }
}