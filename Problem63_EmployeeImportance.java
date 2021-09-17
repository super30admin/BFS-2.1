// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


import java.util.*;
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        int importance = 0;
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while(!queue.isEmpty()) {
            Employee current = queue.poll();
            importance += current.importance;
            for(int subordinate: current.subordinates) {
                queue.add(map.get(subordinate));
            }
        }
        return importance;
    }
}