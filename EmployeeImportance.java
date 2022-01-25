/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using BFS
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        while(!q.isEmpty()) {
            int i = q.poll();
            Employee emp = map.get(i);

            result += emp.importance;
            for(Integer s : emp.subordinates) {
                q.add(s);
            }
        }
        return result;
    }
}

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(h+n), where h is the height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using DFS
    int result;
    public int getImportance(List<Employee> employees, int id) {
        result = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        dfs(id, map);
        return result;
    }

    private void dfs(int empId, HashMap<Integer, Employee> map) {
        Employee emp = map.get(empId);
        result += emp.importance;
        for(Integer s : emp.subordinates) {
            dfs(s, map);
        }
    }
}