/**

Leetcode: https://leetcode.com/problems/rotting-oranges/

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1.

Collabedit: http://collabedit.com/djt3b

Time Complexity : O(M*N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        if( grid == null || grid.length == 0)
            return -1;
            
        int m = grid.length; // rowCount 
        int n = grid[0].length; // columnCount
        
        // at the end the target should be to get fresh count == 0, else return -1;
        int fresh = 0;
        int time = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        
        // the BFS will be triggered independently on these rotten oranges, there by making the adjacent fresh oranges rotten
        for( int i =0 ;i < m; i++)
        {
            for( int j=0; j<n; j++)
            {
                if( grid[i][j] == 2)
                {
                    queue.add( new Pair(i,j));
                }
                else if(grid[i][j] == 1)
                    fresh++;
                    
            }
        }
        
        if(fresh == 0) return 0;
        
        int directions[][] = { {1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        while( !queue.isEmpty() )
        {
        
            int size = queue.size();
            
            for(int i = 0; i< size; i++)
            {
                 Pair current = queue.poll();
            
                for( int dirs[]: directions)
                {
                    int rowIndex = dirs[0] + current.row;
                    int colIndex = dirs[1] + current.col;
                
                    if(rowIndex >=0 && rowIndex <m && colIndex >=0 && colIndex<n && grid[rowIndex][colIndex] == 1)
                    {
                        // push to queue the fresh organge location
                        queue.add( new Pair(rowIndex, colIndex));
                        
                        // make the fresh orange rotten
                        grid[rowIndex][colIndex] = 2;
                        
                        //decrement the fresh count after making the fresh orange rotten
                        fresh--;
                    }
                }
            
            }
            
            
            time++;
        }
        
        if( fresh != 0)
            return -1;
            
        return time - 1;
        
        
            
        
    }
}
class Pair
{
    public int row;
    public int col;
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}