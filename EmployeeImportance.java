//Problem : 63 - Employee Importance
// Time Complexity : O(V), V stands for vertices that are nodes(Emp Ids)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
  This is a graph problem similar to course schedule.
  1) Iterate over the employee list and insert employee ids along with employee object which is the data about employee.
  2) While iterating over the queue, add the importance value and inserts all the subordinates inside the queue. Assume list of subordinates as edges. 
*/

/*
  Note : Here problem can be solved using BFS or DFS.
*/

import java.util.*;
class Solution63 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    private int totalImp;
    public int getImportance(List<Employee> employees, int id) {
      
        if(employees==null || employees.size()==0) return 0;
        
        Map<Integer,Employee> empMap = new HashMap<>();
        
        for(Employee emp : employees){//TC:O(V)| SC:O(V), because we are storing only ids, employee will point to existing employee object.
    
            empMap.put(emp.id,emp);
            
        }
        
        //BFS
        /*Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        totalImp =0;
        
        while(!q.isEmpty()){//TC:O(V), becuase edges will be unique, same edges won't repeat like edges were repeating in course schedule. Here edhes will be unique and thus asymptomatically TC will be O(V) | TC:O(V) | SC:O(V)
            
            int currId    = q.poll();
            Employee emp  = empMap.get(currId);
            totalImp     += emp.importance;
            
            List<Integer> edges = emp.subordinates;
            
            for(int edge:edges){
                q.offer(edge);
            }
            
        }*/
        
        //DFS: TC:O(V), SC:O(V)
        dfs(id,empMap);
        
        return totalImp;
    }
    
    private void dfs(Integer empId, Map<Integer,Employee> empMap){
        
        totalImp += empMap.get(empId).importance;
        for(Integer subOrd:empMap.get(empId).subordinates){
            dfs(subOrd,empMap);
        }
        
    }
}