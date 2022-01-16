/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    int importance;
    public int getImportance(List<Employee> employees, int id) {
        
        importance = 0;
        
        // adjacency list - hashmap
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for (int i = 0; i < employees.size(); i++){
            // ID as key and Employee as Value   
            map.put(employees.get(i).id , employees.get(i));
        }
        
        Queue <Integer> q = new LinkedList<>();
        
        // given employee id
        q.add(id);
        
        while (! q.isEmpty()){
            // no need of size as the order of traversal does not matter.
            // no use of visited array/any step to identify as visited : No cycle is possible. only one subordinate for a given employee ID
            
            
            // Current employee
            int curr =  q.poll();
            
            // Importance must be updated as per curr
            importance += map.get(curr).importance;
            
            // Do BFS for the neighbours of curr 
            for (int i = 0; i < map.get(curr).subordinates.size(); i++){
                // add subordinates ID into the queue
                q.add(map.get(curr).subordinates.get(i));
            }
        }
        
        return importance;
    }
}