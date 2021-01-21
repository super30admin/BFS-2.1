// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Find all the rotten oranges from the grid and add them in the queue. For each element in the queue, check all the fresh oranges in the 4-directionally adjacent positions in the grid, mark them as rotten and add them to the queue.Chcek for the number of fresh oranges left at the end and calculate the time required.

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null) return -1;
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();

        int freshCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    freshCount = freshCount + 1;
            }
        }
        
        if(freshCount == 0) return 0;
        
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        
        int time = 0;
        while(!q.isEmpty()){
                        
            time = time + 1;
            
            int size = q.size();
            
            for(int j = 0; j < size; j++){
                int[] rotten = q.poll();
                
                for(int i = 0; i < 4; i++){
                    int x = rotten[0] + dirs[i][0];
                    int y = rotten[1] + dirs[i][1];

                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshCount = freshCount - 1;

                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        
        return freshCount == 0 ? time - 1 : -1 ;
    }
}
