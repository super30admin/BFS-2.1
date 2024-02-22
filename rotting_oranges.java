//TC: O(m*n)
//SC: O(m*n)
class Solution {
      int [][]dirs={{-1,0},{1,0},{0,1},{0,-1}};
        int m;
        int n;
    public int orangesRotting(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int fresh=0;
        int time=0;
        Queue<int []> q= new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    int[] temp=new int[2];
                    temp[0]=i;
                    temp[1]=j;
                    q.add(temp);
                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        if(fresh==0)return 0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int [] temp1=q.poll();
                for(int []dir:dirs)
                {
                    int nr=dir[0]+temp1[0];
                    int nc=dir[1]+temp1[1];
                    if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        q.add(new int [] {nr,nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
         
      if(fresh==0)
      {
          return time-1;
      }
      return -1;

        
    }
}