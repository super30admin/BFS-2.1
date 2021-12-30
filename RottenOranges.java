import java.util.*;

public class RottenOranges {
    /*
    Approach: Using BFS
    * TC: O(m*n)
    * SC: O(m*n)
    *
    * */
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int m =grid.length;
        int n=grid[0].length;
        int time=0;
        int fresh=0;
        int dirs[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(fresh==0){
            return 0;
        }

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                for(int dir[]:dirs){
                    int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];

                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        fresh--;
                        q.add(new int[]{x,y});
                    }
                }
            }
            time++;
        }

        if(fresh>0){
            return -1;
        }

        return time-1;
    }
}
