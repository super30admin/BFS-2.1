class Solution {
    // BFS Solution
    // Time complexity is O(mn)
    // Space complexity is O(mn)
    // This solution is submitted on leetcode wiyth zero errors
    public int orangesRotting(int[][] grid) {
        // Edge case
        if(grid.length == 0 || grid == null) return -1;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}}; 
        int freshCount = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<rowLen;i++){
            for(int j = 0;j<colLen;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        if(freshCount ==0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] temp = q.poll();
                for(int[] dir: dirs){
                    int r = temp[0] + dir[0];
                    int c = temp[1] + dir[1];
                    if(r>=0 && r<rowLen && c>=0 && c<colLen && grid[r][c] == 1){
                        q.add(new int[] {r,c});
                        grid[r][c] = 2;
                        freshCount--;
                    }
                }
            }
            time++;
        }
        if(freshCount == 0) return time -1;
        return -1;
    }
}