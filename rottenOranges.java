//time complexity:O(m x n)
//space complexity:O(m x n)
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh =0;
        int time=0;
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});//add the index of the 
                    //rotten orange in a queue
                }
                if(grid[i][j]==1)
                {
                    fresh++;//increment counter if fresh
                }
            }
        }
            if(fresh==0) return 0;
            int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}}; 
            while(!q.isEmpty())
            {
                int size=q.size();
                for(int k=0;k<size;k++)
                {
                    int []curr=q.poll();//trversing through the matrix
                    for(int[] dir:dirs)
                    {
                        int r=curr[0]+dir[0];
                        int c=curr[1]+dir[1];
                        if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1)
                        {
                            grid[r][c]=2;//if the neighbours are fresh then 
                            //make them rotten
                            q.add(new int[]{r,c});//add the new index of
                            //rotten orange
                            fresh--;
                            //decrement the no of fresh oranges
                        }
                    }
                }
                time++;//increment the time after checking all the 
                //neighbours of a particular orange
            }
            
        
        if(fresh!=0) return -1;
            return time-1; 
    }
}
