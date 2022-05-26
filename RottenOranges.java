//Time Complexity: O(m * n)
//Space Complexity: O(m *n)
//Leetcode: yes

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int time = 0;
        int fresh_oranges = 0;
        Queue<int []> q = new LinkedList<int []>();
        int[][] dir = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
        
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh_oranges++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[] {i,j});
                }
            }
        }
        //we should check this here otherwise when there are no fresh oranges in the input we will return -1
        if (fresh_oranges == 0) return 0;
        
        //we got the count and all the rotten oragnes in the matrix are in the queue
        //Now process the rotten oranges from the queue one by one
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i= 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dir) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    //boundary check
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2; // make the fresh as rotten now
                        q.add(new int[] {r,c});
                        fresh_oranges--;
                        if (fresh_oranges == 0) {
                            return time + 1;
                        }
                    }
                }
            }
            time++;   //after processing each level increase the time
        }
        //we can return time here also if check the fresh count after the loop but then we retun time -1 as it gets incremented one extra time.
        //if we come here it means we still have some fresh oranges in the matrix.
        return -1;
    }
}
