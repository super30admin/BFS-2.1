import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
// Rotting Oranges
//Time Complexity : O(m,n)
//Space Complexity : O(m,n)
class Solution {
   int [][] dirs;
   int m,n;
   public int orangesRotting(int[][] grid) {
    //null case
     if(grid==null || grid.length==0){
         return 0;
     }
     m = grid.length;
     n = grid[0].length;
     dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
     Queue <int []> q= new LinkedList<>();
     //for counting number of fresh oranges
     int fresh = 0;
     for(int i = 0; i < m; i++){
         for(int j = 0; j < n; j++){
             //given 1 indicates fresh so increase count
             if(grid[i][j] == 1) fresh++;
             //given 2 indicates rotten add to queue
             else if(grid[i][j] == 2){
                 q.add(new int[] {i,j});
             }
         }
     }
     //if no fresh oranges
     if(fresh == 0) return 0;
    //time taken to make fresh oranges rotten
    int time = 0;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i < size; i++){
          int[] curr = q.poll();
          //add children of curr and change from 1-->2 to specify it rotten and decrease fresh count by 1
          for(int [] dir : dirs){
              int r = dir[0] + curr[0];
              int c = dir[1] + curr[1];
              if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){
                 q.add(new int[] {r,c});
                 grid[r][c] = 2;
                 fresh--;
              }
          }
        }
        //increase time by 1 to specify one is rotten
        time++;
       
    }
       //if still fresh oranges remain in the end return -1
       if(fresh != 0) return -1;
       return time-1;
   }
}
 
 
// Employee Importance
//Time Complexity : O(N)
//Space Complexity : O(N)
class Employee {
   public int id;
   public int importance;
   public List<Integer> subordinates;
};
 
 
class Solution1 {
   HashMap<Integer, Employee> map;
   int result;
   public int getImportance(List<Employee> employees, int id) {
       map = new HashMap<>();
       //null
       if(employees == null) return 0;
       //put into map employee id and employee node of each node
       for(Employee e : employees){
           map.put(e.id,e);
       }
       //queue of ids
       Queue<Integer> q = new LinkedList<>();
       q.add(id);
       while(!q.isEmpty()){
           int curr_emp_id = q.poll();
           Employee emp = map.get(curr_emp_id);
           //get importance of current employee
           result += emp.importance;
           //go through each subordinate and add to queue
           for(int sub : emp.subordinates){
               q.add(sub);
           }
       }
       return result;
   }
}
 
 
 

