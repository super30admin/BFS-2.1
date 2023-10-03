// Time Complexity : O(m x n) visit all rows and columns
// Space Complexity : O(m x n) in worst case for queue space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.add(new int[] {row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }

        if(fresh != 0){
            return -1;
        }

        return time - 1;

    }
}
