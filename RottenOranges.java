//Time Complexity: O(M*N) +O(M*N) = O(M*N)
//Space Complexity: O(M*N)
class Solution {
    public int orangesRotting(int[][] grid) {
        //base
        if(grid == null) return 0;
        int fresh=0;
        int time=0;
        Queue<int []> q = new LinkedList<int[]>();
        int m = grid.length;
        int n= grid[0].length;

        //directions matrix
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        //counting the total fresh oranges and putting the rotten oranges in the queue
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(q.isEmpty() && fresh ==0)return 0;
        // System.out.println(fresh);
        while(!q.isEmpty()){
            //pop element from queue and add a direction, if it's 1, add it into the queue
            // and change it's value to 2 and decrease the fresh by 1
            int size = q.size();
            for(int i=0; i<size;i++){
                int[] curr = q.poll();
                for(int[] dir:dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    if(nc>=0 && nr<m && nr >=0 && nc< n && grid[nr][nc] == 1){
                        q.add(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        fresh--;
                        // System.out.println(time);
                        // System.out.println(fresh);
                    }
                }

            }
            time++;//incrementing the time after each cycle

        }
        if(fresh==0) return time-1;
        return -1;
    }
}