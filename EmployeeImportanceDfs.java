// Time Complexity : O(n)
// Space Complexity : O(h)

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer,Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        map = new HashMap<>();
        for(Employee emp:employees)
            map.put(emp.id, emp);
        dfs(id);
        return result;
    }
    
    public void dfs(int id){
        result += map.get(id).importance;
        for(int empId:map.get(id).subordinates){
            dfs(empId);
        }
    }
}