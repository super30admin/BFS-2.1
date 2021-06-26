package BFS2_1;

import java.util.LinkedList;
import java.util.Queue;

public class question62_RottingOranges {
    /* Created by palak on 6/23/2021 */

    /*
        Time Complexity: O(m * n)
        Space Complexity: O(m * n)
    */
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        if(fresh == 0) return 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i = i+2) {
                int row = queue.poll();
                int col = queue.poll();
                for(int [] dir: dirs) {
                    int nrow = dir[0] + row;
                    int ncol = dir[1] + col;
                    if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        queue.add(nrow);
                        queue.add(ncol);
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time - 1;
    }
}
