//Time: O(m*n)
//Space: O(m*n)

public class Solution {
    
    class Cell {
        public int x;
        public int y;
        
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int OrangesRotting(int[][] grid) {
        int remainingFresh = 0;
        List<Cell> fresh = new List<Cell>();
        
        for(int i = 0; i < grid.Length; i++) {
            for(int j = 0; j < grid[i].Length; j++) {
                if(grid[i][j] == 2) {
                    fresh.Add(new Cell(i, j));
                }
                if(grid[i][j] == 1)
                {
                     remainingFresh++;
                }
            }
        }
        
        if(remainingFresh == 0) {
            return 0;
        }
        
        int minute = 0;
        Queue<Cell> queue = new Queue<Cell>();
        
        for(int i = 0; i < fresh.Count; i++) {
            queue.Enqueue(fresh[i]);
        }        
        int width = grid[0].Length - 1;
        int height = grid.Length - 1;
        
        int[][] directions = new int[][] {
            new int[]{0, -1},
            new int[]{0, 1},
            new int[]{-1, 0},
            new int[]{1, 0},
        };
        
        while(queue.Count > 0) {
            
            int size = queue.Count;
            minute++;
            for(int i = 0; i < size; i++) {
                
                Cell cell = queue.Dequeue();
                foreach(int[] dir in directions) {
                    int row = cell.x + dir[0];
                    int column = cell.y + dir[1];
                    
                    if(row >=0 && row <= height && column >= 0 && column <= width) 
                     {
                        
                        if(grid[row][column] == 1) {
                             queue.Enqueue(new Cell(row, column));
                             grid[row][column] = 2;
                             remainingFresh--;
                     }
                   }
                }
            }
        }
        
        if(remainingFresh != 0) {
            return -1;
        } else {
            return minute - 1;
        }
        
    }
}