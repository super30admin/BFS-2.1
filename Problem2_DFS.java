//Time Complexity: O(n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2_DFS {

    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null || employees.size() == 0)
            return -1;
        
        map = new HashMap<>();
        
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        return dfs(id);
    }
    
    private int dfs(int id){
        
        Employee e = map.get(id);
        
        if(e.subordinates == null)
            return e.importance;
        
        int total = 0;
        for(int i : e.subordinates){
             total += dfs(i);
        }
        
        return total + e.importance;
    }
}
