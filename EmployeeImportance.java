// Time Complexity: O(n)
//  Space Complexity: O(n)
//  BFS Approach
class Solution {
    public int getImportance(List<Employee> employees, int id) {

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Employee>  map = new HashMap<>();

        for(Employee employee: employees)
            map.put(employee.id, employee);

        q.add(id);
        int result = 0;
        while(!q.isEmpty()){
            int currId = q.poll();
            Employee currEmp = map.get(currId);
            result += currEmp.importance;

            for(int subId: currEmp.subordinates)
                q.add(subId);
        }

        return result;       
    }
}


// Time Complexity: O(n)
//  Space Complexity: O(n)
// DFS Approach
class Solution {
    Map<Integer, Employee>  map;

    public int getImportance(List<Employee> employees, int id) {

        map = new HashMap<>();

        for(Employee employee: employees)
            map.put(employee.id, employee);

        return  dfs(id);
        
    }

    private int dfs(int id){
        Employee emp =map.get(id);
        int result = emp.importance;
        
        for(int subId: emp.subordinates)
            result += dfs(subId);

        return result;
    }
}