// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null) return 0;
        int fresh=0;
        int m= grid.length;
        int n= grid[0].length;
        int level=0;
        Queue<int[]> q=new LinkedList<>();
        
        int[][] dirs={{-1,0}, {1,0} , {0,-1} , {0,1}}; //U D L R
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        if(fresh==0) return 0;
        
        //BFS
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
               int[] curr=q.poll();
               for(int[] dir:dirs){
                    int rn= curr[0] + dir[0];
                    int cn= curr[1] + dir[1];
                   if(rn>=0 && cn<n && rn <m && cn>=0 && grid[rn][cn]==1){
                       
                           grid[rn][cn] = 2;
                           q.add(new int[]{rn,cn});
                           fresh--;
                       
                   }
               } 
            }
            
            level++;
            
            
        }
        
        return fresh ==0 ? level-1 : -1;
    }
}