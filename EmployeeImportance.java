// Time Complexity: O(n)
// Space Complexity: O(n)
// DFS
public class EmployeeImportance {
    Map<Integer, Employee> map;
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return total;
        
        map = new HashMap<>();
        
        for(Employee e: employees)
        {
            map.put(e.id, e);
        }
        
        dfs(id);
        return total;
    }
    
    private void dfs(int id)
    {
        Employee e = map.get(id);
        total += e.importance;
        for(int sid : e.subordinates)
        {
            dfs(sid);
        }
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
// BFS
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        if(employees == null || employees.size() == 0)
            return total;
        
         Map<Integer, Employee> map = new HashMap<>();
        
        for(Employee e: employees)
        {
            map.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        while(!q.isEmpty())
        {
            int eid = q.poll();
            Employee e = map.get(eid);
            total += e.importance;

            for(int sid : e.subordinates)
            {
                q.offer(sid);
            }
        }
        return total;
    }
}
