
// TC - O(MN)
// SC - O(MN)
// Run on LeetCode - Yes
// Any challenge while coding - No

//Approach:

// - Maintain fresh oranges count.
// - Start with all Rotten oranges
// - Keep checking in all direction against each rotten oranges's cell
// - Mark it rotten
// - reduced fresh count
// - if count is 0 at any point return true and towards end, it should be 0. If not return -1

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null) return -1;

        int[][] dirs = { {-1,0}, {0,1}, {1,0}, {0,-1} };
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time=0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 1){
                    fresh++; //count the fresh oranges first
                }

                if(grid[i][j] == 2){
                    q.add(new int[]{i,j}); //Add all rotten organges in queue first
                }
            }
        }
        if(fresh == 0) return 0; //There are no fresh organges at first place.

        //BFS with optimization
        while(!q.isEmpty()){
            
            int size = q.size();
            time++; //processing level by level in BFS
            while(size>0){
                
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    //bounds check - Prevents ArrayOutOfBound (2D Array here)
                    if(nr>=0 && nc>=0 && nr<m && nc<n){
                        if(grid[nr][nc] == 1){ // Ignore 0 cell anyways
                            fresh--; // reducing fresh count
                            grid[nr][nc] = 2; //making it rotten
                            if(fresh == 0){ //If any time all Fresh Organes are turning rotten then terminate iteration
                                return time; //if we increment time after the level then we have to return level-1
                            }
                            q.add(new int[]{nr,nc});
                        }
                    }
                }
                size --;
            }
            
        }
        // if(fresh != 0) return -1;
        return -1;
    }
}