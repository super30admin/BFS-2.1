// Time Complexity : o(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        return helper(id);
    }
    public int helper(int id){
        int count =0;
        Employee emp = map.get(id);
        count += emp.importance;
        for(int i : emp.subordinates){
            count += helper(i);
        }
        return count;
    }
}
