
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
   private int dfs(int id){
       if(arrList.get(id) == null || arrList.get(id).size() == 0){
           return 0;
       }

       // logic
       for(int i = 0 ;i < arrList.get(id).size(); i++){
            importance +=  map.get(id);
            dfs(arrList.get(id).get(i));

       }

       return importance;
   }
 }
