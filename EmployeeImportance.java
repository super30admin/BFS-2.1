/**Leetcode Question 690 - Employee Importance */
/**Algo - DFS
 * Add the given DS in a hashmap with the emp.id as key and the value as the whole employee obj
 * Call the dfs function recursively with the emp id of the sub in it
 * add the importance to the total
 */
/**TC = O()
 * SC = O()
 */
public class EmployeeImportance {
    class Solution {
        int total;
        HashMap<Integer, Employee> map;
        public int getImportance(List<Employee> employees, int id) {
            total =0;
            map = new HashMap<>();
            for(Employee e: employees){
                map.put(e.id, e);
            }
            dfs(id);
            return total;
        }
        private void dfs(int id){
            Employee curr = map.get(id);
            total += curr.importance;
            for(int sub: curr.subordinates){
                dfs(sub);
            }
        }
    }
}
/**Algo -  BFS */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int total =0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            Employee curr = map.get(q.poll());
            total += curr.importance;
            for(int sub:  curr.subordinates){
                q.add(sub);
            }
        }
        return total;
    }
}

