import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/*
Time Complexity: O(N*M), here N is the size of the rows and M is the number of Cols in the grid
Space Complexity: O(N*N), N is the size of Queue
Run on leetcode: yes
Any difficulties: no

Approach:
Attempted after discussed in the class
 */
public class RottingOranges {
    private static final int[][] directions = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };

    private static final int EMPTYCELL = 0, FRESHCELL = 1, ROTTENCELL= 2;

    public static int totalTimeInRottingOranges(int[][] grid){
        int rows= grid.length;
        int cols = grid[0].length;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int countOfFreshOranges = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == ROTTENCELL){
                        queue.add(new Pair(i,j));
                }else if(grid[i][j] == FRESHCELL){
                    countOfFreshOranges++;
                }
            }
        }

        int totalTime = 0;
        while(!queue.isEmpty()){
            Queue<Pair<Integer, Integer>> next = new LinkedList<>();
            while(!queue.isEmpty()){
                Pair<Integer, Integer> pair = queue.remove();

                for(int []dir: directions){
                    int x = dir[0]+pair.getKey();
                    int y = dir[1]+ pair.getValue();

                    if(x>= 0 && y>=0 && x<rows && y<cols){
                        if(grid[x][y] == FRESHCELL){
                            grid[x][y] = ROTTENCELL;

                            countOfFreshOranges--;
                            next.add(new Pair(x,y));
                        }
                    }
                }
            }
            queue = next;
            if(!next.isEmpty()){
                totalTime++;
            }
        }
        return countOfFreshOranges > 0 ? -1: totalTime;
    }

    public static void main(String[] args){
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};

        System.out.println("Total time to spoil all the oranges: "+totalTimeInRottingOranges(grid));
    }
}
