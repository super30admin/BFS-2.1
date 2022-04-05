// Time Complexity : O(mXn)
// Space Complexity : O(mXn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid.length == 0 || grid[0].length == 0)
            return -1;

        //BFS traversal
        Queue<int[]> q = new LinkedList();
        //int array becuase we have to store both x and y coordinate for oranges

        int rows = grid.length;
        int cols = grid[0].length;

        //for easy traversal of neighbors of an orange
        int[][] directions = new int[][] {
            {-1,0},{1,0},{0,-1},{0,1}
        };

        //maintain fresh count to be checked later
        int fresh = 0;

        //traverse over the matrix to count fresh oranges and add rotten oranges to queue
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        //no fresh oranges
        if(fresh==0)
            return 0;

        int time = 0;

        //no rotten oranges
        if(q.isEmpty())
            return -1;

        while(!q.isEmpty())
        {
            int len = q.size();

            for(int i=0; i<len; i++)
            {
                int[] rotten = q.remove();

                //traverse neighbors for current rotten orange
                for(int[] d : directions)
                {
                    int r = d[0] + rotten[0];
                    int c = d[1] + rotten[1];

                    //check bounds
                    if(r>=0 && c>=0 && r<rows && c<cols)
                    {
                        //neighbor is fresh
                        if(grid[r][c] == 1)
                        {
                            //decrease fresh count
                            fresh--;
                            //make it rotten
                            grid[r][c] = 2;
                            //add it to queue
                            q.add(new int[] {r,c});
                        }

                    }
                }
            }

            time++;
        }

        if(fresh != 0) //fresh oranges left
            return -1;
        else        //no fresh oranges left
            return time-1;

    }
}
