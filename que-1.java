//TC:O(n*m)
//SC: O(n*m)
class Solution {
    public int orangesRotting(int[][] grid) {
     if(grid == null || grid.length == 0 || grid[0]== null || grid[0].length == 0){
         return 0;}
    Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;int i,j;
        for(i = 0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]== 2){
                    queue.add(new int[]{i,j});}
                else if(grid[i][j]== 1){
                    fresh++;}
            }
        }
        int time = 0;
        int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int o = 0; o<size;o++){
             int[]pair = queue.poll();
                for(int[] dir: dirs){
                     i = dir[0]+ pair[0];
                     j = dir[1]+pair[1];
                    if(i>=0 && i<n && j>=0 && j<m && grid[i][j]== 1){
                        grid[i][j]=2;
                        queue.add(new int[]{i,j});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh!=0) return -1;
        return time>0? time-1: time;
    }
}