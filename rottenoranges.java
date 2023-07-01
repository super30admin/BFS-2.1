// Time Complexity :  O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we are using a queue and storing all the rotten oranges(2) and start bfs on it on 4 directions.
// initially while searching for 2 we also take the count of fresh oranges and decrease the count of fresh oranges each time before adding to the queue
// changing the value before adding to the queue is imporatant, if we modify it after adding it to the queue there is a chance of accessing it from other directions.

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null ) return 0;
        int m = grid.length; //row
        int n= grid[0].length; // col
        int[][] dirs= new int[][]{ {0,1}, {1,0} ,{0,-1},{-1,0}}; // dirs
        int fresh=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time=0;
        if(fresh==0) return time;
        while(!q.isEmpty())
        {
            int size = q.size();
            //level
            for(int i=0;i<size;i++)
            {
                int curr[]= q.poll();
                System.out.println(curr[0] +"," +curr[1]);
                for(int[] dir:dirs)
                {
                    int nr= dir[0]+ curr[0];
                    int nc= dir[1]+ curr[1];
                     System.out.println(nr +"," +nc);
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        fresh--;
                        q.add(new int[]{nr,nc});
                        if(fresh == 0) return time+1;
                    }
                }
            }
            time++; 
        }
        
            return -1;

    }
}