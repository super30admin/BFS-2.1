class Solution {
    public int orangesRotting(int[][] grid) {
        
        int freshCount=0;
        int level=0;
        Queue<int[]> queue=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int[][] dirs={{0,-1},{0,1},{1,0},{-1,0}};
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
                if(grid[i][j]==1)
                    freshCount++;
            }
        }
        
        if(freshCount==0) return 0;
        
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            level++;
            for(int i=0;i<size;i++)
            {
                int[] arr=queue.poll();
                for(int[] dir : dirs)
                {
                    int nr=arr[0]+dir[0];
                    int nc=arr[1]+dir[1];
                    if(nr>=0&&nr<m && nc>=0&&nc<n && grid[nr][nc]==1)
                    {
                        freshCount--;
                        grid[nr][nc]=2;
                        queue.add(new int[]{nr,nc});
                    }
                }     
                
            }            
        }
        if(freshCount!=0) return -1;
        
        return level-1;
        
        
    }
}

// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
