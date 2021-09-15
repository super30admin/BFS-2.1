// Time Complexity: O(m*n) where m is number of rows and n is number of columns
// Space Complexity: O(m*n) as in worst case we might be adding all cells to queue
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach here:
// Idea here is to perform BFS on all the rotten oranges and
// simultaneously reach all the neighbours who are fresh and rot them in 1 time cycle
// to perform this we are iterating whole grid once and counting all the fresh oranges
// as well as we are adding to queue all the oranges which are rotten
// Further, until the queue is empty we poll till size of queue and
// visit all the neighbours using a directions array by placing starting and ending bounds.
// If neighbour is fresh we mark it rotten, decrease count of fresh and
// add it to queue for further processing. On each level, time is increased.
// when queue gets empty if there are still fresh oranges remaining,
// we can not rot them and -1 is returned else time calculated is returned.
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==0) continue;
                else q.add(new int[]{i,j});
            }
        }
        if(fresh==0) return 0;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        if(fresh==0) return 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1) {
                        grid[r][c] = 2;
                        fresh--;
                        q.add(new int[]{r,c});
                    }
                }
            }
            time++;
        }
        if(fresh>0) return -1;
        return time-1;
    }
}