// Time Complexity : o(m*n)
// Space Complexity :o(m*n) where n is the diameter of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int m = grid.length; int n = grid[0].length;
        int fresh =0; int count =0;
        int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh == 0) return 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i =0; i < size; i++)
            {
                int[] curr = q.poll();
                for(int[] dir: dirs)
                {
                    int r = dir[0]+curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] ==1){
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            count++;
        }
        if(fresh != 0) return -1;
        return count-1;
    }
}