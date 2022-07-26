// Time complexity: O(n)
// Space complexity: O(n), since hashmap is used store all employees information
// To find indirect subordinates, we need to go into each of the subordinates
// and their subordinates to add the result.
// DFS will be best approach for this,
// since we need to explore to the depth of subordinates of the desired employee.

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance {
    Map<Integer, Employee> hmap;
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return total;

        hmap = new HashMap<>();

        //hash map of employee id and the employee object
        for(Employee employee: employees) {
            hmap.put(employee.id, employee);
        }

        dfs(id);
        return total;
        //return getImportance(id);
    }

// BFS
//     private int getImportance(int id) {
//         Queue<Integer> q = new LinkedList<>();
//         q.add(id);

//         while(!q.isEmpty()) {
//             int eid = q.poll();
//             Employee employee = hmap.get(eid);
//             if(employee != null) {
//                 total += employee.importance;
//                 for(int subordinate: employee.subordinates) {
//                     q.add(subordinate);
//                 }
//             }
//         }
//         return total;
//     }

    private void dfs(int id) {
        //base case
        Employee employee = hmap.get(id);
        //if the employee id is null, there are no sub ordinates for that employee
        if(employee == null) return;

        //add employee importance of each of the subordinates
        total += employee.importance;
        for(int subordinate: employee.subordinates) {
            dfs(subordinate);
        }
    }
}