// Time Complexity : O(n) no of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : too almost one hour to get to the solution


// Your code here along with comments explaining your approach

//Using Hashmap to store employees details

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
      int result = 0;
    HashMap<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
       
        if(employees == null) return 0;
        
        for(Employee emp: employees)
        {
            map.put(emp.id,emp);
         
        }
        
        helper(id);
        return result;
    }
    
        private void helper(int id )
        {
            
            Employee emp = map.get(id);
            result = result + emp.importance;

               for(int sid: emp.subordinates)
               {
                   helper( sid );
               }
            
        }
    
}