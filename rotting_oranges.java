class Solution {
     public int orangesRotting(int[][] grid){
         if(grid == null || grid.length == 0) return 0; //if there is no values in the grid, we return 0;
         int m = grid.length; // m stores the value of no. of rows present in the grid
         int n = grid[0]. length; // n stores the values of no. of columns present in the grid.
         int[][] dirs = new int[][]{{0,-1},{0, 1}, {1, 0}, {-1, 0}}; // these are the directions we move from the current element to its surroundings.
         Queue<int[]> q = new LinkedList<>(); // we take the queue with name as q and its input values as integer array. We are using a queue because we are performing a BFS approach which requires a fifo property.
         int fresh = 0; // we are initializing a variable fresh to 0, which stores the no. of fresh oranges.
         for(int i = 0; i < m; i++){ // we are going through the rows present in the grid
             for(int j = 0; j < n; j++){ // we are going through the columns present in the grid.
                 if(grid[i][j] == 1){ // if the element in the grid is having a value 1, we increment the fresh by 1 which says that 1 indicates a fresh orange.
                     fresh++;
                 }
                 else if(grid[i][j] == 2){ // if we see a 2 in the grid, it means that it is a rotten orange.
                     q.add(new int[] {i,j}); // so, we add the location of the rottenn orange to the queue.
                 }
             }
         }
         if(fresh == 0) return 0; // if there are no fresh oranges in the grid, we return a 0;
         int time = 0; // we take a variable called as time which stores the time required to convert the fresh oranges to rotten oranges.
         while(!q.isEmpty()){ // while the q is not empty
             int size = q.size(); //we store the size of the queue
             for(int i = 0; i < size; i++){ // we iterate through the elements present in the queue
                 int[] curr = q.poll(); // we pop the element from the queue and store it in an integer array with name curr.
                 for(int[] dir : dirs){ //we go through all the directions of the curr
                     int nr = curr[0] + dir[0]; // we compute the new row.
                     int nc = curr[1] + dir[1]; // we compute the new col.
                     if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){ // if the new row and new col satisfy these conditions and if the surroundings are having a fresh orange
                         grid[nr][nc] == 2; // we change the location of fresh orange to rotten orange;
                         fresh--; // we reduce the fresh oranges by 1.
                         q.add(new int[]{i, j}); // we add the location of the rotten orange to the queue.
                     }
                 }
             }
             time++ // we increment the time by 1;
         }
         if(fresh != 0) return -1; // if there are fresh oranges still present in the grid, we return -1;
         return time -1;
     }
}
// tc and sc - o(m*n)