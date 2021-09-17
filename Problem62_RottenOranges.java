// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        int time = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                } else if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }
        if(fresh == 0)
            return 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                for(int[] dir : dirs) {
                    int row = dir[0] + point[0];
                    int col = dir[1] + point[1];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0 && grid[row][col] != 2) {
                        grid[row][col] = 2;
                        fresh--;
                        q.add(new int[] {row, col}); 
                    }
                }   
            }
            time++;
        }
        if(fresh != 0)
            return -1;
        else
            return time - 1;
    }
}