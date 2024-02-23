/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
    m = total rows
    n = total cols
* 
* Space Complexity: O(m*n)
* 
*/

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesBFS {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;

        int m = grid.length;

        int n = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    freshCount++;
                } else if (grid[row][col] == 2) {
                    queue.add(row);
                    queue.add(col);
                }
            }
        }

        int time = 0;

        if (freshCount == 0) {
            return time;
        }

        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size() / 2;

            for (int index = 0; index < size; index++) {
                int row = queue.poll();
                int col = queue.poll();

                for (int[] dir : dirs) {
                    int nrow = dir[0] + row;
                    int ncol = dir[1] + col;

                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                        queue.add(nrow);
                        queue.add(ncol);

                        grid[nrow][ncol] = 2;

                        freshCount--;
                    }
                }
            }

            time++;
        }

        if (freshCount != 0)
            return -1;

        return time - 1;
    }
}
