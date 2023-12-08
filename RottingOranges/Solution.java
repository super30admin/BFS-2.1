// Time Complexity : DP: O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Use BFS. Add all the rotten oranges in a queue, calculate the number of fresh oranges. Calculate size of queue before iterating the queue,
 * iterate over the queue size time, check in 4 directions for each orange in the queue. Turn all the neighbouring fresh oranges to rotten,
 * add those to the queue. Increment time at each cycle. Do this until the queue is empty. If fresh count is 0, return time-1, else -1.
 */
class Solution {
    public int orangesRotting(int[][] grid) {

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0) return time;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int[] current = q.poll();
                for(int[] dir: dirs) {

                    int row = current[0] + dir[0];
                    int col = current[1] + dir[1];

                    if(row>=0 && col>=0 && row<m && col<n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.add(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }

        //Doing time-1 because in the 2nd last cycle all possible fresh oranges will be rotten, so those are added in the queue.
        // Hence, While processing last cycle, there are no fresh oranges or those can't be rotten. So that time will not be counted.
        if(fresh == 0) return time-1;

        return -1;
    }
}