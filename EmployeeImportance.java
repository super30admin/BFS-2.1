/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// BFS tc: o(n) sc: o(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        for(Employee e : employees){
            if(e.id == id){
                Queue<Employee> q = new LinkedList();
                q.add(e);
                while(!q.isEmpty()){
                    Employee curr = q.poll();
                    result += curr.importance;
                    if(curr.subordinates != null ){
                        for(int i: curr.subordinates){
                            q.add(map.get(i));
                        }
                    }
                    
                }
                return result;
            }
        }
        return result;
    }
}
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//dfs tc: o(n) sc: o(n)
class Solution1 {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        return helper(map, id);
    }
    private int helper(HashMap<Integer, Employee> map, int id){
        Employee e = map.get(id);
        int result = 0;
        result += e.importance;
        for(int i : e.subordinates) {
            result += helper(map, i);
        }
        return result;
    }
}
