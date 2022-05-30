import java.util.*;

class Solution {
    // DFS Solution
    // Time complexity is O(V+E)
    // Space complexity is O(V+E)
    // This solution is submitted on leetcode with zero errors
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    HashMap<Integer, Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        // Edge case
        if(employees.size()==0 || employees == null)
            return -1;
        // Creating adjacency list
        map = new HashMap<>();
        for(Employee emp :employees){
            map.put(emp.id,emp);
        }
        dfs(id);
        return result;
    }
    private void dfs(int id){
        Employee emp = map.get(id);
        result+= emp.importance;
        for(int sub: emp.subordinates){
            dfs(sub);
        }
    }
}