// Time Complexity : O(n2) no of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : too almost one hour to get to the solution


// Your code here along with comments explaining your approach


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
    public int getImportance(List<Employee> employees, int id) {
       
        for(Employee emp: employees)
        {
            if(emp.id == id)
            {
                result = result + emp.importance;
                helper(employees,emp.subordinates,id);
            }
        }
        return result;
    }
        private void helper(List<Employee> employees,List<Integer> subordinates , int id )
        {
           
             for(int Sid: subordinates)
             {
                 for(Employee emp: employees)
                {
                    if(emp.id == Sid)
                    {
                         result = result + emp.importance;
                        helper(employees,emp.subordinates,emp.id);
                     }
                 }
              }
        }
}