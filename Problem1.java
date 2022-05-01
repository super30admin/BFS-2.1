import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    public int orangesRotting(int[][] grid) {
        if (grid == null) return 0;

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int fOrange = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    que.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fOrange++;
                }
            }
        }
        if (fOrange == 0) return 0;
        int total = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] curr = que.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        que.add(new int[]{r, c});
                        fOrange--;
                    }
                }

            }
            total++;
        }
        if (fOrange != 0) return -1;
        return total - 1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        Problem1 problem1 = new Problem1();
        int result = problem1.orangesRotting(grid);
        System.out.println("Final value" + result);
    }
}
