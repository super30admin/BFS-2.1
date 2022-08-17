//Space - O(m*n)
// Time O(m*n)


class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer,Integer>> q = new LinkedList();
        int min=0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if(grid[i][j]==2)
              {
                  q.add(new Pair(i,j));
              }
                   
            }
        }        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                for(int[] dir: dirs){
                    int i1 = (int)p.getKey();
                    int j1 = (int)p.getValue();
                    int row = i1 + dir[0];
                    int col = j1 + dir[1];
                    if(row>=0 && row<m && col>=0 && col<n && grid[row][col]==1){
                        grid[row][col]=2;
                        q.add(new Pair(row,col));
                    }
                }
            }
            if(!q.isEmpty())
                min++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return min;
    }
}
