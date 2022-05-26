//Time: O(MN) Space: O(MN)

class Solution {
    static class Position{
        int row;
        int col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Position> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int mins = 0;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int fresh = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                // find the 2s in the matrix and adding it to queue for further processing
                if(grid[i][j] == 2) {
                    q.add(new Position(i,j));
                }
                // taking count of fresh ones, to finally check how many of them could have been made rotten
                if(grid[i][j] == 1) fresh++;
            }
        }
        while(!q.isEmpty()) {
            int qSize = q.size();
            boolean isUpdated = false;
            for(int i=0;i<qSize;i++) {
                Position curr = q.poll();
                for(int[] dir: dirs) {
                    int currRow = curr.row - dir[0];
                    int currCol = curr.col - dir[1];
                    // whenever we find a fresh node, we rot it and add it to the queue for further processing from the diagonally in 4 directions
                    if(currRow >=0 && currCol >= 0 && currRow<m && currCol < n && grid[currRow][currCol] == 1) {
                        grid[currRow][currCol] = 2;
                        q.add(new Position(currRow, currCol));
                        // only if some update has happened,
                        // we count this level to the overall time taken
                        isUpdated = true;
                        fresh--;
                    }

                }

            }
            // incrementing mins upon rotting orange
            if(isUpdated) mins++;
        }
        // if there's still any fresh orange, we will return -1 or the time taken overall to rot all the fresh oranges
        return fresh == 0 ? mins : -1;
    }
}