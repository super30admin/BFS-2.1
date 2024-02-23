
// TC - Amortized O(MN)
// TC - O(M*N * M*N)
// SC - O(MN)

public class RottingOrangesDFS {
    class Solution {
        private final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        public int orangesRotting(int[][] grid) {
            int time = 2; // Offset for time because returning time-2;
            int rows = grid.length;
            int cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2) {
                        dfs(grid, i, j, 2);
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                    time = Math.max(time, grid[i][j]);
                }
            }
            return time - 2;
        }

        private void dfs(int[][] grid, int row, int col, int time) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return;
            }

            if (grid[row][col] == 0) {
                return;
            }

            if (grid[row][col] != 1 && grid[row][col] < time) {
                return;
            }

            grid[row][col] = time;

            for (int[] dir : dirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];
                dfs(grid, currRow, currCol, time + 1);
            }
        }
    }
}
