//Time Complexity : O(m*n) ; where m is number of rows and n is number of columns in the grid
//Space Complexity : O(m*n)
public class RottingOranges {	
	public int orangesRotting(int[][] grid) {
        if(grid==null || grid[0]==null) return 0;
        
        int m= grid.length;
        int n= grid[0].length;        
        Queue<int[]> q= new LinkedList<>();
        int freshCnt=0;
        //Add all rotten oranges to queue to start processing
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshCnt++;
                }
            }
        }
        //If queue is empty and no fresh orange found, i.e. nothing to rot
        if(q.isEmpty() && freshCnt==0) return 0;
        
        //dir to searhc in all 4 direction
        int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
        
        //process oranges
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                int[] curr= q.poll();
                
                for(int[] dir: dirs){
                    int r= curr[0]+dir[0];
                    int c= curr[1]+dir[1];
                    
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1){
                        grid[r][c]=2; //make fresh one to rotten
                        q.add(new int[]{r,c});
                        freshCnt--;
                    }
                }                
            }
            level++;
        }
        
        //If queue is empty and fresh oranges are there i.e. all of them cannot be rotten
        if(freshCnt>0) return -1;
        
        //Return level-1 as we would have increased while processing the last orange in grid
        return level-1;
    }

	// Driver code to test above 
	public static void main (String[] args) {
		RottingOranges ob= new RottingOranges();
		int[][] arr= {{2,1,1},{1,1,0},{0,1,1}};
		//int[][] arr= {{2,1,1},{0,1,1},{1,0,1}};
		
		System.out.println("Minutes elapsed to make all oranges rotten: "+ob.orangesRotting(arr));	
		
	}
}
