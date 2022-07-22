import java.util.HashMap;
import java.util.List;
// Time Complexity : O(n) , n=no. of subordinates
// Space Complexity : O(n), HashMap Space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Solution {
    int TotalImportance;
    HashMap<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;
        // DFS solution

        for (Employee e : employees) { // creating the adjacency list
            map.put(e.id, e);
        }
        dfs(id);
        return TotalImportance;
    }

    public void dfs(Integer id) {
        Employee emp = map.get(id);
        if (emp != null) {
            TotalImportance += emp.importance; // for each node adding its importance
            for (int sub : emp.subordinates) { // moving to its subordinates.
                dfs(sub);
            }

        }

    }
}