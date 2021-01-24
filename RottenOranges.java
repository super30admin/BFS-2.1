// Time Complexity : 0(m*n)
// Space Complexity : 0(m*n) for queue if all oranges are rotten
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;

        //for bfs
        Queue<int[]> queue = new LinkedList<>();

        //adding rotten oranges in queue and calculating fresh oranges
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0)
            return 0;

        int time = 0;
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        //iterating through the queue level by level
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    //converting fresh orange to rottern if neighbour is rotten
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }

        if(fresh != 0)
            return -1;

        return time-1;

    }
}