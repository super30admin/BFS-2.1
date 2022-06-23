//Time complexity:O(m*n)
//Sapce Complexity: O(m*n) //size of queue
class Solution {
    public int orangesRotting(int[][] grid) {
        int [][]dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int []> q = new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                    else if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }
        if(fresh==0) return 0;
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
               int []curr = q.poll();
            for(int []dir:dirs) {
                int a = curr[0]+dir[0];
                int b = curr[1]+dir[1];
                if(a>=0 && b>=0 && a<grid.length && b<grid[0].length && grid[a][b]==1){
                    grid[a][b]=2;
                    fresh--;
                    q.add(new int[] {a,b});
                }
            } 
            }
            
            time++;
        }
        if(fresh!=0) return -1;
        return time-1;
    }
}
