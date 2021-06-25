class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        return dfs(id);
    }
    
    public int dfs(int id){
        Employee employee = map.get(id);
        int res = employee.importance;
        for(Integer subId : employee.subordinates){
            res = res + dfs(subId);
        }
        return res;
    }
}