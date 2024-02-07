class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            boolean isIncrement = false;
            while(size-- > 0){
                int[] rotten = q.poll();
                int i = rotten[0];
                int j = rotten[1];

                if(i > 0 && grid[i-1][j] == 1){
                    isIncrement = true;
                    grid[i-1][j] = 2;
                    q.offer(new int[]{i-1, j});
                }

                if(i < grid.length-1 && grid[i+1][j] == 1){
                    isIncrement = true;
                    grid[i+1][j] = 2;
                    q.offer(new int[]{i+1, j});
                }

                if(j > 0 && grid[i][j-1] == 1){
                    isIncrement = true;
                    grid[i][j-1] = 2;
                    q.offer(new int[]{i, j-1});
                }

                if(j < grid[i].length-1 && grid[i][j+1] == 1){
                    isIncrement = true;
                    grid[i][j+1] = 2;
                    q.offer(new int[]{i, j+1});
                }
            }
            if(isIncrement) time++;
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return time;
        
    }
}
