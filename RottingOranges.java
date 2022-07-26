//  Time complexity: O(mn)
//  space complexity: O(mn)
//  Approach: check for number of fresh oranges and insert rotten ones into queue
//  traverse the queue and check for fresh ones
//  add the freshones into queue and make them rotten in the matrix
//  decrease the fresh oranges count whenver u make the fresh one into rotten
//  return -1 if there are still fresh oranges left
//  else return time if no fresh oranges left
class RottingOranges {
    public int orangesRotting(int[][] grid) {
        //base case
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int time = 0, fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        //dirs array
        int[][] dirs = new int[][]{{0,-1}, {0,1}, {1,0}, {-1, 0}};
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //add rotten oranges to the queue
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } //keep a count of all the fresh oranges
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        //if there are no fresh oranges to be rotten, return 0
        if(fresh == 0) return 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();

                //travel all 4 directions and add rotten oranges to the queue
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    //check the boundaries and if it's a fresh orange, add to the queue and mark as rotten, reduce the count of fresh oranges
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        q.add(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            //increase the time taken after every level
            time++;
        }
        //if there are still fresh oranges that cannot be rotten, return -1
        if(fresh != 0) return -1;

        //else return the time taken
        return time-1;
    }
}