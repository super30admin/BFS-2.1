// Time Complexity : O(N) Where N is size of grid
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0)
            return 0;
        if(queue.isEmpty())
            return -1;

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        int timeElapsed = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] temp = queue.poll();

                for(int[] dir: dirs) {
                    int row = dir[0] + temp[0];
                    int col = dir[1] + temp[1];


                    if(row<m && row>=0 && col<n && col>=0 && grid[row][col] == 1) {
                        freshOranges--;
                        grid[row][col] = 2;
                        queue.add(new int[]{row,col});
                    }
                }
            }
            timeElapsed++;
        }

        if(freshOranges == 0)
            return timeElapsed;

        return -1;

    }
}