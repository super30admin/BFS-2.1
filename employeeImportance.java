// Time Complexity :O(n) - n=employees
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        return dfs(id);
    }
    
    private int dfs(int id){
        Employee e = map.get(id);
        int ans = e.importance;
        for(Integer sub: e.subordinates){
            ans+= dfs(sub);
        }
        return ans;
    }
}