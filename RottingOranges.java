// Time Complexity: O(mn)
// Space Complexity: O(mn) 
// BFS Approach
class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        Queue<int []> queue = new LinkedList<>();
        int freshCount = 0;
        int dirs[][] = new int[][]{{-1, 0}, {1,0}, {0,-1}, {0,1}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return time;


        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i< size; i++){
                int arr[] = queue.poll();
                for(int dir[]: dirs){
                    int r = dir[0] + arr[0];
                    int c = dir[1] + arr[1];

                    if(r >= 0 && c>= 0 && r<m && c <n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.add(new int[]{r,c});
                        freshCount--;
                    }
                }
            }
            time++;
        }
        if(freshCount != 0) return -1;
        return time-1;     
    }
}


// Time Complexity: O(m^2 * n^2)
// Space Complexity: O(mn)
// DFS Approach 
class Solution {

    int dirs[][] = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int time = 2;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2)
                    dfs(grid, i,j, time,m,n);
            }
        }

        System.out.println(Arrays.deepToString(grid));

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) return -1;
                time = Math.max(time, grid[i][j]);

            }
        }

        return time-2;
    }

    private void dfs(int grid[][], int r, int c, int time, int m, int n){
        grid[r][c] = time;

        for(int dir[]: dirs){
            int i = r + dir[0];
            int j = c + dir[1];

            if(i>=0 && j>=0 && i<m && j<n && (grid[i][j] == 1 || grid[i][j] > time)){
                dfs(grid, i,j, time+1, m,n);
            }
        }
    }
}