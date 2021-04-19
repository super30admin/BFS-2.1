//APproach - BFS
//Time Complexity - O(MxN) - M is number of rows in grid and
//                           N is number of columns in grid
//Space Complexity - O(MxN) - size of the queue to put all the grid elements

class Solution {
  public int orangesRotting(int[][] grid) {
    if(grid == null || grid.length == 0){
      return 0;
    }

    int freshOrangesCount = 0;
    int totalTime = 0;
    Queue<int[]> queue = new LinkedList<>();

    int m = grid.length;
    int n = grid[0].length;
    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(grid[i][j] == 1){
          freshOrangesCount++;
        }
        else if(grid[i][j] == 2){
          queue.add(new int[]{i,j});
        }
      }
    }

    if(freshOrangesCount == 0) { return 0; }
    while(!queue.isEmpty()){

      int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
      int size = queue.size();
      for(int i=0; i<size; i++){
        int[] coord = queue.poll();

        for(int[] dir: dirs){
          int r = coord[0] + dir[0];
          int c = coord[1] + dir[1];

          if(r >= 0 && r<m && c >= 0 && c <n && grid[r][c] == 1){
            grid[r][c] = 2;
            queue.add(new int[]{r,c});
            freshOrangesCount--;
          }
        }
      }
      totalTime++;
    }

    if(freshOrangesCount > 0){
      return -1;
    }
    return totalTime-1;
  }
}