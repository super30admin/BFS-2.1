// Time Complexity : O(mn)
// Space Complexity : O(mn) for the Queue of elements
// Did this code successfully run on Leetcode : Yes

/*
 * Approach:
 * We use BFS to find all the rotten oranges first (independent from other
 * cells) and then use BFS to traverse level-wise (here, it's minute-wise), and
 * make all the 4-directionally adjacent oranges as rotten. If in the end any
 * fresh oranges still exist, we return -1, else the number of minutes elapsed.
 */

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // check and update number of rotten oranges, and also
        // insert those rotten oranges in the Q, since those are the
        // "independent nodes" in our graph
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) { // add rotten
                    q.add(new int[] {i,j});
                } else if(grid[i][j] == 1) { // count fresh
                    fresh++;
                }
            }
        }

        if(fresh == 0) {
            return 0;
        }

        int mins = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // UDLR
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int[] c = q.poll();
                for(int[] d : dirs) {
                    int nr = c[0] + d[0];
                    int nc = c[1] + d[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // fresh becomes rotten
                        fresh--;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            
            mins++;
        }

        if(fresh > 0) {
            return -1;
        }

        return mins-1;
    }
}