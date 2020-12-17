/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
Time Complexity : O(V+E) V-->subordinates E-->(V-1)
Space : O(N)
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
       if(employees == null || employees.size() == 0){
           return 0;
       }
       Map<Integer,Employee> map = new HashMap<>();
       for(Employee employee : employees){
           map.put(employee.id,employee);
       }
       Queue<Integer> q = new LinkedList<>();
       q.add(id);
        int importance = 0;
       while(!q.isEmpty()){
           int curr = q.poll();
           Employee obj = map.get(curr);
           importance += obj.importance;
           for(Integer sub : obj.subordinates){
               q.add(sub);
           }
       }
        return importance;
    }
}