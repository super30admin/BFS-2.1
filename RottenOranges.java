/**
Time Complexity : O(M*N)
Space Complexity : O(M*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes

**/
class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i =0 ;i < rows; i++)
        {
            for(int j=0;j < cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    freshCount++;
                }
                else if(grid[i][j] == 2)
                {
                    queue.add(new int[]{i,j});
                }
                    
            }
        }
        
        if(freshCount == 0)
            return 0;
        
        int dirs[][] = new int[][]{{0,-1},{0,1},{1,0}, {-1,0}};
        int time = -1;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i =0; i< size; i++)
            {
                int curr[] = queue.poll();
                
                for(int dir[]: dirs)
                {
                    int currx = curr[0] + dir[0];
                    int curry = curr[1] + dir[1];
                    
                    boolean isValidNeighbour = currx >=0 && currx < rows && curry >=0 && curry < cols;
                    if(isValidNeighbour)
                    {
                        boolean isFreshNeighbour = grid[currx][curry] == 1;
                        if(isFreshNeighbour)
                        {
                            grid[currx][curry] = 2;
                            queue.add(new int[]{currx,curry});
                            freshCount--;
                        }
                    }
                }
            }
            
            time++;
        }
        
        if(freshCount!=0)
            return -1;
        
        return time;
        
    }
    
    
}