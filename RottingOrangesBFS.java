import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class RottingOrangesBFS {

        //BFS

        public int orangesRotting(int[][] grid) {

            int m = grid.length; int n = grid[0].length;

            // queue for bfs
            Queue<int[]> bfsQ = new LinkedList<>();

            // fresh oranges known initially
            int fresh = 0;

            for(int i = 0; i < m; i++) { //O(M*N)

                for(int j = 0; j < n; j++) {

                    // add all rotten to layer one of bfs
                    if(grid[i][j] == 2) {

                        bfsQ.add(new int[] {i,j});
                    }
                    // increase fresh oranges count if found
                    if(grid[i][j] == 1)   fresh++;

                }
            }

            //4D - array
            int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

            // when there is no fresh orange, no time is taken
            if(fresh == 0) return 0;

            //set initial time to zero
            int time = 0;

            // bfs run till queue gets empty
            while(!bfsQ.isEmpty()) { //O(M*N)

                // size of queue to differentiate levels
                int sizeQ = bfsQ.size();

                // iterate for a level
                for(int i = 0; i < sizeQ; i++) {

                    // pop out a rotten orange
                    int[] rotten = bfsQ.poll();

                    for(int[] dir: dirs) {

                        // indices of neighbors of rotten orange
                        int nr = rotten[0] + dir[0];
                        int nc = rotten[1] + dir[1];

                        // if indices of new fresh neighbor are in bound
                        if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {

                            // rot it first
                            grid[nr][nc] = 2;

                            // add it queue of rotten oranges
                            bfsQ.add(new int[] {nr, nc});

                            // decrease count of remaining fresh oranges
                            fresh--;
                        }
                    }
                }
                // increase time after each level
                time++;
            }

            //if all fresh oranges ain't get rotten, output -1
            if(fresh != 0) return -1;

            //time is increment after processing a level, there is nothing to process after last level, so discount the time raise then
            return time-1;
        }

        public static void main(String[] args) {

            RottingOrangesBFS object = new RottingOrangesBFS();

            Scanner scanObj = new Scanner(System.in);

            System.out.print("Enter the number of rows: ");
            int rows = scanObj.nextInt();

            System.out.print("Enter the number of columns: ");
            int columns = scanObj.nextInt();

            int[][] array = new int[rows][columns];

            System.out.println("Enter the elements of the array:");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print("Enter element at position (" + i + ", " + j + "): ");
                    array[i][j] = scanObj.nextInt();
                }
            }

            int answer = object.orangesRotting(array);

            System.out.println("the minimum number of minutes that must elapse " +
                    "until no cell has a fresh orange  " + answer);
        }

}

/*
TIME COMPLEXITY = O(M*N)
SPACE COMPLEXITY = O(M*N) - worst case
*/

