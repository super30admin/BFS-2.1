//Time complexity:O(n)
//Space complexity:O(n)
//Ran on leetcode: Yes

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
        for(Employee e : employees){
            map.put(e.id,e);
        }
        int importance=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            Employee n = map.get(q.poll());
            importance+=n.importance;
            for(Integer e: n.subordinates){
                q.add(e);
            }
        }
        
        return importance;
        
    }
}