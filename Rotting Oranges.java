class Solution {
    public int orangesRotting(int[][] grid) {

        int fresh=0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0 ; i<grid.length ; i++)
        {
            for(int j=0 ; j<grid[i].length ; j++)
            {
                if(grid[i][j] == 1) ++fresh;
                else if(grid[i][j] == 2)
                {
                    int[] pair = new int[2];
                    pair[0] = i;
                    pair[1] = j;
                    q.add(pair);
                }
            }
        }

        if(fresh==0) return 0;

        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int time = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0 ; i<size ; i++)
            {
                int[] cords = q.poll();


                for(int[] dir : dirs)
                {
                    int nr = cords[0] + dir[0];
                    int nc = cords[1] + dir[1];

                    if(nr >=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc] == 1)
                    {
                        grid[nr][nc] = 2;
                        int[] newpair = new int[2];
                        newpair[0] = nr;
                        newpair[1] = nc;
                        q.add(newpair);
                        --fresh;
                    }
                }
            }

            ++time;
        }

        if(fresh!=0) return -1;
        else return time-1;

    }


}
