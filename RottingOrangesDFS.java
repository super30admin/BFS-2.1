import java.util.Scanner;

public class RottingOrangesDFS {

        //DFS

        int m,n;
        int[][] dirs;

        public int orangesRotting(int[][] grid) {

            dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

            m = grid.length;     n = grid[0].length;

            //nested for loop to check rotten oranges
            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    if(grid[i][j] == 2) {

                    /* start DFS from any rotten orange, with initial offset = 2
                    time is initially 2 because we are overriding fresh oranges with time, instead of storing the clock ticks separately (1 -> fresh orange, 0 -> no orange, 2-> rotten at 0, 3 or more -> rotten at time-2 ) */
                        dfs(grid, i, j, 2);
                        //ultimately, do dfs from each rotten orange
                    }

                }
            }

            // result variable
            int minMinutes = 0;

            // nested for loop to calculate result after DFS
            for(int[] row: grid) {

                for(int cell: row) {

                    // if any fresh orange remains after DFS, return -1
                    if(cell == 1) return -1;

                        // we have set initial time offset to two where DFS runs
                    else if(cell > 2) {

                        //deduct offset
                        cell = cell -2;

                        minMinutes = Math.max(minMinutes, cell);
                    }
                }
            }
            return minMinutes;
        }

        private void dfs(int[][] grid, int r, int c, int newTime) {

            //base
            // new neighbor indices be in range and not touch empty cells
            if(r < 0 || c < 0 || r == m || c == n || grid[r][c] == 0) return;

            // optimizing search
            // if existing non-1 cell value is smaller than new time, don't dfs
            if(grid[r][c] != 1 && grid[r][c] < newTime) return;
            // when grid value is 1 initially, we will run DFS

            //logic
            grid[r][c] = newTime;

            // new 4D neighbors
            for(int[] dir: dirs) {

                int nr = dir[0] + r;
                int nc = dir[1] + c;

                // increase new time by 1 when doing dfs at new neighbor
                dfs(grid, nr, nc, newTime+1);
            }
        }

    public static void main(String[] args) {

        RottingOrangesDFS object = new RottingOrangesDFS();

        Scanner scanObj = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanObj.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanObj.nextInt();

        int[][] array = new int[rows][columns];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //System.out.print("Enter element at position (" + i + ", " + j + "): ");
                array[i][j] = scanObj.nextInt();
            }
        }

        int answer = object.orangesRotting(array);

        System.out.println("the minimum number of minutes that must elapse " +
                "until no cell has a fresh orange  " + answer);
    }



}


/*
TIME COMPLEXITY = O((M*N)^2)

DFS at each cell
M*N cells
M*N for one DFS at one cell
therefore, M*N*(M*N)

SPACE COMPLEXITY = O(M*N) - recursive stack space

SO, BFS is a better choice in such patterns
*/
