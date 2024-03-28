// Time Complexity : O(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

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
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> subordinates;
        int empId = -1, imp = 0;

        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        q.add(id);

        while (!q.isEmpty()) {
            empId = q.poll();
            Employee emp = map.get(empId);
            imp = imp + emp.importance;
            subordinates = emp.subordinates;
            for (int sub : subordinates) {
                q.add(sub);
            }
        }
        return imp;
    }
}