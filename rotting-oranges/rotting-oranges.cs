public class Solution {
    int rottencount=0;
    int freshcount =0;
    int time =0;
    public int OrangesRotting(int[][] grid) {
        int rows = grid.Length;
        int columns = grid[0].Length;
        Queue<(int i ,int j)> q = new Queue<(int i, int j)>();
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(grid[i][j]==2)
                {
                    q.Enqueue((i,j));
                }
                else if(grid[i][j]==1)
                {
                    freshcount++;
                }
            }
        }
      //  Console.WriteLine(freshcount);
        if(freshcount==0)
        {
            return 0;
        }
        
        
        while(q.Count>0)
        {
            int qsize = q.Count;
            while(qsize>0)
            {
            var temp = q.Dequeue();
                int x = temp.i;
                int y = temp.j;
                
                if(y>=0 && y<grid[x].Length-1 && grid[x][y+1]==1)
                {
                    q.Enqueue((x,y+1));
                    grid[x][y+1]=2;
                    freshcount--;
                }
                
                if(x>0 && grid[x-1][y]==1)
                {
                     q.Enqueue((x-1,y));
                    grid[x-1][y]=2;
                    freshcount--;
                }
                if(y>0 && grid[x][y-1]==1)
                {
                     q.Enqueue((x,y-1));
                    grid[x][y-1]=2;
                    freshcount--;
                }
                Console.WriteLine(x);
                if(x<grid.Length-1 && grid[x+1][y]==1)
                {
                  q.Enqueue((x+1,y));
                    grid[x+1][y]=2;
                    freshcount--;   
                }
                qsize--;
            }
            time++;
        }
        
        if(freshcount>0)
        {
            return -1;
        }
        else
            return time-1;
        
    }
}
