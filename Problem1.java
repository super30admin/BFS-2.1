// Time Complexity : O(m*n)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//By BFS take a freshorange count and numberOflevels in queue. store all the totten orange in queue and pop
//one by one adding its 4 directional neighours and changing them to rotten.

import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    public int orangesRotting(int[][] grid) {
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return count;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                for (int[] d : dir) {
                    int r = temp[0] + d[0];
                    int c = temp[1] + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            count++;
        }

        if (fresh == 0) return count - 1;
        return -1;
    }

    public static void main(String[] args) {
        // Example Usage
        // Create a grid for testing
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        Problem1 solution = new Problem1();
        int result = solution.orangesRotting(grid);

        // Print the result
        System.out.println("Time to rot all oranges: " + result);
    }
}
