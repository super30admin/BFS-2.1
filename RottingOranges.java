import java.util.*;
//BSF solution
// Time Complexity: O(n) // one traversal will be for getting the rotton and fresh oranges and other traversal will be for queue.
//Space Complexity: O(n) //n/2 which is max width of the tree
/*
 * here we store the rotton oranges in a queue and get its children 
 * from all 4 directions. if the child is fresh it will then be 
 * rotton. and we will add that to the queue.
 */

class RottingOranges{
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        Queue<int []> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nc >= 0 && nc < n && nr >= 0 && nr < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            time++;
        }        
        if(fresh == 0) return time-1;
        return -1;
    }
}