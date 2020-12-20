// TC: O(N)
// SC: O(V+E)
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
    int total;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        
        map = new HashMap<>();
        
        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
      
       dfs(id);
    
        return total;
        
    }
    
    private void dfs(int id){
        Employee obj = map.get(id);
        total += obj.importance;
        for(int sub: obj.subordinates){
            dfs(sub);
        }
    }
    
    
}

// TC: O(N)
// SC: O(V+E)

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
        int total = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee obj = map.get(curr);
            total += obj.importance;
            for(int sub: obj.subordinates){
                q.add(sub);
            }
            
        }
        
        return total;
        
        
    }
}