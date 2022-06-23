/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//Time O(n)
//Space O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int totalImportance = 0;
        // We need to build a hashmap to easily access the employee record by id;
        Map<Integer, Employee> empMap  =  new HashMap<>(); 
        for(Employee e : employees)
            empMap.put(e.id, e);
        
        Queue<Employee> q = new LinkedList<>();
        q.add(empMap.get(id));
        while(!q.isEmpty())
        {
            Employee curr= q.poll();
            totalImportance+= curr.importance;
            for( int i : curr.subordinates)
            {
                q.add(empMap.get(i));
            }
            
        }
        return totalImportance;
    }
}