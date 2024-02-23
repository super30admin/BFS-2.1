/**
The provided Java code represents a solution to the "Rotting Oranges" problem using BFS. 
It initializes a queue with rotten oranges, iterates through adjacent oranges, and updates their state.
 The process continues until all fresh oranges are infected, and the time taken is returned. 
 If any fresh oranges remain, indicating an unreachable state, -1 is returned. 
 The main logic employs BFS with a queue, updating the grid and tracking time.
The time complexity of the given solution is O(m * n)
The space complexity is O(m * n) as well. In the worst case, the queue can hold all the cells in the grid when all oranges are initially rotten.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int []> q= new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                 if(grid[i][j] == 1){
                     fresh++;
                 }
                 
            }
        }
        int time=0;
        if(q.isEmpty() && fresh==0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int []curr = q.poll();
            for(int [] dir:dirs){
                int nr = curr[0]+dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0&& nc>=0 && nr<m && nc<n && grid[nr][nc] == 1 ){
                    grid[nr][nc] =2;
                    fresh--;
                    q.add(new int[]{nr,nc});
                }
                
            } 
            } time++;
        } 
        if(fresh !=0) return -1;
        return time-1;
    }
}