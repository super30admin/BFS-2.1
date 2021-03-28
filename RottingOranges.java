import java.util.LinkedList;
import java.util.Queue;
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return -1;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int time = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                for (int[] dir : dirs) {
                    int r = dir[0] + pair[0];
                    int c = dir[1] + pair[1];

                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            time++;
        }
        if (fresh != 0) return -1;
        return time > 0 ? time - 1 : time;
    }
}
