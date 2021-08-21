/* Time Complexity :  O(m*n)
   Space Complexity :   O(m*n) where m and n are input dimensions
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int level=0;
        int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}}; //up,right,left,down
        while(!q.isEmpty()){
            int size=q.size();
            if(fresh==0) break;
            for(int i=0;i<size;i++){
                int[] coord = q.poll();  
                for(int[] dir : dirs){
                    int x = dir[0] + coord[0];
                    int y = dir[1] + coord[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1){
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                        fresh--;
                    }
                }
            }
            level++;  
        }
        if(fresh>0) return -1;
        return level;
    }
}