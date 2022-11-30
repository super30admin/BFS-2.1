//TC: O(m X n)
//SC: O(m X n)


class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length; // row
        int n = grid[0].length; // column

        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        int level = 0;
        int[][] dirs = {{-1, 0}, {1,0}, {0, -1}, {0, 1}}; //up, down, left, right

        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i, j});
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0) return 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int new_row = curr[0] + dir[0];
                    int new_col = curr[1] + dir[1];
                    if(new_row >= 0 && new_row < m && new_col>=0 && new_col < n && grid[new_row][new_col] == 1){
                        grid[new_row][new_col] = 2;
                        q.add(new int[] {new_row, new_col});
                        freshOranges--;

                    }
                }
            }
            level++;
        }
        if(freshOranges >0) return -1;
        return level-1;
    }
}
