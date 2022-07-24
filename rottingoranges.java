// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null) return -1;
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        
        Queue<int[]> q=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(fresh==0){return 0;}
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] a=q.poll();
                for(int[] dir : dirs){
                    int nr=a[0]+dir[0];
                    int nc=a[1]+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == 1){
                        fresh--;
                        grid[nr][nc]++;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
    if(fresh>0){
        return -1;
    }else{
        return time-1;
    }
    }
}