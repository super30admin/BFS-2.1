// dfs solution

// Time complexity: O(N)
// Space complexity: O(N)
// Run on Leetcode: Yes
// Issues faces: None

class Solution {
    Map<Integer, Employee> map;
    int count;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id, e);
        int count = map.get(id).importance;
        count += helper(map.get(id).subordinates);
        return count;
    }
    
    private int helper(List<Integer> sub){
        for(Integer child: sub){
            count += map.get(child).importance;
            helper(map.get(child).subordinates);
        }
        return count;
    }
}
