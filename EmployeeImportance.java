/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//Time: O(n)
//Space: O(n)
//BFS
// class Solution {
//     public int getImportance(List<Employee> employees, int id) {
//         if(employees == null || employees.size() == 0)
//             return 0;
        
//         HashMap<Integer, Employee> map = new HashMap<>();
//         for(Employee e: employees)
//             map.put(e.id, e);
        
//         Queue<Integer> q = new LinkedList<>();
//         int total = 0;
//         q.add(id);
        
//         while(!q.isEmpty()){
//             int eid = q.poll();
//             Employee emp = map.get(eid);
//             total = total + emp.importance;
//             List<Integer> edges = emp.subordinates;
//             if(edges == null)
//                 continue;
//             for(int edge: edges)
//                 q.add(edge);
//         }
//         return total;
//     }
// }
//Time: O(n)
//Space: O(n)
//DFS
class Solution {
    HashMap<Integer, Employee> map;
    int total;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        
        map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id, e);
        
        dfs(id);
        
        return total;
        
    }
    
    private void dfs(int id){
        Employee emp = map.get(id);
        total = total + emp.importance;
        List<Integer> edges = emp.subordinates;
        if(edges != null){
            for(int edge: edges)
                dfs(edge);
        }
    }
}
