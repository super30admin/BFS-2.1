import java.util.LinkedList;
import java.util.Queue;

// TC - O(MN)
// SC - O(MN)

public class RottingOrangesBFS {

    class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        int time = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] currCell = queue.poll();
                int currRow = currCell[0];
                int currCol = currCell[1];
                for (int[] dir : dirs) {
                    int row = currRow + dir[0];
                    int col = currCol + dir[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.add(new int[] { row, col });
                        freshCount--;
                        if (freshCount == 0) {
                            return time + 1; // Add 1s for current iteration as it is being added after current level
                        }
                    }
                }
                size--;
            }
            time++; // Add time after each level
        }

        if (freshCount > 0) {
            return -1;
        }

        return time - 1;
    }
}
}