//BFS approach
// Time Complexity : O(m*n), going over all the nodes
// Space Complexity : O(m*n), queue can have all the elements if all of them are 2 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : push all the rotten oragnges in the queue, and then mark all neighbours as rotten
// before putting them in queue. Continue until connected components are put in the queue.

class Solution {

    public int orangesRotting(int[][] grid) {
        int time = 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // right, left , up , down
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if(count == 0 ) return 0; // when all oranges are rotten or there are no fresh oranges
        
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] rotten = q.poll();
                for (int[] dir : dirs) {
                    int nr = rotten[0] + dir[0];
                    int nc = rotten[1] + dir[1];

                    //bound check
                    if (nr >= 0 && nc >= 0 && nr < m & nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[] { nr, nc });
                        count--;
                        if(count == 0){ // optimization to not process last level
                            return time+1;
                        }
                    }
                }
            }
            time++; // will be processed 
        }
    // an extra time is processed after traversing the last elements. Therefore, time -1;
        return count > 0 ? -1 : time-1; 
    }
}

//DFS approach
// Time Complexity : O(m^2*n^2), Amortized O(m*n) for each dfs iteration from 2, number of iterations will get lower in each dfs cycle.
// Space Complexity : O(h), h = m*n, at max all elements can be in the recursive stack
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : run a seperate dfs at each rotten orange, and take the minimum time an element takes
// to getting rotten from every dfs cycle. Keep an offset and update the value with time to find minimum time.

class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // right, left , up , down
    public int orangesRotting(int[][] grid) {
        
        int count = 0;
        int offset = 2; // mark the itermediate times in dfs
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){// m*n
                if(grid[i][j] == 2){
                    dfs(grid, i, j, 2); // Amortized O(m*n);
                }
            }
        }
        int time = 2; // with offset
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }else{
                    time = Math.max(grid[i][j],time);
                }
            }
        }

        return time - offset;
    }

    private void dfs(int[][] grid, int i , int j, int time){
        int m = grid.length;
        int n = grid[0].length;

        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];

            //bound check
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (grid[nr][nc] == 1 || grid[nr][nc] > time+1)){
                grid[nr][nc] = time+1;
                dfs(grid,nr,nc,time+1);  
            }
        }
    }
}