import java.util.Queue;

/*approach -1: 
scan the matrix, find the rotten ornge and run through a loop and update the neighbor. increment minute. 
do the above step again until all oranges are rotten. 
TC- O(m*n)^2, SC- O(m*n)

 * approach - Optimized, BFS
 * 1. scan the matrix, find rotten oranges coordinates and add them to queue. , also count the fresh oranges. 
 * 2. take queue, and type int[] as we are adding pair of i and j. 
 * 3. take a level variable which will help us to find the minute(level = minute), so after we are done processing the size of the queue
 * we'll level++. and at last we'll do level-1 and eturn it as answer .
 * 4. take a dirs array with four directions
 * 5. after we find the size of the queue . .take curr from the queue and go through dirs array 
 * and update the neighbors if they have fresh oranges and neighbor is in bound 
 * also add the neighbor-which is now rotten to the queue for next level process, and decrement the freshorange--. 
 * 6. at end of everylevel , level++
 * after while(!queue.isEmpty()) is done, check if freshorange >0; then return -1 as it is impossible to rott alll oranges. 
 * if they are zero, then return level-1. 
 * TC-  O(v+E) orO(mn) ; v = oranges/grids, and E = neighbors; total v = m*n and E = m*n; = O(m*n)+O(m*n) = O(2mn) = O(mn)
 * SC- O(v+e) or O(mn) = storing all node in queue - O(mn)+O(mn) = O(2mn) = O(mn)
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        //rotten queue
        Queue<int[]> rotten  = new LinkedList<>();
        int fresh=0;

        //1.scan the matrix, get fresh count and push rotten to the queue. 
        for(int i =0; i< m ; i++)
        {
            for(int j=0; j< n ; j++)
            {
                if(grid[i][j] == 1)  fresh++;
                else if(grid[i][j] ==2) rotten.add(new int[] {i,j});
            }
        }
        //check for the existing fresh oranges
        if(fresh == 0) return 0;

        //take the dirs array for neighbors
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        //perform BFS
        int level =0; // thsi represents minutes
        while(!rotten.isEmpty())
        {
            int size = rotten.size();

            for(int i = 0; i< size; i++)
            {
                int[] curr = rotten.poll();

                for(int[] dir : dirs)
                {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    //check if nr and nc are in bound and we find the fresh orange. 
                    if(nr > 0 && nr< m && nc > 0 && nc < n && grid[nr][nc] ==1 )
                    {
                        //add to the queue. 
                        rotten.add(new int[] {nr,nc});
                        //rott the orange
                        grid[nr][nc] = 2;
                        //decrement the fresh count
                        fresh--;
                    }
                }
            }//finished one level here 
                level++;
        }
        //check fresh count
        if(fresh == 0) return level-1;
        else return -1; // as it's impossible to rott all oranges. 
    }
}