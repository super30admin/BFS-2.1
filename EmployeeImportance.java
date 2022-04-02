// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    //method1 BFS
//     HashMap<Integer, Employee> map;
//     public int getImportance(List<Employee> employees, int id) {
//         map = new HashMap<>();
//         Queue<Integer> q = new LinkedList<>();
//         for(Employee e: employees){
//             map.put(e.id,e); 
//         }
//         q.add(id);
//         int total = 0;
//         while(!q.isEmpty()){
//             int eid = q.poll();
//             Employee e = map.get(eid);
//             total+=e.importance;
//             for(int subId : e.subordinates){
//                 q.add(subId);
//             }
            
//         }
//         return total;
    
    //method2 -DFS
    HashMap<Integer, Employee> map;
    int total;
    private void dfs(int eid){
        
        //logic
        Employee e = map.get(eid);
        total+=e.importance;
        for(int subId: e.subordinates){
            dfs(subId);
        }
        
    }
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Employee e: employees){
            map.put(e.id,e);
        }
        dfs(id);
        return total;
    }
}