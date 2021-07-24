
// Time Complexity : o(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid==null || grid.length==0)
            return 0;
        
        int fresh=0;
        int time=0;
        int m=grid.length;
        int n=grid[0].length;
        
        Queue<Integer> queue=new LinkedList<>();
        
        //find rotten oranges and fresh oranges
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(i);
                    queue.add(j);
                }
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        
        if(fresh==0)
            return 0;
        
        int dirs[][]={{-1,0},{0,-1},{0,1},{1,0}};
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int k=0;k<size;k+=2)
            {
                int r=queue.poll();
                int c=queue.poll();
                
                for(int[] dir:dirs)
                {
                    int nR=r+dir[0];
                    int nC=c+dir[1];
                    
                    if(nR>=0 && nR<m && nC>=0 && nC<n && grid[nR][nC]==1)
                    {
                       grid[nR][nC]=2; 
                        fresh--;
                        queue.add(nR);
                        queue.add(nC);   
                    }
                           
                }
            }
            time++;
        }
        if(fresh!=0)
            return -1;
        
        return time-1;
    }
}