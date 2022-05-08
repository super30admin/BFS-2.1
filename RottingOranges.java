public class RottingOranges {
    int rows, cols;
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        rows = grid.length;
        cols = grid[0].length;
        int freshCount = 0, time = 0;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 2)
                    q.add(new Pair<>(i,j));
                if(grid[i][j] == 1)
                    freshCount++;
            }
        }
        if(freshCount == 0) return 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                Pair<Integer, Integer> p = q.poll();
                int nr = p.getKey();
                int nc = p.getValue();
                for(int[] dir : directions){
                    int r = nr+dir[0];
                    int c = nc+dir[1];
                    if(r>=0 && r<rows && c>= 0 && c<cols && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new Pair<>(r,c));
                        freshCount--;
                    }
                }
                // if(r>0 && grid[r-1][c] == 1){
                //     grid[r-1][c] = 2;
                //     freshCount--;
                //     q.add(new Pair<>(r-1,c));
                // }
                // if(c>0 && grid[r][c-1] == 1){
                //     grid[r][c-1] = 2;
                //     freshCount--;
                //     q.add(new Pair<>(r,c-1));
                // }
                // if(r<rows-1 && grid[r+1][c] == 1){
                //     grid[r+1][c] = 2;
                //     freshCount--;
                //     q.add(new Pair<>(r+1,c));
                // }
                // if(c<cols-1 && grid[r][c+1] == 1){
                //     grid[r][c+1] = 2;
                //     freshCount--;
                //     q.add(new Pair<>(r,c+1));
                // }
            }
            time++;
        }
        if(freshCount != 0) return -1;
        return time-1;
    }
}
