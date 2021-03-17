// Time Complexity : O(4 (n*m)) => O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        int count = -1;
        Queue<int[]> que = new LinkedList();
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    que.add(new int[]{i,j});
                if(grid[i][j] == 1)
                    num++;
            }
        }
        while(!que.isEmpty()){
            int size = que.size();
            count++;
            for(int i=0;i<size;i++){
                int[] n = que.poll();
                int r = n[0], c=n[1];
                if(r+1 < grid.length && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    que.add(new int[]{r+1,c});
                    num--;
                }
                if(r-1 >=0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    que.add(new int[]{r-1,c});
                    num--;
                }
                if(c+1 < grid[0].length && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    que.add(new int[]{r,c+1});
                    num--;
                }
                if(c-1 >= 0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    que.add(new int[]{r,c-1});
                    num--;
                }
            }
        }
        return num == 0 ? (count == -1) ? 0:count : -1;
    }
}
