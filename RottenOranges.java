/*
Time Complexity : O(MN)
Space Complexity : O(MN)
Idea : do bfs traversal and return level
*/ 
class Solution {
    public int orangesRotting(int[][] grid) {
        int num_of_fresh = 0;
        Queue<Integer> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    num_of_fresh++;
                }else if(grid[i][j] == 2){
                    q.add(i*col + j);
                }
            }
        }
        if(num_of_fresh == 0) return 0;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                int val = q.poll();
                int r = val/col;
                int c = val%col;
                for(int[] dir : dirs){
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if(x>=0 && y>=0 && x<row && y<col && grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.add(x*col+y);
                        num_of_fresh--;
                    }
                }
                size--;
            }
            level++; 
        }
        return num_of_fresh==0?level-1:-1;
    }
}