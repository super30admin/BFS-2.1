//Time complexity:O(n^2)
//Space complexity:O(n^2)
//Ran on leetcode: Yes

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        
        
        
        Queue<int[]> q = new LinkedList<>();
     
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int level =0;
        int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]= q.poll();
                for(int[]d : dir){
                    int x=curr[0]+d[0];
                    int y=curr[1]+d[1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                        fresh--;
                    }
                }
            }
            level++;
        }
        if(fresh>0) return -1;
        return level==0?0:level-1;
        
    }
}