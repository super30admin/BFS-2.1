// ## Problem 1

// Rotting Oranges(https://leetcode.com/problems/rotting-oranges)

class Solution {
    // BFS solution
    // Time - O(M*N)
    // Space - O(M*N)
    private int bfsHelper(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;

        int[][] dirs={{0,1}, {1,0}, {0,-1}, {-1,0}};

        int time=0;
        int fresh=0;
        Queue<Integer> q=new LinkedList<>();
    
        // Add initial rotten ones to queue
        // And count fresh ones
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(i);
                    q.add(j);
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0)    return 0;
        while(!q.isEmpty()){
            // Number of oranges at current level
            int size_n=q.size();

            // Process each level
            for(int i=0;i<size_n;i=i+2){
                int r=q.poll();
                int c=q.poll();

                for(int[] dir: dirs){
                    int nr=r+dir[0];
                    int nc=c+dir[1];

                    // Check if in bounds
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        // Rot it
                        grid[nr][nc]=2;

                        // Update fresh count
                        fresh--;

                        // add to queue
                        q.add(nr);
                        q.add(nc);
                    }
                }
            }
            time++;

            if(fresh==0)    return time;
        }

        if(fresh!=0){
            return -1;
        }
        return time;
    }

    public int orangesRotting(int[][] grid) {
        return bfsHelper(grid);
    }
}
