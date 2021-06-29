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
  HashMap<Integer,Employee> map;
  int result;
    public int getImportance(List<Employee> employees, int id) {
      //null case
      if(employees == null || employees.size() == 0) {
        return 0;
      }
      //hashmap to acess employee info
      map = new HashMap<>();
      for(Employee e : employees) {
         map.put(e.id,e);
      }
      // dfs to find the importance
      dfs(id);
      return result;
        
    }
  private void dfs(int id) {
  
    //logic
    Employee e = map.get(id);
    result += e.importance;
    //get subordinate 
    for(int subid : e.subordinates) {
      dfs(subid);
    }
  }
}