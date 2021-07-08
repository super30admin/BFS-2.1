import java.util.LinkedList;
import java.util.Queue;


/*
TC : O(N) where N is the size of the grid
SC : O(N) where N is the size of the grid
LC: yes
Problems : No
 */

/**
 * We perform BFS on the grid and use a variable fresh which keeps count of total fresh oranges initially and later we reduce the fresh count by 1,
 * everytime we rot a particular orange. Also, we keep a variable time and increment for every step of the BFS.
 * At the end, we check whether fresh is 0, that means all oranges rotten and return time else return -1
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if (fresh == 0)
            return 0;

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        fresh--;
                    }
                }

            }

            time++;

        }
        if (fresh != 0)
            return -1;

        return time - 1;

    }
}
