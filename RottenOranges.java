// Time Complexity : O(mn)
// Space Complexity : O(mn)
// works in leetcode
class Solution {
    private static final int
            EMPTY=0,
            FRESH=1,
            ROTTEN=2;

    private int [][] directions =  {
            {-1, 0},  //up
            {1, 0},  //down
            {0, -1},  //left
            {0, 1}   //right
    };

    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        int freshOranges= 0;

        int m = grid.length;
        int n = grid[0].length;
        //intitialize grid
        for(int i=0;i<m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==ROTTEN)
                    q.add(new Pair(i,j));
                else if(grid[i][j] == FRESH)
                    freshOranges++;

            }

        }

        int time=0;
        while(!q.isEmpty()){

            Queue<Pair> next = new LinkedList<>();


            while(!q.isEmpty()){
                Pair p = q.remove();

                for(int [] dir : directions){

                    int nRow = p.row + dir[0];
                    int nCol = p.col + dir[1];

                    if(nRow >=0 && nRow<m && nCol >=0 && nCol <n && grid[nRow][nCol]==FRESH){
                        next.add(new Pair(nRow,nCol));
                        grid[nRow][nCol] = ROTTEN;
                        freshOranges--;

                    }

                }

            }
            q=next;

            if(!q.isEmpty())
                time++;


        }
        if(freshOranges > 0)
            return -1;
        return time;
    }

}

class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }

}