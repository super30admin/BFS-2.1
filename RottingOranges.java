//Time Complexity O(n)
//Space Complexity O(n/2)
//Leetcode tested

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    
    public static int orangesRotting(int[][] grid) {

        int rlen=grid.length;
        int cLen=grid[0].length;
        int count=0;
        int twoCount=0;
        Queue<int []> queue =new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < cLen; j++) {
                if(grid[i][j] == 1)
                    count++;
                if(grid[i][j] == 2){
                    twoCount++;
                    queue.add(new int[]{i,j});
                    grid[i][j]=3;
                }
            }
        }
        if(count==0){
            return 0;
        }
        if(twoCount == 0)
            return -1;

        /*for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < cLen; j++) {
                if(grid[i][j] == 2){
                    arr.add(rotOranges(grid,i,j,count));
                }
            }
        }*/


        int answer=rotOranges(grid,queue,count);
        //System.out.println(answer);
        if(answer == Integer.MAX_VALUE)
            return  -1;

        return answer;
    }

    public static int rotOranges(int[][] mat, Queue<int []> queue, int count){
        int lastEntry=0;
        //Queue<int []> queue =new LinkedList<>();
        //Queue<int []> resetQ =new LinkedList<>();
        //queue.add(new int[]{i,j});

        int[][] dirs={
                {0,1},
                {-1,0},
                {1,0},
                {0,-1}
        };
        int length=0;
        int counterCheck=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            length++;
            //System.out.println(length);
            while (size --> 0){
                int[] cell= queue.poll();
                for (int[] dir:dirs) {
                    int r=cell[0]+dir[0];
                    int c=cell[1]+dir[1];
                    if(r<0 || c<0 || r==mat.length || c==mat[0].length || mat[r][c] == 0 || mat[r][c]==3)
                        continue;
                    if(mat[r][c] == 1){
                        counterCheck++;
                    }
                    lastEntry=mat[r][c];
                    //resetQ.add(new int[]{r,c,mat[r][c]});
                    mat[r][c]=3;
                    //System.out.println(r+" "+c);
                    queue.add(new int[]{r,c});
                }
            }
        }

       /* for (int []item:resetQ) {
            int x=item[0];
            int y=item[1];
            int z=item[2];
            //mat[x][y]=z;
        }*/
        //System.out.println(lastEntry+" last entry");
        if(lastEntry == 2){
            length--;
        }
        if(counterCheck == count){
            return --length;
        }else{
            return Integer.MAX_VALUE;
        }
    }


}
