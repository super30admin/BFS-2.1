//Time Complexity :O (m*n) :pushing into queue 
// Space complexity : O(m*n) all the rotten oranges will go into queue. 

class Solution {
    
 class Pair {

        int x;
        int y; 

        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }
    }
    
    public int orangesRotting(int[][] grid) {
       
        // Fresh Oranges 
        int freshOranges = 0;
        
        // a queue to perform the BFS
        Queue <Pair> q = new LinkedList<>();
        
        // result
        int time = 0;
        int size = 0; // level at which other oranges are getting rotten
        
        // Push the rotten oranges into the queue
        for (int i = 0; i < grid.length ; i++){
            for (int j = 0; j < grid[0].length ; j++){
                
                // if rotten
                if (grid[i][j] == 2){
                    
                    // add into the queue
                    q.add(new Pair(i, j));
                }
                
                if (grid[i][j] == 1){
                    // fresh orange
                    freshOranges++;
                }
            }
        }
        
        
        if (freshOranges == 0){
            return 0; // no need to check if any left
        }
        
        // Traverse through the elements (Apply BFS till queue is empty)
        while (! q.isEmpty()){
            
            
            // size computation
            size = q.size();
            
            for (int i =0; i < size ; i++){
                // current rotten orange 
                Pair pair =  q.poll();
                
                // Directions as we need 4 directions while applying BFS
                int[][] dirs = {{0,-1} , {-1,0} , {0,1}, {1,0}};
                
                for (int[] d : dirs){
                    
                    // curr row
                    int row =  pair.getX() + d[0];
                    // curr col
                    int col =  pair.getY() + d[1];
                    
                    if (row >=0 && row < grid.length && col >=0  && col < grid[0].length){
                        
                        // update the value as rotten
                        if (grid[row][col] == 1){
                            grid[row][col] = 2;
                            
                            // fresh orange reduced
                            freshOranges--;
                            
                            // it becomes independent node after updating it as 2
                            q.add(new Pair(row, col));
                            
                        }
                    }
                    
                }
            }

            // after each level, update time
            time++;
        }
        
        if (freshOranges != 0){
            return -1;
        }        
        
        
        // Initial rotten ones (where we selected 2s at first, it will increment the time)
        //so decrement the time
        return time - 1 ;
    }
}

