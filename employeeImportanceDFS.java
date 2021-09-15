/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// Time Complexity: O(n) to put all the employee in map as there is list of subordinate to put at each index and O(n) to traverse all subordinate to fetch sum. => O(n)
// Space Complexity: Map is used of value size n at each index => O(n) 
// Did you complete it on leetcode: Yes
// Any problems faced: Could not come up with solution

// Write your approach here
// Idea here is to find required parent employee. To save n^2 time complexity we have saved each employee with id as key in a map.
// now we can get the employee based on id(key) in constant time.
// Once we get employee, add its importance to sum and recurse through its subordinates
// to add their importance.
// final sum is returned.
class Solution {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e: employees) {
            map.put(e.id, e);
        }
        return dfs(id);
    }
    public int dfs(int id) {
        Employee e = map.get(id);
        int sum = e.importance;
        for(Integer sub: e.subordinates) {
            sum+=dfs(sub);
        }
        return sum;
    }
}