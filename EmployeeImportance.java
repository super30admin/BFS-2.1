// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Solution {
    int total;
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;

        // create an adjacency list
        map = new HashMap<>();
        //initialize total
        total = 0;

        // generate adjacency list
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        dfs(id);
        return total;
    }

    private void dfs(int id) {
        // base case

        // logic
        Employee emp = map.get(id);
        total += emp.importance;
        List<Integer> sub = emp.subordinates;
        //recursion
        if (sub != null) {
            for (int s : sub) {
                dfs(s);
            }
        }
    }
}

// class Solution {
//     public int getImportance(List<Employee> employees, int id) {
//         if (employees == null || employees.size() == 0) return 0;

//         // create an adjacency list
//         HashMap<Integer, Employee> map = new HashMap<>();

//         // generate adjacency list
//         for (Employee e : employees) {
//             map.put(e.id, e);
//         }

//         //BFS initialization
//         Queue<Integer> queue = new LinkedList<>();
//         int total = 0;
//         queue.add(id);

//         while(!queue.isEmpty()) {
//             int curr = queue.poll();
//             total += map.get(curr).importance;
//             List<Integer> sub = map.get(curr).subordinates;
//             if (sub == null) continue;
//             for (int s : sub) {
//                 queue.add(s);
//             }
//         }

//         return total;
//     }
// }
