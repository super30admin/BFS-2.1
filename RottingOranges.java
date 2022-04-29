class Solution {

    //Time Complexity: 0(m*n) where m is row and n is column
    //Space Complexity : 0(m*n) where m is row and n is column
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while implementing : No

    //In Short explain your approach

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        Queue <int[]> q = new LinkedList<>(); // Queue to store the rotten oranges
        int m = grid.length; //to check if the index is not out of bounds
        int n = grid[0].length;      //to check if the index is not out of bounds
        int fresh = 0;                //to count the fresh oranges in the matrix
        int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};  //to check the oranges in all four directions
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){   //adding the index of rotten oranges in the queue so that it's neighbors can be processed
                    q.add(new int [] {i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){     //If there are no fresh oranges then there is nothing left to rot
            return 0;
        }
        int minute = 0;       //calculate the time for all fresh oranges to rot
        while(!q.isEmpty()){
            int size = q.size();    //keeping a tab of the size of queue as the elements are processed in the queue
            for(int i = 0; i< size; i++){
                int[] current = q.poll();       //popping the index of rotten orange to check it's neighbors
                for(int[] dir: direction){
                    int r = dir[0] + current[0];    //getting the new row by navingating left,right,up,down
                    int c = dir[1] + current[1];    //getting the new column by navingating left,right,up,down
                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){//checking if index is in bound and if fresh orange is there or not
                        grid[r][c] = 2;
                        q.add(new int[] {r,c});
                        fresh--;        //reducing the fresh orange as it has rot
                    }
                }
            }
            minute++;       //increasing the time as one check is complete
        }
        if(fresh != 0){
            return -1;
        }
        return minute - 1;
    }
}