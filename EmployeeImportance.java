// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

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
        Queue<Employee> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees){
            map.put(employee.id, employee);
            if(employee.id == id){
                q.add(employee);
            }
        }
        int sum = 0;
        while(!q.isEmpty()){
            Employee m = q.poll();
            sum+=m.importance;
            for(int sub : m.subordinates){
                q.add(map.get(sub));
            }
        }
        
        return sum;
    }
}