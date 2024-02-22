// Time complexity: O(m * n)
// Space complexity: O(m * n)
//Approach: BFS on all rotten oranges, put neighboring fresh oranges in 
// the queue. Process the current queue elements and increase the time unit.

import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        // coordinates of the rotten oranges
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // fresh oranges
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
                // rotten oranges
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        // no fresh oranges to begin with
        if (freshOranges == 0) {
            return 0;
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(size);

            // doing one level at at time to track of time
            while (size != 0) {
                int[] arr = queue.poll();

                for (int[] dir : dirs) {
                    int newRow = arr[0] + dir[0];
                    int newCol = arr[1] + dir[1];

                    // eligiblity check: inbounds and fresh orange
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) {
                        freshOranges--;
                        grid[newRow][newCol] = 2;
                        queue.add(new int[] { newRow, newCol });
                    }
                }
                size--;
            }
            time++;
        }

        // time - 1 as at the last level; an extra unit of time is added
        return freshOranges != 0 ? -1 : time - 1;

    }
}