//Time complexity - O(m*n)
//Space Complexity - O(m*n)

class Solution {
    public int orangesRotting(int[][] grid) {
      if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)       {
        return 0;
      }
      int m = grid.length;
      int n = grid[0].length;
      int fresh = 0;
      int time = 0;
      //add row and column in the queue
      Queue<Integer> q = new LinkedList<>();
      for(int i= 0; i< m; i++) {
        for(int j = 0; j< n ; j++) {
          if(grid[i][j] == 1) fresh++; // check fresh count
          if(grid[i][j] == 2) { //add rotten oranges at time 0
            q.add(i);
            q.add(j);
          }
        }
      }
      System.out.println(q);
      
      if(fresh == 0) return 0;
      int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
      while(!q.isEmpty()) {
        int size = q.size();
        for(int i = 0; i< size; i = i+2) {
          int r = q.poll(); //get the rotten ornage from q by popping row and column
          int c = q.poll();
          for(int [] dir : dirs) {
            //get neighbor oranges
            int nr = r + dir[0];
            int nc = c + dir[1];
            System.out.println("nr " + nr + " nc " + nc);
            if(nr>= 0 && nc >= 0 && nr <m && nc < n && grid[nr][nc] == 1) {
              //fresh ---> rotten
              grid[nr][nc] = 2;
              q.add(nr);
              q.add(nc);
              fresh --;
            }
            
          }
        }
        // increase the time taken to rot the fresh ornage
        time ++;
      }
      if(fresh != 0) return -1;
      return time-1;
    
    }
}