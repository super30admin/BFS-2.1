class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid.length==0||grid==null) return 0;
        int row =  grid.length;
        int col = grid[0].length;
        int fresh = 0;
        
        Queue<int[]> q = new LinkedList();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        
        if(fresh==0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int min =0;
        while(!q.isEmpty()){
            min++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] stale = q.poll();
                for(int[] dir : dirs){
                    int newRow = dir[0]+stale[0];
                    int newCol = dir[1]+stale[1];
                    if(newRow<0|| newCol<0 || newRow>=row || newCol>=col || grid[newRow][newCol]==0 ||grid[newRow][newCol]==2)
                        continue;
                    grid[newRow][newCol] = 2;
                    q.add(new int[]{newRow,newCol});
                    fresh--;
                }
            }
        }
        return fresh==0?min-1:-1;
        
    }
}