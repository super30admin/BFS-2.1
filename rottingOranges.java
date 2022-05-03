/**
Problem: https://leetcode.com/problems/rotting-oranges/
*/

/**
Approach 1: BFS
TC: O(m * n)
SC: O(m * n)
*/
class Solution {
    class Position {
        int i, j;
        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        public void print() {
            System.out.println("i: " + i + ", j: " + j);
        }
    }

    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    public int orangesRotting(int[][] grid) {
        int minutes = -1;

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return minutes;
        }
        
        Queue<Position> queue = new LinkedList<>();
        
        int freshOrangeCount = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    Position p = new Position(i, j);
                    queue.add(p);
                } else if (grid[i][j] == 1) {
                    ++freshOrangeCount;
                }
            }
        }

        // We found no rotten oranges which could mean:
        // 1. We found onl fresh oranges and empty cells in which case we return -1;
        // 2. We found only empty cells in which case we return 0;
        if (queue.size() == 0) {
            if (freshOrangeCount > 0) {
                return -1;
            }
            return 0;
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Position p = queue.poll();
                for (int dir[] : dirs) {
                    int x = p.i + dir[0];
                    int y = p.j + dir[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
                        continue;
                    queue.add(new Position(x, y));
                    grid[x][y] = 2;
                    --freshOrangeCount;
                }
            }
            ++minutes;
        }

        if (freshOrangeCount > 0)
            return -1;
        return minutes;
    }
}

/**
Approach 2: DFS
TC: O(m*n)^2
SC: O(m*n)
*/
class Solution {
    int m, n;
    int[][] visited;
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, visited[i][j]);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    return -1;
                }
            }
            System.out.println();
        }
        return max == 0 ? 0 : max;
    }
    private void dfs(int[][] grid, int row, int col, int lvl) {
        //base
        //logic
        int temp = grid[row][col];
        grid[row][col] = 2;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                if(visited[r][c] == 0) {
                    visited[r][c] = lvl + 1;
                }
                else {
                    visited[r][c] = Math.min(visited[r][c], lvl + 1);
                }
                dfs(grid, r, c, lvl + 1);
            }
        }
        grid[row][col] = temp;
    }
}
