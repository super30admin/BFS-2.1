// Tc O (m*n)
// Sc O (m*n)

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {
    public static void main(String[] args) {
        int[][] arr = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        RottingOrange obj = new RottingOrange();
        int obj1 = obj.orangesRotting(arr);
        System.out.println(obj1);
    }

    public int orangesRotting(int[][] grid) {

        // null case
        if (grid == null)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });

                }

            }

        }
        if (fresh == 0)
            return 0;
        int time = 0;
        // bfs
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dr : dir) {
                    int nr = dr[0] + curr[0];
                    int nc = dr[1] + curr[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[] { nr, nc });
                        fresh--;
                    }

                }

            }
            time++;
        }
        if (fresh != 0)
            return -1;
        return time-1;
    }
}
