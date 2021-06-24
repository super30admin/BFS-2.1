// Time Complexity : O(N) //all the nodes will be visited
// Space Complexity : O(N) //queue will have only one level elements that is max n/2 at leaf level.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. It is multiple nodes BFS problem
 * 2. Find the elements which value is 2 and add it to queue.
 * 3. then traverse and find all the 4 side elements which value is 1.
 * 4. when adjacent 1 is found mark it to 2 as it is already visited and add it to queue.
 * 5. Maintain freshcount variable and all 1 are became 2 then return time else -1
 * 6. Difficult to solve with DFS.
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesBFS {

    public int orangesRotting(int[][] grid) {
        
        Queue<Integer> queue= new LinkedList<>();
        
        int freshCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    queue.add(i);
                    queue.add(j);
                }else if (grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        
        if(freshCount==0) return -1;
        
        int[][] adjArr= new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int time=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int k=0;k<size;k=k+2){
                int i=queue.poll();
                int j=queue.poll();
                
                for(int m=0;m<adjArr.length;m++){
                    int nr=i+adjArr[m][0];
                    int nc=j+adjArr[m][1];
                    
                    if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        queue.add(nr);
                        queue.add(nc);
                        freshCount--;
                    }
                }
            }
            time++;
        }
        
        if(freshCount==0) return time-1;
        return -1;
    }

}
