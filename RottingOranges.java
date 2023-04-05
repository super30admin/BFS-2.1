/*
Time Complexity - O(N * M) where N * M is the size of the input grid.
Space Complexity - O(N * M)
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int freshOranges = 0;

        int nRows = grid.length, nCols = grid[0].length;
        int mins = -1;
        for(int row = 0; row < nRows; row++)
            for(int col = 0; col < nCols; col++) {
                if(grid[row][col] == 2)
                    queue.offer(new Pair<>(row, col));
                if(grid[row][col] == 1)
                    freshOranges++;
            }
        if(freshOranges == 0)
            return 0;
        int[][] directions = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> pair = queue.poll();
                int row = pair.getKey();
                int col = pair.getValue();
                for(int[] neighbourIndex : directions){
                    int newRow = row + neighbourIndex[0];
                    int newCol = col + neighbourIndex[1];
                    if(isWithinBounds(newRow, newCol, grid) 
                                && grid[newRow][newCol] == 1){
                        freshOranges--;
                        grid[newRow][newCol] = 2;
                        queue.add(new Pair<>(newRow, newCol));
                    }
                } 
            }
            mins++;
        }
        return freshOranges > 0 ? -1 : mins;
    }
    public boolean isWithinBounds(int newRow, int newCol, int[][] grid){
        if(newRow < 0 || newCol < 0)
            return false;
        if(newRow >= grid.length || newCol >= grid[0].length)
            return false;
        return true;
    }
}
