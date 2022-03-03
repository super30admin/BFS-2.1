/**


minute = 4

[[2,2,2],
 [0,2,2],
 [1,0,2]]
 
 0 = empty cell
 1 = fresh orange
 2 = rotten orange

BFS 
boolean array to check don't visit already visited again. let's implement with this boolean array and then change the values.

**/
class Solution {
    public int orangesRotting(int[][] grid) {
            
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean visited[][] = new boolean[rows][cols];
        int dirs[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        int rottenOrange = 0;
        int freshOrange = 0;
        int emptyCell = 0;
        int noOfMinutes = 0;
    
        for (int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if (visited[i][j])
                {
                    continue;
                }
                
                if (grid[i][j] == 0)
                {
                    emptyCell++;
                }
                else if (grid[i][j] == 1)
                {
                    freshOrange++;
                }
                else
                {
                    final Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    rottenOrange++;
                    
                    while(!queue.isEmpty())
                    {
                        int qSize = queue.size();
                        
                        for (int k=0; k<qSize; k++)
                        {
                            int remove[] = queue.remove();
                        
                            for (int dir[] : dirs)
                            {
                                int ni = remove[0] + dir[0];
                                int nj = remove[1] + dir[1];

                                if (ni>=0 && ni<rows && nj>=0 && nj<cols && grid[ni][nj] != 0 && !visited[ni][nj])
                                {
                                    grid[ni][nj] = 2;
                                    visited[ni][nj] = true;
                                    queue.add(new int[]{ni, nj});
                                    rottenOrange++;
                                }
                            }
                        }
                        
                        noOfMinutes += 1;
                    }
                }
            }
        }
        
        return (rottenOrange + emptyCell) == rows * cols ? (noOfMinutes == 0) ? noOfMinutes : noOfMinutes - 1 : -1; 
    }
}
