// Time Complexity :O(mxn) where m == grid.length and n==grid[i].length
// Space Complexity :O(mxn) where m == grid.length and n==grid[i].length
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class RottingOranges {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    class Pos {
        int r = -1, c = -1;

        Pos(int x, int y) {
            r = x;
            c = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;

        int fresh = 0;
        int rotten = 0;
        Queue<Pos> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pos(i, j));
                    rotten++;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (rotten == 0 && fresh == 0)
            return 0;

        int level = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                Pos curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr.r + dir[0];
                    int nc = curr.c + dir[1];

                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.offer(new Pos(nr, nc));
                        fresh--;
                    }
                }

            }
            level++;
        }

        return fresh == 0 ? level - 1 : -1;
    }
}