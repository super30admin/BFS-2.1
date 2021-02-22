// Time Complexity : O(n)
// Space Complexity : O(n)- size of Employees
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null)
            return 0;

        Queue<Integer> q = new LinkedList<>();

        HashMap<Integer, Employee> map = new HashMap<>();

        for (Employee x : employees) {
            map.put(x.id, x);
        }

        q.add(id);
        int imp = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            Employee e = map.get(x);
            imp += e.importance;
            for (int y : e.subordinates) {
                q.add(y);
            }

        }

        return imp;

    }
}