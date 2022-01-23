// Time Complexity :O(v+e) or we can cay O(n) in worst case.
// Space Complexity :O(n) no.of nodes{in this problem employees}
// Did this code successfully run on Leetcode :yes
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList();
        //Employee e = new Employee();
        for(Employee e :employees){
            map.put(e.id,e);
        }
        int result = 0;
        q.add(id);
        while(!q.isEmpty()){
           int eid = q.poll();
           Employee e = map.get(eid);
            result += e.importance;
            for(int subid : e.subordinates)
            q.add(subid);
        }
        return result;
    }
    
}

/////////////
// Time Complexity :O(mn) 
// Space Complexity :O(mn) 
// Did this code successfully run on Leetcode :yes
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null) return 0;
        Queue <int []> q = new LinkedList<>();
        int time =0;
        int fresh = 0;
        int [] [] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i =0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
            if(q.isEmpty()&& fresh == 0) return time;
            while(!q.isEmpty()){
                int size = q.size();
                
                for(int i = 0;i<size;i++){
                     int [] curr = q.poll();
                for(int [] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && c >=0 && r < grid.length 
                       && c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int [] {r,c});
                        fresh--;
                    }
                }
                }
                 time++; 
            }
            
      
        if(fresh != 0) return -1;
        return time -1;
    }
}
