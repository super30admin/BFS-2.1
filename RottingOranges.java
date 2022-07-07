import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
public class RottingOranges {
    int m;
    int n;
    int[][] dirs;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1,0}, {0, -1}, {1,0}, {0,1}};
        Queue<int []> q = new LinkedList<>();
        int fresh =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }
        int time = 0;
        if(fresh == 0)return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if(nr >= 0 && nc >= 0 && nr <m && nc<n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time-1;
    }
}
