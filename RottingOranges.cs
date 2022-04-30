// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//BFS Approach
	// 1) BFS
	// 2) Put al rotten oranges in queue
	// 3) Pop the prange
	// 4) Look for neighbors, 
	// 	a. If they are fresh make them rotten
	// 	b. Put in queue
	// 	c. Kepp repeating the loop until queue is empty

//O(n), O(n)
 int m, n;
int[][] dirs;

public int OrangesRotting(int[][] grid) {
    if(grid == null || grid.Length == 0)
        return 0;
    
    int time = 0;
    int fresh = 0;
    m = grid.Length;
    n = grid[0].Length;
    
    dirs = new int[][]{new int []{0, 1}, new int[]{1,0}, new int[]{0, -1}, new int[] {-1, 0}};
    
    Queue<int[]> queue = new Queue<int[]>();
    for(int i = 0; i < grid.Length; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(grid[i][j] == 2)
                queue.Enqueue(new int[] {i, j});
                
            if(grid[i][j] == 1)
                fresh++;
        }
    }
    
    if(fresh == 0)
        return 0;   
    
    while(queue.Count > 0)
    {
        int size = queue.Count;
        for(int i = 0; i < size; i++)
        {
            var curr = queue.Dequeue();
            foreach(var dir in dirs)
            {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1)
                {
                    grid[nr][nc] = 2;
                    queue.Enqueue(new int[]{nr, nc});
                    fresh--;
                }
            }
        }
        time++;
    }
        
    if(fresh != 0)
        return -1;
    //doing time -1 because we are doing time++, it is possible, there is no adjacent negibor to rotten it
    //but it will increase the time + 1, evev though no operation happened
    return time - 1;
}