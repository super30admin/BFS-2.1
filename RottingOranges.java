//TC:O(number of zeros into n*m)
//Space comple: O(n)
//Approach: we are doing bfs starting from rotten oranges and keep on going
//to make fresh oranges rotten and this will continue
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh=0;
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}}; 
        
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int x = 0;x<size;x++){
                int[] pair = queue.poll();
                for(int[] dir:dirs){
                    int i = pair[0]+dir[0];
                    int j = pair[1]+dir[1];
                    if(i>=0&&i<n&&j>=0&&j<m&&grid[i][j]==1){
                        grid[i][j] = 2;
                        queue.add(new int[]{i,j});
                        fresh--;
                    }
                }
            }
            level++;
        }
        
        if(fresh!=0){
            return -1;
        }
        
        if(level>0){
            return level-1;
        }
        
        return level;
    }
}
