//Time Complexity:O(n)
//Space Complexity:O(n)

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
        HashMap<Integer,Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int importance = 0;
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        while(!q.isEmpty()){
            int currId = q.poll();
            Employee currEmployee = map.get(currId);
            importance += currEmployee.importance;
            for(int subId:currEmployee.subordinates){
                q.add(subId);
            }
        }
        return importance;
    }
}