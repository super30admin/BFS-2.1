import java.util.LinkedList;
import java.util.Queue;
//Leetcode - 994
//TC - O(M*N)
//SC - O(M*N)
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        // BFS
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<m; i++) {
            for(int j =0; j<n; j++) {//O(M*N)
                if(grid[i][j] == 2){ //if rotten add to queue
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1) fresh++; //count fresh oranges
            }
        }
        //edge case
        if(fresh == 0) return 0;
        int time = 0;
        while(!q.isEmpty()) {//O(N)
            int size = q.size();
            for(int i=0; i<size; i++) {
                int [] curr = q.poll();
                for(int [] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;//make the orange rotten
                        q.add(new int[]{row,col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time-1;
    }
}
