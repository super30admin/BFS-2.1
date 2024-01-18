//1.Orange getting rotten
//Time Complexity - >  O(m*n)
//space Complexity -> O(m*n) - > size of queue when all are 1
//Using BFS
class Solution {
    //Using BFS
    public int orangesRotting(int[][] grid) {
        if(grid == null) return -1;
        int time = 0;
        int fresh = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>(); //making a queue of int[] array such that array contains only 2 elements

        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int i = 0; i < n;i++){
            for(int j = 0 ; j < m;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(fresh == 0) return time;
        while(!q.isEmpty()){
            //processing of level starts
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            time++; //increase the time by 1 when the level finishes
        }
        if(fresh!=0) return -1;
        return time - 1;
    }
}

//Using DFS