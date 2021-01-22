

// Time Complexity : O(Nˆ2) x O (Nˆ2) | OuterFor loop and recursive
// Space Complexity : O(Nˆ2) (Considering recursive stack space)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time limit exceeded

/* approach
  1. Go through all oranges, if it is ROTTEN then check all neighbouring oranges and make them ROTTEN
  2. in dfs each recursive call check for index if they are within bounds
   then make it rotton and continue dfs on each of those neighbours
*/


class RottenOranges {

  static int ROTTEN = 2;
  static int FRESH = 1;

  public int orangesRotting(int[][] grid) {
      int time = 0;
      for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
              time += dfs(grid, i, j, 0);
          }
      }

       for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
              if(grid[i][j] == FRESH){
                  return -1;
              }
          }
      }

      return time;

  }

  private int dfs(int[][] oranges, int i, int j, int minutes){
      // base
      if(i < 0 || i >= oranges.length || j < 0 || j >= oranges[0].length)
          return minutes;

      if(oranges[i][j] == FRESH) {
          oranges[i][j] = ROTTEN;
      }else {
          return minutes;
      }

      // logic

      // this rotten will infect neighbouring 4 oranges
          int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

          for(int[] curr : directions){
              int new_i = i + curr[0];
              int new_j = j + curr[1];

              dfs(oranges, new_i, new_j, minutes+1);

          }

      return minutes;
  }

  private static int rottenOranges(int[][] grid){

    // BFS
    int fresh = 0;
    int time = 0;
    int m = grid.length;
    int n = grid[0].lenght;

    Queue<int []> q = new LinkedList<>();
    for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
          if(grid[i][j] == ROTTEN){
            q.add(new int[]{i,0});
          }else if( grid[i][j] == FRESH){
            fresh++;
          }
        }
    }

    if(fresh == 0) return 0;
    int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

    while(!q.isEmpty()){
      // we are distinguishing at each level.
      // at each level we're incrementing the minute and making max 4 oranges so we need a size var
      
      int size = q.size();
      for(int i = 0 ;i < size; i++){
        int [] curr = q.poll();
        for(int[] dir : directions){
          int r = curr[0] + dir[0];
          int c = curr[1] + dir[1];
          if(r >= 0 && r < m && c >= 0 && c < n && grid[i][j] == FRESH){
            grid[r][c] = ROTTEN;
            q.add(new int[]{r,c});
            fresh--;
          }
        }
        time++;
      }
    }

    if(fresh == 0){
      return time -1;
    }else{
      return -1;
    }

  }
}
