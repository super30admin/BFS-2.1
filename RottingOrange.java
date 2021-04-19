/**Leetcode Question 994 - Rotting Orange */
/**Algorithm - BFS
 * create a queue and add all the rotten oranges given in the initial matrix
 * keeep a count of fresh in the initial matrix
 * if fresh ==0 in the initial matrix, return 0
 * Run the queue to it's size and add the neighbouring elements that are fresh to the queue
 * Increment time;
 */
/**TC - O(M*N)
 * SC -(M*N) - In worst case if all the oranges are rottrn, they will end up in the queue
 */
public class RottingOrange {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int time = 0, fresh =0;
            int m = grid.length, n = grid[0].length; 
            Queue<int[]> q = new LinkedList<>();
            for(int i =0; i<m; i++){
                for(int j =0; j<n; j++){
                    if(grid[i][j] == 2){
                        q.add(new int[] {i,j});
                    }
                    else if(grid[i][j] == 1){
                        fresh++;
                    }
                }
            }
            if(fresh == 0){
                return 0;
            }
            int[][] dir = {{0,1}, {0,-1}, {1,0},{-1,0}};
            while(!q.isEmpty()){
                int size = q.size();
                for(int i =0; i<size; i++){
                    int[] curr = q.poll();
                    for(int[] dirs : dir){
                        int r = curr[0] + dirs[0];
                        int c = curr[1] + dirs[1];
                        if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == 1){
                        q.add(new int[] {r,c});
                        fresh--;
                        grid[r][c] = 2;
                        }
                    } 
                }
                time++;
            }
            if(fresh!=0){
                return -1;
            }
            return time-1;
        }
    }
}
