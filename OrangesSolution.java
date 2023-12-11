
//TC: O(m*n)
//SC: O(m*n)

import java.util.LinkedList;
import java.util.Queue;

public class OrangesSolution {
    public int orangesRotting(int[][] grid) {

      int m = grid.length;
      int n = grid[0].length;

      int[][] dir= new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

      int freshCount=0;
      int t=0;

      Queue<int[]> queue = new LinkedList<>();

      for(int i=0; i< m; i++){
        for(int j=0; j< n; j++){

          if(grid[i][j]==2){
            queue.add(new int[]{i,j});
          }
          else if(grid[i][j]==1){
            freshCount++;
          }
        }
      }

      if(freshCount==0){
        return 0;
      }

      while(!queue.isEmpty()){

        int size=queue.size();

        while(size>0){

          int[] curr = queue.poll();
          for(int[] d : dir){

            int r= d[0] + curr[0];
            int c= d[1] + curr[1];

            if( r>=0 && c>=0 && r<m&& c<n && grid[r][c]== 1){
              grid[r][c]= 2;
              freshCount--;
              queue.add(new int[]{r,c});
            }
          }
          size--;
        }
        if(freshCount==0){
          return t+1;
        }
        t++;

      }
      return -1;
    }

  }
