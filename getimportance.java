
// BFS
// Time - O(N)
// Space - O(N)

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) {
            return 0;
        }
        int importance = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        Queue<Integer> q = new LinkedList<>();
        
        q.add(id);
        
        while(!q.isEmpty()) {
            int first = q.poll();
            Employee emp = map.get(first);
            importance += emp.importance;
            for(int sub : emp.subordinates) {
                q.add(sub);
            }
            
        }
        return importance;
    }
}


// Time - O(N)
// Space - O(N)

// DFS
class Solution {
    int importance;
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null || employees.size() == 0) {
            return 0;
        }
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        dfs(map, id);
        
        return importance;
    }
    
    private void dfs(HashMap<Integer, Employee> map, int id) {
        Employee emp = map.get(id);
        importance += emp.importance;
        for(int subordinate :  emp.subordinates) {
            dfs(map, subordinate);            
        }
    }
}
