//Time Complexity : O(m*n). time taken to loctae rotten oranges is O(m*n) 
//Space Complexity :O(1). if its inplace otherwise  O(m*n). In the worst case(when all are rotten oranges in the matrix) all the elements of the matrix eill go into queue.
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0){
            return -1;
        }
        int row = grid.length, col = grid[0].length;
        int time =0,fresh=0;
        Queue<int[]> q = new LinkedList<>();
        //find the locations of rotten oranges and add them to the queue
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        //If the given matrix had no fresh oranges then return the time as 0 as there is nothing left to rot
        if(fresh==0){
            return 0;
        }
        //otherwise, start the bfs traversal
        //maintain a directions array for getting the ajacent 4 sides
        int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int level = q.size();
            //for each lvel stat rotting
            for(int i=0;i<level;i++){
                int[] cur = q.poll();
                //check the four directions for rotting
                for(int dirs[] : dir){
                    int r = cur[0] + dirs[0];
                    int c = cur[1] + dirs[1];
                    if(r>=0 && r<row && c>=0 && c<col && grid[r][c]==1){
                        //rot this cell
                        grid[r][c] = 2;
                        //add the rotten loation to queue
                        q.add(new int[]{r,c});
                        //fresh oranges count reduces
                        fresh--;
                    }
                }
            }
            //at the end of each level increement time
            time++;
        }
        //after bfs if there are still fresh oranges left return -1
         if(fresh > 0){
        return -1;
    }
    return time-1;
    }
   
}