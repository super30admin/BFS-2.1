Time Complexity: O(n)
Space Complexity: O(n)

class Solution {
    public int orangesRotting(int[][] grid) {
        //base case
        if(grid == null || grid[0].length == 0 || grid.length == 0 || grid[0] == null){
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        //rows and cols
        int rows = grid.length;
        int cols = grid[0].length;
        
        int freshOranges = 0;
        for(int i = 0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[] {i,j});
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        
        int t = 0;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!queue.isEmpty()){
            int qsize = queue.size();
            for(int x =0;x<qsize;x++){
                int[] pair = queue.poll();

                for(int[] dir: dirs){
                    int i = dir[0]+pair[0];
                    int j = dir[1]+pair[1];

                    if(i >= 0 && i<rows && j >= 0 && j<cols && grid[i][j] == 1){
                        grid[i][j]=2;
                        queue.add(new int[]{i,j});
                        freshOranges--;
                    }
                }
            }
            t++;
        }
        
        if(freshOranges != 0){
            return -1;
        }
        
        if(t>0){
            return t-1;
        }
        return t;
    }
}