import java.util.*;
public class BFS {
    //https://leetcode.com/problems/rotting-oranges/submissions/
    //time complexity : M*N
    // space complexity : M*N
    // did it run on leetcode : yes
    // any doubts : no 
    public int orangesRotting(int[][] grid) {
        if(grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh=0;
        Queue<int []> q = new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]== 1) fresh++;
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int time = 0;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if(fresh == 0 ) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size ;i++){
                int[] curr = q.poll();
                for(int[] di:dirs){
                    int r = curr[0]+di[0];
                    int c = curr[1]+di[1];
                    if(r>=0 && c>= 0 && r<m && c<n && grid[r][c]==1){
                        grid[r][c]=2;
                        fresh--;
                        q.add(new int[]{r,c});
                    }
                }


            }
            time++;
        }
        if(fresh == 0 ) return time-1;
        return -1;
        
    }


    // BFS
   // https://leetcode.com/problems/employee-importance/submissions/
    //time complexity : N
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts : no 
    public int getImportance(List<Employee> employees, int id) {
    HashMap<Integer,Employee> map = new HashMap<>();    
    for(Employee e:employees){
        map.put(e.id,e);
    }
    Queue<Integer> q = new LinkedList<>();
    q.add(id);
    int result = 0;
    while(!q.isEmpty()){
        int eid = q.poll();
        Employee e = map.get(eid);
        result = result + e.importance;
        for(Integer subId: e.subordinates){
            q.add(subId);
        }
    }
    return result;   
    }

    //DFS
    static HashMap<Integer,Employee> map;
    static int result;
    public int getImportanceDFS(List<Employee> employees, int id) {
        map = new HashMap<>();  
        for(Employee e:employees){
            map.put(e.id,e);
        }
        dfs(id);
        return result;
        
    }
    private static void dfs(Integer eId){
        Employee e =map.get(eId);
        result = result + e.importance;
        for(Integer subID : e.subordinates){
            dfs(subID);
        }
    }

}
