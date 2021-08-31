public class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public int OrangesRotting(int[][] grid) {
        if (grid == null || grid.Length == 0)
            {
                return 0;
            }
            int m = grid.Length;
            int n = grid[0].Length;
            Queue<int[]> q = new Queue<int[]>();
            int fresh = 0;
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (grid[i][j] == 2)
                    {
                        q.Enqueue(new int[] { i, j });
                    }
                    else if (grid[i][j] == 1)
                    {
                        fresh++;
                    }
                }
            }
            if (fresh == 0) return 0;
            int lvl = 0;
            int[][] dirs = new int[][] { new int[2] { 0, 1 }, new int[2] { 1, 0 }, new int[2] { -1, 0 }, new int[2] { 0, -1 } };
            while (q.Count != 0)
            {
                int size = q.Count;
                for (int i = 0; i < size; i++)
                {
                    int[] curr = q.Dequeue();
                    foreach (int[] dir in dirs)
                    {
                        int r = dir[0] + curr[0];
                        int c = dir[1] + curr[1];
                        if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1)
                        {
                            grid[r][c] = 2;
                            q.Enqueue(new int[] { r, c });
                            fresh--;
                        }
                   
                    }              
                }
                lvl++;
            }
            if (fresh == 0) return lvl - 1;
            return -1;
    }
}