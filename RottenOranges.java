// BFS
// TC:O(M*N) -> M, N - dimensions of grid
// SC:O(M+N) -> M, N - dimensions of grid
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int orangesRotting(int[][] grid) {
        if ( grid == null || grid[0].length == 0)
            return -0;
        Queue<int[]> q = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for ( int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                // if rotten
                if (grid[i][j] == 2)
                {
                    q.offer(new int[]{i,j});
                }
                else if (grid[i][j] == 1)
                {
                    fresh++;
                } 
            }
        }
        int time = 0;
        if ( fresh == 0) return 0;
        while ( !q.isEmpty() )
        {
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                int[] current = q.poll();
                for (int[] dir: dirs )
                {
                   int r = current[0] + dir[0];
                   int c = current[1] + dir[1];
                   if (r >= 0 && c>=0 && r < m && c < n && grid[r][c] == 1)
                   {
                       fresh--;
                       grid[r][c] = 2;
                       q.offer(new int[] {r,c});
                   }
                 }  
            }
         time++;
        }
        if ( fresh == 0 )
            return time - 1;
        return -1;
    }
}
