//Time Complexity:O(m*n)+O(m*n)=O(m*n)
//Space Complexity:O(m*n)
//using BFS:Time will take to rotten orange is = 2 minutes,otherwise return -1 if its time is too high the outer loop m*n is connected with m*n.Example dry run usinginteger array =[row,col] all the rotten oranges in time one iterate over the till the fresh elements you found to be rotten.take a queue integer linked list and maint the size variable at each level to maintain the queue.if time starts initially to level on is 1 then the at level 2 is 2 times and reach 3 level then it return the queue empty or return time-1.To do a certain action to identify a level iterate over to all the level.
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                else if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
            }
        }
        if(freshOranges == 0) return 0;
        int time = 0;
        //lets do BFS
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir:dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr >= 0 && nr<m && nc >= 0 && nc<n && grid[nr][nc] == 1){
                        freshOranges--;
                        q.add(new int[] {nr,nc});
                        grid[nr][nc] = 2;
                    }
                }
            }
            time++;
        }
        if(freshOranges !=0) return-1;
        return time-1;
    }
}