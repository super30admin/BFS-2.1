/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]],


        ID = 1           
        Importance = 5
        / \ 
    
    
   graph that creates using the -> Map<Employee, List<Employee>> -> K to list of values. 
    
    Id -> Employee
        
TC - O(N) + O(N) + O(E) 
SC - O(N) + O(N).

*/

class Solution {
    
    Map<Integer, List<Integer>> graph;
    
    Map<Integer, Employee> idToEmployee;
    
    public int getImportance(List<Employee> employees, int id) {
        
        graph = new HashMap<>();
        idToEmployee = new HashMap<>();
        
        for (Employee e : employees)
        {
            idToEmployee.put(e.id, e);
            final List<Integer> neighbours = graph.computeIfAbsent(e.id, k -> new ArrayList<>());
            neighbours.addAll(e.subordinates);
        }
        
        
        int totalImportance = 0;
        
        Queue<Employee> queue = new LinkedList<>();
        queue.add(idToEmployee.get(id));
        
        while (!queue.isEmpty())
        {
            Employee remove = queue.remove();
            totalImportance += remove.importance;
            
            for (int nId : remove.subordinates)
            {
                Employee neighbour = idToEmployee.get(nId);
                queue.add(neighbour);
            }
        }
        
        return totalImportance;
    }
}
