// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//994. Rotting Oranges
//https://leetcode.com/problems/rotting-oranges/

class Problem1 {
    // BFS Approach
    // time:O(mxn)
    // space:O(mxn)
    public int orangesRotting(int[][] grid) {
        int time = 0;
        // queue for storing rotten oranges
        Queue<int[]> q = new LinkedList<>();
        // scanning the whole grid for rotten oranges and getting the count of fresh
        // oranges
        int countFresh = 0; // count of fresh oranges
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        if (countFresh == 0)
            return 0;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int count = q.size();
        int size = count;
        count = 0;
        while (!q.isEmpty()) {

            for (int i = 0; i < size; i++) {
                // int[] temp = q.peek();
                int tempI = 0;
                int tempJ = 0;
                int c = 0;
                for (int k : q.peek()) {
                    if (c == 0)
                        tempI = k;
                    if (c == 1)
                        tempJ = k;
                    c++;
                }
                // int tempI = temp.[0];
                // int tempJ = temp.[1];
                for (int[] dir : dirs) {
                    int row = tempI + dir[0];
                    int col = tempJ + dir[1];
                    if ((row >= 0 && col >= 0 && row < m && col < n) && (grid[row][col] == 1)) { // searching for fresh
                                                                                                 // oranges
                        grid[row][col] = 2; // rotting the fresh oranges
                        q.add(new int[] { row, col }); // adding these new rotten ones to the queue
                        count++; // maintaining size of the queue at each bfs level
                        countFresh--; // decreasing count of fresh when added to rotten queue, when this number
                                      // becomes zero, all fresh ones are rotten
                    }
                }
                q.remove();
            }
            size = count;
            count = 0;
            time++; // incremeanting count after each level
        }
        if (countFresh == 0)
            return time - 1;
        else
            return -1;
    }
}

/*
 * class Solution {
 * int m;
 * int n;
 * int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
 * boolean flag = false;
 * int countFresh = 0;
 * public int orangesRotting(int[][] grid) {
 * 
 * m = grid.length;
 * n = grid[0].length;
 * for(int i=0; i<m; i++){
 * for(int j=0; j<n; j++){
 * if(grid[i][j] == 1){countFresh++;}
 * if(grid[i][j] == 2){ //System.out.println(grid[i][j] + " " + i + " " + j);
 * //do dfs
 * helper(grid, i, j, 3);
 * }
 * }
 * }
 * if(countFresh == 0) return 0;
 * int max = 0;
 * for(int i=0; i<m; i++){
 * for(int j=0; j<n; j++){
 * System.out.println(grid[i][j]);
 * //if(grid[i][j] == 1){ flag = true; break;}
 * if(grid[i][j] > max) max = grid[i][j];
 * }
 * }
 * 
 * if(flag) return -1;
 * else return max -2;
 * 
 * }
 * 
 * 
 * private void helper(int[][] grid, int i, int j, int time){
 * //base
 * if((i < 0 || j < 0 || i > m || j > n)) return;
 * 
 * //logic
 * for(int[] dir : dirs){
 * int row = i + dir[0];
 * int col = j + dir[1];
 * if((row >= 0 && col >= 0 && row < m && col < n) && (grid[row][col] != 2 &&
 * grid[row][col] != 0)){
 * if(time < grid[row][col] || grid[row][col] == 1)
 * grid[row][col] = time; System.out.println(grid[i][j] + "  row: " + row +
 * "  col: " + col);
 * helper(grid, row, col, time+1);
 * }
 * }
 * }
 * }
 */