/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// BFS
// TC:O(V) -> V is the no.of employees
// SC:O(V+V) -> O(V) 
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if ( employees == null || employees.size() == 0)
            return 0;
        HashMap<Integer, Employee> map = new HashMap();
        for ( Employee employee : employees)
        {
            map.put(employee.id, employee);
        }
        Queue<Integer> q = new LinkedList();
        q.offer(id);
        int importanceCount = 0;
        while (!q.isEmpty())
        {
            Integer e_id = q.poll();
            Employee e = map.get(e_id);
            importanceCount = importanceCount + e.importance;
            for (Integer subordinate: e.subordinates)
            {
                q.add(subordinate);
            }
        }
        return importanceCount;
    }
}


// DFS
// TC:O(V) -> V is the no.of employees
// SC:O(V+V) -> O(V) 
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     int importanceCount = 0;
//     HashMap<Integer, Employee> map;
//     public int getImportance(List<Employee> employees, int id) {
//         if ( employees == null || employees.size() == 0)
//             return 0;
//         map = new HashMap();
//         for ( Employee employee : employees)
//         {
//             map.put(employee.id, employee);
//         }
//         helper(id);
//         return importanceCount;
//     }
//     private void helper(int id)
//     {
//         //base
//         //No base case is required for this scenario
//         //logic
//         Employee e = map.get(id);
//         importanceCount = importanceCount + e.importance;
//         for (Integer subordinate: e.subordinates)
//         {
//            helper(subordinate);
//         }
//     }
// }
       
          
