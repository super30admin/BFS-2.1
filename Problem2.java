// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//690. Employee Importance
//https://leetcode.com/problems/employee-importance/

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
        int result = 0;
        // create a hashmap first
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {

            map.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i : map.get(q.peek()).subordinates) {
                q.add(i);
            }
            result += map.get(q.peek()).importance;
            q.remove();
        }

        return result;
    }
}

