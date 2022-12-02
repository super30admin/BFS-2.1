// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//690. Employee Importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    int empImportance;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        map = new HashMap<>();
        empImportance = 0;
        
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        dfs(id);
        
        return empImportance;
    }
    private void dfs(int id){
        Employee emp = map.get(id);
        empImportance += emp.importance;
        List<Integer> subordinate = emp.subordinates;
        if(subordinate != null){
            for(int sub : subordinate){
                dfs(sub);
            }
        }
    }
}

// class Solution {
    
//     int empImportance;
//     public int getImportance(List<Employee> employees, int id) {
//         if(employees == null) return 0;
//         HashMap<Integer, Employee> map = new HashMap<>();
//         empImportance = 0;
//         Queue<Integer> q = new LinkedList<>();
        
//         for(Employee e : employees){
//             map.put(e.id, e);
//         }
        
//         q.add(id);
//         while (!q.isEmpty()){
//             int eID = q.poll();
//             empImportance += map.get(eID).importance;
//             List<Integer> subordinate = map.get(eID).subordinates;
//             if(subordinate == null) continue;
//             for(int sub : subordinate){
//                 q.add(sub);
//             }
//         }
//         return empImportance;
//     }
// }