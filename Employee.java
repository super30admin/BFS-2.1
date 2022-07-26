// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class Solution {
    int TotalImportance;
    HashMap<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;

        for (Employee e : employees) { 
            map.put(e.id, e);
        }
        helper(id);
        return TotalImportance;
    }

    public void helper(Integer id) {
        Employee emp = map.get(id);
        if (emp != null) {
            TotalImportance += emp.importance; 
            for (int sub : emp.subordinates) { 
                helper(sub);
            }

        }

    }
} 