package DataStructure.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class S30_M_994_RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        if(grid == null)
            return -1;

        Queue<int[]> infected = new LinkedList<>();
        int freshCount = 0;

        for(int i=0; i< grid.length ; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2)
                    infected.add(new int[]{i,j});

                if(grid[i][j] == 1)
                    freshCount++;
            }
        }

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int minutes = 0;

        while(!infected.isEmpty() && freshCount > 0){
            int size = infected.size();
            minutes++;
            while(size>0){
                int[] rotten = infected.poll();
                for(int[] dir: dirs){
                    int row = rotten[0]+dir[0];
                    int col = rotten[1]+dir[1];

                    if(row<0 || row>= grid.length || col<0 || col>=grid[0].length ||
                            (grid[row][col] ==2 || grid[row][col] == 0))
                        continue;

                    grid[row][col] = 2;
                    infected.add(new int[]{row,col});
                    freshCount--;
                }
                size--;
            }
        }

        return (freshCount == 0)?minutes:-1;
    }
}

