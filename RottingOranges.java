// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
     
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        
        int getX(){
            return x;
        }
        
        int getY(){
            return y;
        }
    }
    public int orangesRotting(int[][] grid) {
      int time=0;
        Queue<Pair> queue=new LinkedList<>();
        int freshOranges=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(queue.isEmpty() && freshOranges==0) return time;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Pair curr=queue.poll();
                int[][] directions={{0,-1},{0,1},{1,0},{-1,0}};
                for(int[] d:directions){
                    int row=curr.getX()+d[0];
                    int col=curr.getY()+d[1];
                    if(row>=0 && row<grid.length && col>=0 && col<grid[0].length){
                        if(grid[row][col]==1){
                            freshOranges--;
                            grid[row][col]=2;
                            queue.add(new Pair(row,col)); 
                        }
                    }
                }
            }
            time++;
        }
        
        return freshOranges==0?time-1:-1;
        
        
    }
}