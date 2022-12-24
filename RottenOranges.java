import java.util.Queue;
import java.util.LinkedList;


//Time Complexity : O( M * N) because traversing the whole tree
//Space Complexity :O(M * N) because whole matrix can be rotten 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :


public class RottenOranges {
	  
    // Idea is to use grouping and use BFS. As a rule of BFS ALL rotten oranges of initial matrix will go first in Queue and thn their neihbours.While finding oranges at first level find total oranges count as well. 
    
    public int orangesRotting(int[][] grid) {
      
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int fresh=0;
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
      //Create Queue 
        Queue<int[]> queue = new LinkedList<>();
    
        // populate first level of rotten oranges in the  queue 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        if(fresh ==0)
            return 0;
        
       if(queue.isEmpty())
           return -1;
        
        while(!queue.isEmpty()){
            // level order traversal 
            int size = queue.size();
            count++;
            
            for(int i=0;i<size;i++){
                int[] node = queue.poll();
    
                   for(int[] dir:dirs){
                     int nr = dir[0]+node[0];
                     int mc = dir[1]+node[1];
                    if(nr<0 || nr >=n || mc<0 || mc>=m ||grid[nr][mc] ==0)  
                       continue;
                      if(grid[nr][mc] ==1){
                         grid[nr][mc] = 2;
                          queue.add(new int[]{nr,mc});
                          fresh--;
                     }  
                   } 
                }
            }
        
        if(fresh!=0)
            return -1;
        else return count-1;
    }
}
