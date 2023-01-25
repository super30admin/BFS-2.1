/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// Time Complexity = O(V+E) 
// Space Complexity = O(V+E)
    
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e:employees){
             map.put(e.id, e);
        }
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee e = map.get(curr);
            result += e.importance;
            for(int subid:e.subordinates){
                q.add(subid);
            }
        }
        return result;
    }
}