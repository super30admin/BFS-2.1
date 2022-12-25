// Time Complexity : O(2mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : The question itself was confusing figuring out when is 1 min passed was diff


// Your code here along with comments explaining your approach
/*
The question can confuse, so here is to simplify
The question is telling that in one minute ALL of the fresh oranges which located  either Up,Down,Left,Right of the ROTTEN ORANGES  will become ROTTEN
Then those fresh oranges who are now adjacent to these NEWLY ROTTEN oranges would ROTT Next, and that is how the cycle go
Each of the cycle takes 1 minute
NOTE: at one instance all the fresh becomes ROTTEN AT ONCE, it does not happen in turn
IMPORTANT: We need to return minutes only if the whole grid can be rotten , if there are still FRESH Oranges left, then its impossible
*/
class Solution {
    int freshCount = 0; // Count the fresh oranges, if after iterations the count is 1 or above, then its impossible to ROT all of them
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
      
        /*
        At first we will identify which oranges are rotten by scanning the whole matrix and then will put the rotten indices in a Queue
        */
        for(int r=0;r<grid.length;r++){ // O(nm) as we are going over the grid
            for(int c=0;c<grid[0].length;c++){
                // if rotten then add to queue
                if(grid[r][c] == 1) freshCount++;
                else if(grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                }
            }
        }
        if (freshCount == 0) return 0;
        int time=0;
        /*
        Taking each Rotten Orange and going 4 directions to rott more orange and putting them in Queue
        */
        while(!queue.isEmpty()){ // o(nm) at worst all the elements are rotten and we have to process all of the once and only once

            int size = queue.size(); // If we process these many oranges , then it would be 1 sec
            boolean isProcessed = false; // If there are oranges processed during this iteration, then only we would increase the time count
            for(int i=0;i<size;i++){
                // Even if single one of them processed, we will keep it true
                isProcessed = isProcessed | helper(queue,grid); // The helper function would take the queue,pop the element out of it and process the other 4 oranges
            }
            if(isProcessed) time++;
        }

        if (freshCount >0) return -1; // there are still fresh oranges left, so its impossible to rott them all
        
      return time;
        
    }

    //It would go 4 directions and Rott fresh orange and then pushing their indices int the queue
    private boolean helper(Queue<int[]> queue,int[][] grid){
        
        int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}} ;
        int[] item = queue.poll(); // Taking the rotten orange out to process it
        boolean isProcessed = false;
        for(int[] pair : dirs){
            int nr = pair[0] + item[0];
            if(nr < 0 || nr >=grid.length){
                continue;
            }
            int nc = pair[1]+item[1];
            if(nc<0 || nc>=grid[0].length){
                continue;
            }

            // with nr and nc , check if we can process it
            // check if fresh

            if(grid[nr][nc] == 1){
                isProcessed = true;
                grid[nr][nc] = 2; // marking it rotten
                // now pushing inside queue
                queue.add(new int[]{nr,nc});
                freshCount--; // decrementing the fresh count
            }
        }

        return isProcessed;

    }
}