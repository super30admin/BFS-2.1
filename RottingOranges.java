//Problem : 62 - Rotting Oranges
// Time Complexity : O(m*n), m stands for grid rowns and n stands for grid columns
// Space Complexity : O(m*n)-> because we are exponentially increasing at every node
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
  As rotting can take start from any coordinates and will occur simultaneously, so BFS will be implemented and do the following
     1) Iterate over the grid and insert rotting oranges coordinates in the queue.Simulatneously, if oranges are fresh keep a count of them
     2) If no orange is fresh return 0;
     3) Now itearate over the queue and make adjacent oranges rotten and add rotten oranges in the queue and once one level is finished, increase the time.
     4) As we will be emptying the whole queue, even all the oranges are rotten in that case time will be increment 1 counter ahead, so return time-1;  
*/

/*
  Note : Here for this question DFS will not be a suitable/optimised option because DFS will go either "Right->Bottom->Left->Up" or "Bottom->Right->Up->Left" and for each case we will be calculating minimum time to make orange rotten as well as a visited array is also required to make sure, same node is not visited again and again. Here, DFS will be inefficent, thats why use the concept of BFS over here.
*/

import java.util.*;
class Solution62 {
    public int orangesRotting(int[][] grid) {
        
        //TC: O(m*n) | SC: O(m*n)-> because we are exponentially increasing at every node
        if(grid==null || grid.length==0) return 0;
        
        int fresh =0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                   q.offer(new int[]{i,j}); 
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        
        if(fresh==0) return 0;
        
        int time =0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                  int[] curr = q.poll();
                  fresh = helper(grid,curr[0],curr[1],q,fresh); 
            }
            time++;
        }
        
        if(fresh>0) return -1;
        
        return time-1;
    }
    
    //Returning remaining fresh oranges count
    private int helper(int[][] grid,int i, int j,Queue<int[]> q,int fresh){
        //Assume u r at at 0,0
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for(int[] dir : dirs){
            
            int r = i+dir[0];
            int c = j+dir[1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1){
                grid[r][c] = 2;
                q.offer(new int[]{r,c});
                fresh--;
            }
            
        }
        return fresh;
    }
    
    
}