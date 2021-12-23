// Time Complexity : O(V+E) O(n)
// Space Complexity : O(V) O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// Used a queue to store the id
// Based on the id got the object from the HashMap and added the importance to it
// added the subs to the queue

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;
        int total = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees)
            map.put(emp.id, emp);
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while (!q.isEmpty()) {
            int eid = q.poll();
            Employee obj = map.get(eid);
            total += obj.importance;
            for (int sub : obj.subordinates)
                q.add(sub);
        }
        return total;

    }
}

// Time Complexity : O(V+E) O(n)
// Space Complexity : O(V) O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a recursive approach
// took the id
// got the object from the map using id
// added the importance to the total
// on the subs did the dfs

class Solution {
    HashMap<Integer, Employee> map;
    int total;

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;
        total = 0;
        map = new HashMap<>();
        for (Employee emp : employees)
            map.put(emp.id, emp);
        dfs(id);
        return total;
    }

    public void dfs(int id) {
        Employee obj = map.get(id);
        total += obj.importance;
        for (int sub : obj.subordinates)
            dfs(sub);
    }

}
