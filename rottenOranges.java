// Time Complexity = O(m * n)
// Space Complexity = O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS approach: Use queue to store all the rotten oranges, and trverse the grid to find fresh oranges to rot
class Solution {
    public int orangesRotting(int[][] grid) {
        int level = 0; // num of iterations needed to rot all orranges
        int fresh = 0; // count of frest oranges, to check at the end if all fresh oranges are rotten or not
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // Itterate the grid to find out all the rotten oranges and add them to the queue, also to count the fresh oranges
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If there are no oranges to rot, it will take 0 time
        if(fresh == 0) return 0;

        //Iterate over the queue elements to rot oranges itteratively
        while (!q.isEmpty()) {
            int size=q.size();
            for (int i=0; i<size; i++) {
                int[] node = q.poll();
                for (int[] dir: dirs) {
                    int nr = node[0] + dir[0];
                    int nc = node[1] + dir[1];

                    // check all the 4 neighbors, and see if there is a fresh orange to rot, and add it to the queue, and mark that field to 2, reduce fresh count
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == 1) {
                        q.add(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            level++;
        }

        // if some oranges could not be rotten return -1
        if(fresh != 0) {
            return -1;
        }

        return level-1;
    }
}