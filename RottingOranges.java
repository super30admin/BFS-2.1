// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private int[][] dirs = new int[][]{{-1,0}, {0,-1},{0,1},{1,0}};
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 2){
                    rowQueue.add(i);
                    columnQueue.add(j);
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0) return 0;
        int time = 0;
        while(!rowQueue.isEmpty()){
            int size = rowQueue.size();
            for(int i = 0; i< size; i++){
                int row = rowQueue.poll();
                int column = columnQueue.poll();
                for(int j = 0; j < dirs.length; j++){
                    int x = row + dirs[j][0];
                    int y = column + dirs[j][1];
                    if(x < m && x >= 0 && y < n && y >= 0 && grid[x][y] == 1){
                        freshOranges--;
                        grid[x][y] = 2;
                        rowQueue.add(x);
                        columnQueue.add(y);

                    }
                }
            }
            time++;
        }
        if(freshOranges == 0) return time-1;
        return -1;
    }

}