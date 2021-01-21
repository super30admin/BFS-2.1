
// Time Complexity : O(V) + O (Nˆ2) |  O(V) for all verticies data collection.
// Space Complexity : O(Nˆ2) (Considering recursive stack space)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time limit exceeded

/* approach
  1. Go through all oranges, if it is ROTTEN then check all neighbouring oranges and make them ROTTEN
  2. in dfs each recursive call check for index if they are within bounds
   then make it rotton and continue dfs on each of those neighbours
*/

import java.util.*;

class EmployeeImportance{
  int importance = 0;
   List<List<Integer>> arrList = null;
   HashMap<Integer,Integer> map = null;

   public int getImportance(List<Employee> employees, int id) {
       if(employees == null || employees.size() == 0){
           return 0;
       }

       arrList = new ArrayList<>();
       map = new HashMap<>();

       for(Employee emp : employees){
           map.put(emp.id, emp.importance);

           if(!emp.subordinates.isEmpty()){
               if(emp.id == arrList.size()){
                   arrList.add(emp.id, new ArrayList<Integer>());
               }
           }
       }

       dfs(id);

       return importance;
   }

   // class room version
   // T(n) = O(V) -
   // S(n) = O(V) - Hashmap
   public int getImportanceBFS(List<Employee> employees, int id) {
     if(employees == null || employees.size() == 0){
         return 0;
     }
     int result = 0;
     Queue<Integer> q = new LinkedList<>();
     q.add(id);
     HashMap<Integer, Employee> map = new HashMap<>();
     for(Employee emp : employees){
       map.put(emp.id, emp);
     }

     while(!q.isEmpty()){
        Employee curr = map.get(q.poll());
        result += curr.importance;
        for(int subId : curr.subordinates){
          q.add(subId);
        }
     }

     return result;
   }


   int result = 0;
   HashMap<Integer, Employee> map = new HashMap<>();
   public int getImportanceDFS(List<Employee> employees, int id) {
     if(employees == null || employees.size() == 0){
         return 0;
     }

     for(Employee emp : employees){
       map.put(emp.id, emp);
     }
     dfs(id);
     return result;
   }

   // S(n) = O(V) - Hashmap
   private  void dfs(int id){
      // base case - we're iterating over emp.subordintes so won't go out of bounds
      // no need of base case

       // logic
       Employee emp = map.get(id);
       result += emp.importance;

       for(int subId  : emp.subordinates){
            dfs(subId);
       }
   }
 }
