/*
Rotting Oranges
approach: use a bfs to rot all neighbors
time: O(mxn)
space: O(mxn)
 */
import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {

    static int orangesRotting(int[][] grid) {
        if(grid==null) return -1;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        for(int i=0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }
        int time = 0;
        if (fresh==0) return 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++) {
                int[] temp = q.poll();

                for(int[] dir:dirs) {
                    int nr = temp[0]+dir[0];
                    int nc = temp[1]+dir[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n) {
                        if(grid[nr][nc] == 1) {
                            fresh--;
                            grid[nr][nc] = 2;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
            time++;
        }

        if(fresh==0) return time-1;

        return -1;
    }

    public static void main(String[] args) {
        orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }
}
