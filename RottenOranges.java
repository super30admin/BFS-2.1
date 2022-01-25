//Time Complexity: O(mn)
//Time Complexity :O(mn)
class Solution {
    public int orangesRotting(int[][] grid) {
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int time=0;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
       
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0)
            return time;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                for(int dir[]:dirs){
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    
                    if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length
                      && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
            
        }
        if(fresh!=0)
            return -1;
        return time-1;
    }
}
