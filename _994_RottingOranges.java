
/*****************************************************BFS****************************************************************************/

/*
Time Complexity : o(row*column)
 Space Complexity :  o(row*column)

 Approach : Add all rotten tomataoes in Queue and explore neibors, if fresh tomatao is encountered then make it rotten and decremnt fresh oranges encounter
Every time we exhaust a level of rotten oranges increment time.

 */

class Solution {

    int[] xArr = {-1,1, 0,0};
    int[] yArr = {0,0, -1,1};

    public int orangesRotting(int[][] grid) {

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        int fresh = 0;

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){

                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
            }
        }

        if(fresh == 0) return 0;

        int time = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0; i< size; i++){

                Pair<Integer, Integer> p = q.poll();

                for(int j = 0; j< xArr.length; j++){

                    int xNew = p.getKey() + xArr[j];
                    int yNew = p.getValue() + yArr[j];

                    if(xNew >=0 && xNew <grid.length && yNew >= 0 && yNew < grid[0].length
                      && grid[xNew][yNew] == 1){
                        fresh--;
                        grid[xNew][yNew] = 2;
                        q.add(new Pair(xNew, yNew));
                    }

                }

            }
              time++;
        }

        return fresh!=0?-1:time-1;


    }
}

/*****************************************************DFS***************************************************************************/

/*
Time Complexity : o(row*column)
 Space Complexity :  o(row*column)

 Approach : Start dfs for all unvisited  rotten oranges. Along the dfs path, increment time for making any fresh orange rotten
If we encounter a rotten orange by some other dfs path, take the min time taken to make it rotten. If it is already at minimum time then return.
*/
class Solution {

    int[] xArr = {0,0,-1,1};
    int[] yArr = {-1,1,0,0};

    int fresh;
    int[][] time;
    boolean[][] visited;

    public int orangesRotting(int[][] grid) {

        fresh = 0;
        time = new int[grid.length][grid[0].length];
        visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0) return 0;

        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                 if(grid[i][j] == 2 && !visited[i][j])
                     dfs(grid, i, j, 0);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i =0; i< grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                max = Math.max(max, time[i][j]);
            }
        }
       return fresh != 0 ? -1 : max;

    }

    public void dfs(int[][] grid, int x, int y, int distance){

        if(grid[x][y] == 2 && visited[x][y] && time[x][y] <= distance) return;

        visited[x][y] = true;

        if(grid[x][y] == 2 && time[x][y] > distance ) {
            time[x][y] = distance;
        }
        else if(grid[x][y] == 2 && time[x][y] < distance ) {
          distance = time[x][y];
        }

        if(grid[x][y] == 1) {
            grid[x][y] = 2;
            time[x][y] = distance;
            fresh--;
        }

        for(int i = 0; i<xArr.length; i++){
            int xNew = x + xArr[i];
            int yNew = y + yArr[i];
            if(xNew>=0 && xNew<grid.length && yNew>= 0 && yNew<grid[0].length && grid[xNew][yNew] != 0){
                dfs(grid, xNew, yNew, distance + 1);
            }
        }

    }
}
