// Time Complexity : O(mn)
// Space Complexity : O(mn) - all oranges are rotten initially
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {

        if(grid == null) return 0;
        int fresh = 0;
        Queue<int []> q = new LinkedList<>();
        int time = 0;
        int [][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            // process a level
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    //bound check and healthy orange
                    if(nr >= 0 && nc >= 0
                            && nr < grid.length && nc < grid[0].length
                            && grid[nr][nc] == 1){
                        grid[nr][nc] = 2; //make it rotten
                        q.add(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time;
    }

    public static void main(String[] args) {
        System.out.println("Time taken to rot all oranges : " + orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
    }
}
