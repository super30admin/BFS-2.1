// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int orangesRotting(int[][] grid) {
        int countFresh=0;
        int level=0;
        Queue<int[]> qu=new LinkedList<int[]>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    qu.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    countFresh=countFresh+1;
                }
            }
        }
        //System.out.println("hi"+countFresh);
        if(countFresh==0) return 0;
        //System.out.println(qu);
        if(qu.isEmpty()) return -1;
        int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
        while(!qu.isEmpty()){
            int size=qu.size();
            for(int i=0;i<size;i++){
                int[] current=qu.remove();
                for(int[] dir :dirs){
                    int row=current[0]+dir[0];
                    int col=current[1]+dir[1];
                    if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1){
                        qu.add(new int[]{row,col});
                        grid[row][col]=-1;
                        countFresh=countFresh-1;
                    }
                }
                
            }
            level=level+1;
        }
        //System.out.println(countFresh);
        //System.out.println(level);
        if(countFresh!=0) return -1;
        return level-1;
    }
}