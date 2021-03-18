// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    public int getImportance(List<Employee> employees, int id) {
      
      if(employees == null || employees.size()==0)
      {
        return 0;
      }
      
      int importance = 0;
      
      Queue<Integer> queue = new LinkedList<>();
      //to store all employee information in value and key as employee id
      HashMap<Integer,Employee> map = new HashMap<>();
      
      for(Employee e :employees)
      {
        map.put(e.id,e);
      }
      
      queue.add(id);
      while(!queue.isEmpty())
      {
        int empId = queue.poll();

        //get all subordinate for an employee using employeeid
        List<Integer> subord = map.get(empId).subordinates;

        //
        int imp = map.get(empId).importance;
        importance= importance + imp;
        //add subordinates to the queue
        for(int sub : subord)
        {
          queue.add(sub);
        }
      }
        return importance;
    }
}