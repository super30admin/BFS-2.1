
// Time - O(N)
// Space - O(N)



class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }


        int fresh = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int []> q = new LinkedList<>();

        // Add the rotten orange in the queue
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }

                if(grid[i][j] == 1) fresh++;


            }

        }

        // if we dont have any fresh oranges return 0
        if(fresh == 0) return 0;

        // dirs array to traverse in 4 directions
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};



        // traverse and make the oranges rotten by increasing time incrementing at each level
        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int [] curr = q.poll();

                for(int [] dir: dirs) {

                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }

                }



            }

            time++;

        }

        // if fresh count we hit is not equal to zero then all the oranges are not rooten return -1
        if(fresh != 0 ) return -1;


        // we need to decrement time as we calculated one level more to get thee exact time for how long it took to rott all oranges
        return time - 1;

    }
}