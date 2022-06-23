// Time : O(m*n)
//Space : O(m*n)

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0} };
        Queue<int[]> q =new LinkedList<>();
        int freshCount = 0;
        for( int i =0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                else if (grid[i][j]==1)
                        freshCount++;
            }
        }
        
        if(freshCount==0)
            return 0;
        int time=0;
        while(!q.isEmpty())
        {   
            int size= q.size();
            for(int i =0;i<size;i++)
            {  
                int [] curr = q.poll();
                for(int[] d:dir)
                {
                    int nr = curr[0]+d[0];
                    int nc = curr[1]+d[1];
                    
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                        freshCount--;
                    }
                }
            }
            time++;
               
        }
        return freshCount==0?(time-1):-1;
        
        
    }
}