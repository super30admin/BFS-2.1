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
// Idea here is to perform BFS and using adjacency list and queue to identify the boss
// employee to be found and all its subordinates.
// with id as key we are able to find employee id in constant time.
// once found we are adding its importance and
// reaching all its child and adding them to queue which will continue until queue is empty.
// it gives addition of all the importances
class Solution {
    Map<Integer, Employee> map;
    int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Employee e: employees) {
            map.put(e.id, e);
        }
        q.add(id);
        while(!q.isEmpty()) {
            int eid = q.poll();
            Employee emp = map.get(eid);
            sum+=emp.importance;
            for(int sub: emp.subordinates) {
                q.add(sub);
            }
        }
        return sum;       
    }
}