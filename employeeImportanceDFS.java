// Time Complexity:  O(n) where n is the number of subordinates
// Space Complexity: O(n) where n is the number of subordinates

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
        if(employees == null || employees.size() == 0) return 0;
        
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        
        return helper(map, id);
    }
    
    private int helper(HashMap<Integer, Employee> map, int id){
        int result = map.get(id).importance;
        for(int subordinate: map.get(id).subordinates){
            result += helper(map,subordinate);
        }
        
        return result;
    }
}