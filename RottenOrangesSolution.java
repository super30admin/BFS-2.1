// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;
class RottenOrangesSolution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        int total = 0, rotten = 0, time = 0;
		int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
                if (grid[i][j] == 2) 
                    q.add(new int[]{i, j});
            }
        }
        if (total == 0) 
            return 0;		
        
        while (! q.isEmpty()) {
            int size = q.size();
            rotten += size;
            if (rotten == total) 
                return time;            
            time++;
            for (int i = 0; i < size; i++) {
                int[] rottenIdx = q.peek();
				int x = rottenIdx[0];
                int y = rottenIdx[1];
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    q.add(new int [] {x + 1, y});
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    q.add(new int[]{x - 1, y});
                }
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    q.add(new int[]{x, y + 1});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    q.add(new int[]{x, y - 1});
                }
                q.poll();
            }
        }
        return -1;
    }
}