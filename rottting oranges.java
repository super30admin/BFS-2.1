//Timecomplexity:- O(m*n);
//space complexity:-O(1);
//Did it run on leetcode:- Yes.
//Any problems faced while doing:- yes, got some wrong answers.
// explanation with your code:- As it may have multiple entries using bfs . Idea is elements with value 2 their indices are added to queue
//these are removed and next 4-directional elements are changed to 2 and added to queue. Like this once one 1 value is changed decrementing fresh counter.
// fresh counter is compared to zero and result is shown.


class Solution {
    public int orangesRotting(int[][] grid) {
        int count=0;
        int rotten=0;
        int fresh=0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh=fresh+1;
                }
                if(grid[i][j]==2){
                    rotten=-rotten+1;
                    q.add(new int[]{i,j});
                }
            }
        }
        
        if(fresh==0){
            return 0;
        }
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int x=0;x<size;x++){
                int[] a=q.poll();
                for(int[] dir:dirs){
                    int i=dir[0]+a[0];
                    int j=dir[1]+a[1];
                    if((i>=0)&&(i<m)&&(j>=0)&&(j<n)&&(grid[i][j]==1)){
                        grid[i][j]=2;
                        q.add(new int[] {i,j});
                        fresh=fresh-1;
                
                }
            }
        }
            count=count+1;
        }
        if(fresh!=0){
            return -1;
        }
   return count-1; }        
}