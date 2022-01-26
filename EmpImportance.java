// Time Complexity : O(V+E) O(n)
// Space Complexity : O(V) O(n)

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
        Map<Integer,Employee> emap=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        int importance=0;
        for(int i=0;i<employees.size();i++){
            emap.put(employees.get(i).id,employees.get(i));
        }
        q.add(id);
        while(!q.isEmpty()){
            Employee curr=emap.get(q.poll());
            importance+=curr.importance;
            for(int emp:curr.subordinates){
                q.add(emp);
            }
        }
        return importance;
    }
}
