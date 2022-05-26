// Time Complexity : O(n*m) =O(N) N = size of the grid, n*m
// Space Complexity : O(N), worst case will be entire grid has rotten oranges and queuee gets filled with them all
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int output = -1;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        int numFreshOranges =0;
        int m = grid.length;
        int n = grid[0].length;

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == 2)
                    q.offer(new Pair(r,c));
                else if(grid[r][c] == 1)
                    numFreshOranges++;
            }
        }

        q.offer(new Pair(-1,-1));
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()) {
            Pair<Integer, Integer> currPair = q.poll();
            int row = currPair.getKey();
            int col = currPair.getValue();
            if(row == -1) {
                output++;
                if(!q.isEmpty())
                    q.offer(new Pair(-1,-1));
            }else{
                for(int[] dir: dirs) {
                    int nighbourRow = row + dir[0];
                    int nighbourCol = col + dir[1];
                    if(nighbourRow >=0 && nighbourRow <m
                            && nighbourCol>=0 && nighbourCol<n) {
                        if(grid[nighbourRow][nighbourCol] == 1){
                            grid[nighbourRow][nighbourCol] = 2;
                            numFreshOranges--;
                            q.offer(new Pair(nighbourRow, nighbourCol));
                        }
                    }
                }
            }
        }
        return numFreshOranges == 0 ? output : -1;

    }
}