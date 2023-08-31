
// Time Complexity : O(m*n) --> no.of rows and cols
// Space Complexity : O(m*n) --> Queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

class Solution {
    public int orangesRotting(int[][] grid) {

        int fresh =0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][] {{0,-1},{-1,0},{0,1},{1,0}}; // neighbours cordinates from any cell
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){    // find no.of fresh oranges
                    fresh++;
                }
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j}); // add rotten oranges to queue
                }
            }
        }
        if (fresh ==0) return 0;  // no fresh oranges nothing to do

        int time =0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++)     // one level
            {
                int[] curr = queue.poll();
                for(int[] dir : dirs){    // check neighbours
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0&&nc>=0&& nr<m&& nc<n && grid[nr][nc]==1){  // check whether the indexes are valid while checking neighbours
                        grid[nr][nc]=2;
                        queue.add(new int[]{nr,nc});      // as the new orange is rotted add it to queue
                        fresh--; // no.of fresh oranges reduced by one when one orange is rotted.
                    }
                }
            }
            time++;   // after checking all levels it will be one extra

        }
        if(fresh!=0) return -1; // we were unable to rot all the oranges
        return time-1;   // return by reducing extra count
        
    }
    
}