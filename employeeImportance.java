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
// Time Complexity : O(n) or O(v+e)
// Space Complexity : O(n) or O(v+e)
// BFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int total=0; // total importance

        for (Employee emp: employees) {
            map.put(emp.id, emp);
        }

        q.add(id);
        while(!q.isEmpty()) {
            int idx = q.poll();
            Employee e = map.get(idx);
            total += e.importance;

            for(Integer sub: e.subordinates) {
                q.add(sub);
            }
        }

        return total;
    }
}

// Time Complexity : O(n) or O(v+e)
// Space Complexity : O(n) or O(v+e)
// DFS
class Solution {
    Map<Integer, Employee> map;
    int total; // total importance
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        map = new HashMap<>();

        for (Employee emp: employees) {
            map.put(emp.id, emp);
        }

        dfs(id);

        return total;
    }

    private void dfs(int id) {
        //base

        //logic
        Employee emp = map.get(id);
        total += emp.importance;

        //recurse
        for (Integer s: emp.subordinates) {
            dfs(s);
        }
    }
}