// TC : O(m*n)
// SC : O(m*n)

package S30_Codes.BFS_2_1;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    class Pair{
        int row, col;
        Pair(int i, int j){
            row = i;
            col = j;
        }
    }

    private static int[][] direction = {
            {0,1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1)
                    freshOranges++;
                if(grid[i][j] == 2)
                    queue.add(new Pair(i,j));
            }
        }

        int minute = 0;
        int freshUpdateCount = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Pair p = queue.remove();
                int row = p.row;
                int col = p.col;

                for(int[] dir : direction){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];

                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1){
                        queue.add(new Pair(newRow,newCol));
                        freshOranges--;
                        grid[newRow][newCol] = 2;
                    }
                }
                size--;
            }
            if(!queue.isEmpty())
                minute++;
        }

        return freshOranges == 0 ? minute : -1;
    }
}