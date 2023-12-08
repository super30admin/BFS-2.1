//Time complexity: m*n
//Space complexity:O(m*n)
//Approach used: BFS 
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0,time=0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0) return time;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] currPos = q.poll();
                for(int[] dir : directions){
                    int row = currPos[0]+dir[0];
                    int col = currPos[1]+dir[1];

                    if(row>=0 && col>=0 && row<m && col<n && grid[row][col]==1){
                        grid[row][col] = 2;
                        q.add(new int[]{row,col});
                        fresh--;
                    }
                }
            }
            time++;
        }

        if(fresh==0) return time-1;
        return -1;
    }
}