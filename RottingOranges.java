import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    private int[][] dirs;
    public int orangesRotting(int[][] grid){
        int result = -1;
        if(grid == null || grid.length < 0){
            return result;
        }

        dirs = new int[][] {{-1, 0}, {1,0}, {0,-1}, {0,1}};
        Queue<Integer> q = new LinkedList<>();

        int fresh = 0;

        for(int i =0; i<grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(i);
                    q.add(j);
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }

        }

        int minutes = 0;
        if(fresh == 0) return 0;

        while(!q.isEmpty()){
            int size = q.size()/2;
            for(int i =0; i<size; i++){
                int currRow = q.poll();
                int currCol = q.poll();

                if(grid[currRow][currCol] == 2){
                    //mutate the current
                    grid[currRow][currCol] = -1;
                    //mutate the neighbors
                    for(int[] dir : dirs){
                        int nr = currRow + dir[0];
                        int nc = currCol + dir[1];

                        if(nr >= 0 && nr < grid.length
                                && nc>=0 && nc< grid[0].length && grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            q.add(nr);
                            q.add(nc);
                            fresh--;
                        }
                    }
                }
            }
            minutes++;

        }

        if(fresh == 0 )return minutes-1;
        return -1;
    }
}