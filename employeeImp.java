// Time Complexity :V+E
// Space Complexity :O(n)+maximum no of subordinates in one levels
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we are doing bfs for employees subordinates and adding their importances. to avoid extra o(n) traversal,
//we'll make a hashmap to get employee object by id to perform bfs
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
        if (employees == null || employees.size() == 0)
            return 0;
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        q.add(id);
        int imp = 0;
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            map.put(emp.id, emp);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            Employee currEmp = map.get(curr);
            imp += currEmp.importance;
            List<Integer> dep = currEmp.subordinates;
            for (int d : dep) {
                q.add(d);
            }
        }
        return imp;
    }
}