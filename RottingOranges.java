/*The time complexity of this implementation is O(mn)
* and space complexity is O(mn)*/
import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Initialize a queue to hold the coordinates of all rotten oranges
        Queue<int[]> rotten = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!rotten.isEmpty()) {
            int size = rotten.size();
            boolean changed = false;

            for (int i = 0; i < size; i++) {
                int[] curr = rotten.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || grid[newX][newY] != 1) {
                        continue;
                    }

                    // If the orange at the new coordinate is fresh, mark it as rotten and add it to the queue
                    grid[newX][newY] = 2;
                    rotten.add(new int[]{newX, newY});
                    changed = true;
                }
            }

            if (changed) {
                minutes++;
            }
        }

        // Check if there are any fresh oranges left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int minutes = solution.orangesRotting(grid);
        System.out.println("Minutes taken to rot all oranges: " + minutes);
    }

}
