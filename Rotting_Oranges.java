// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Method used : BFS

class Solution {

    class Pair
    {
        int row, col;

        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length, cols = grid[0].length;
        int freshOranges = 0;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Pair> queue = new LinkedList();

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 2) queue.add(new Pair(i, j));

                else if(grid[i][j] == 1) ++freshOranges;
            }
        }

        if(freshOranges == 0) return 0;

        int new_col, new_row, count = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                Pair p = queue.poll();

                for(int[] dir : dirs)
                {
                    new_row = p.row + dir[0];
                    new_col = p.col + dir[1];

                    if(new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols && grid[new_row][new_col] == 1)
                    {
                        grid[new_row][new_col] = 2;
                        --freshOranges;
                        queue.add(new Pair(new_row, new_col));
                    }
                }
            }

            ++count;
        }

        return (freshOranges == 0) ? count  - 1 : -1;
    }
}