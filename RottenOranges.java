//Time Complexity=O(m*n)
//Space Complexity=O(m*n)
public class RottenOranges {
    int[][] dis={{-1,0},{1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int m=grid.length, n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int time=-1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                for(int[] dir:dis ){
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];

                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        System.out.println(fresh);
        if(fresh!=0) return -1;
        return time;
    }
}
