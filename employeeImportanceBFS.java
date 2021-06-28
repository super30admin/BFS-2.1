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
        
        Queue<Employee> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        int result = 0;
        q.add(map.get(id));
        
        while(!q.isEmpty()){
            Employee curr = q.poll();
            result += curr.importance;
            for(int subordinate: curr.subordinates){
                q.add(map.get(subordinate));
            }
        }
        
        return result;
    }
}