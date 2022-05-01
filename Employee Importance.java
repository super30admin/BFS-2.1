// Time Complexity : O(n) where n is the number of employees
// Space Complexity : O(n) where n is the number of employees
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    int total;
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null||employees.size()==0)
            return 0;
        map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id,e);
        dfs(id);
        return total;
    }
    private void dfs(int id){
        Employee emp = map.get(id);
        total += emp.importance;
        for(int i : emp.subordinates){
            dfs(i);
        }
    }
}