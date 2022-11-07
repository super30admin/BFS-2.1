
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

public class rottingoranges {
        public static int
                EMPTY = 0,
                FRESH = 1,
                ROTTEN = 2;

        public int directions[][] = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0 , -1}
        };
        public int orangesRotting(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            int timer = 0;
            int frshOranges = 0;

            Queue <Pair> q = new LinkedList<>();

            for (int i = 0 ; i < m ; ++i)  {
                for (int j = 0 ; j < n ; ++j){
                    if(grid[i][j] == ROTTEN){
                        q.add(new Pair(i,j));
                    }
                    else if(grid[i][j] == FRESH){
                        frshOranges++;
                    }
                }
            }


            while(!q.isEmpty()){

                Queue <Pair> qt = new LinkedList<>();

                while(!q.isEmpty()){
                    Pair p = q.poll();

                    for(int [] dir : directions){
                        int x = p.x + dir[0];
                        int y = p.y + dir[1];

                        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == FRESH){
                            grid[x][y] = ROTTEN;
                            frshOranges--;
                            qt.add(new Pair(x,y));
                        }
                    }
                }
                q = qt;
                if(!qt.isEmpty()){
                    timer++;
                }
            }
            return frshOranges == 0 ? timer : -1;
        }
    }

    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
