package BFS21;
// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }
        int time = 0;
        int size;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.isEmpty()){
            size = q.size();
            if(fresh == 0)
                break;
            for(int i=0;i<size;i++){
                int[] cell = q.poll();
                for(int [] dir : dirs){
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if(row>=0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] == 1){
                        q.add(new int[]{row, col});
                        grid[row][col] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0? time: -1;
    }
}
