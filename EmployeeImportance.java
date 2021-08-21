/* Time Complexity :  O(n) where n is the input list size
   Space Complexity :   O(n)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
        HashMap<Integer,Employee> hm = new HashMap<>();
        for(Employee emp: employees){
            hm.put(emp.id,emp);
        }
        Queue<Integer> q = new LinkedList<>();
        int sum=0;
        q.add(id);
        while(!q.isEmpty()){
            Employee e =  hm.get(q.poll());
            sum+=e.importance;
            for(Integer sub : e.subordinates){
                q.add(sub);
            }
        }
        return sum;
    }
}