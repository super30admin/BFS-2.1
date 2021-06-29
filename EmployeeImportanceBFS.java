//Time Complexity - O(n)
//Space Complexity - O(n)


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
      //null case
      if(employees == null || employees.size() == 0) {
        return 0;
      }
       
       int result = 0;
      //hashmap to acess employee info
      HashMap<Integer,Employee> map = new HashMap<>();
      for(Employee e : employees) {
         map.put(e.id,e);
      }
  
      Queue<Integer> q = new LinkedList<>();
      //add given id to to the q
      q.add(id);
      while(!q.isEmpty()) {
        int eid = q.poll();
        Employee e = map.get(eid);
        result += e.importance;
        for(int subid : e.subordinates) {
          q.add(subid);
        }
      }
      return result;
        
    }
 
}