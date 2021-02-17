class Solution {
    
    
    public int orangesRotting(int[][] grid) {
        int dir [][]  = { {-1,0}, {1,0}, {0,1}, {0,-1}};
        if(grid.length == 0 ) {
            return  -1;
        }
        
        int freshCount  = 0;
        
        Queue<int[]> q =  new LinkedList();
        for(int i = 0;i< grid.length; i++ ){
            for(int j =0; j< grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int [] {i,j});
                } 
                if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // no rotten and all fresh oranges
        if(freshCount == 0) return  0;
        int count = 0;
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            while(size-- > 0 ){
                int [] _pair = q.poll();
                int x = _pair[0];
                int y =_pair[1];
            
                for( int [] d :  dir) {
                    int dx =  x + d[0];
                    int dy = y + d[1];
                    if( dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1) {

                        grid[dx][dy] = 2;
                        q.add(new int[]{dx,dy});
                        freshCount--;
                     }

                    }    
            }
            
            count++;
        }
        
        if(freshCount > 0) {
            return -1;
        }
        return count-1;
            
    }
        
    }
    
