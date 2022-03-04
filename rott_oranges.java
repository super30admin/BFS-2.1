//TIme complexity: O(N)
//Space complexity: O(N)
class Solution {
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        int freshorg = 0, time = -1;
             
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==ROTTEN){
                    que.add(new Pair(i,j));
                }
                else if(grid[i][j]==FRESH)
                    ++freshorg;
            }
        }
        que.add(new Pair(-1,-1));
        int[][] directions ={{0,-1},{-1,0},{0,1},{1,0}};
        while(!que.isEmpty()){
            Pair<Integer, Integer> pi = que.remove();
            int row = pi.getKey();
            int col = pi.getValue();
            if(row == -1){
                time++;
                if(!que.isEmpty())
                    que.add(new Pair(-1,-1));
                
            }
            else{
                for(int[] dir: directions){
                    int x = row + dir[0];
                    int y = col + dir[1];

                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length){
                        if(grid[x][y] == FRESH){
                            grid[x][y] = ROTTEN;
                            --freshorg;
                            que.add(new Pair(x,y));
                        }
                    }
                }
            }
        }
        
        return freshorg == 0 ? time: -1;
        
    }
}
