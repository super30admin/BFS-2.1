// Time Complexity : The time complexity is O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity is O(m*n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int orangesRotting(int[][] grid) {

        // To traverse 4 directions
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        if(grid == null || grid[0] == null){
            return -1;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int minutes = 0;

        for(int i=0;i<rows;i++){

            for(int j=0;j<columns;j++){

                // Add rotten oranges to the queue
                if(grid[i][j] == 2){
                    q.offer(i);
                    q.offer(j);
                }

                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        if(q.isEmpty() && count==0) return 0;
        if(q.isEmpty()) return -1;
        if(count == 0) return 0;

        int size=q.size();

        while(!q.isEmpty()){

            int row = q.poll();
            int column = q.poll();
            size -= 2;

            for(int i=0;i<dir.length;i++){

                int newRow = row+dir[i][0];
                int newColumn = column+dir[i][1];

                // Add a fresh orange that is adjacent to a rotten orange in the queue
                if(newRow >=0 && newRow < rows && newColumn >=0 && newColumn < columns && grid[newRow][newColumn] == 1){
                    q.offer(newRow);
                    q.offer(newColumn);
                    grid[newRow][newColumn] = 2;
                    count--;
                }
            }

            if(size == 0){
                minutes++;
                size=q.size();
            }
        }

        if(count > 0) return -1;

        return minutes-1;

    }
}