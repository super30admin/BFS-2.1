import java.util.*;
//DSF solution
// Time Complexity: O(n) //V+E edges is equal to nodes
// Space Complexity: O(n)
/*
 * store the employees in hashmap and get run a dfs function with id.
 * get the subordinate children and run the dffs function on them.
 */
public class EmployeeImportance {
    HashMap<Integer, Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        result = 0;
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    public void dfs(int id){
        Employee e = map.get(id);
        result += e.importance;
        for(int sub: e.subordinates){
            dfs(sub);
        }
    }
}

//BSF solution
// Time Complexity: O(n) 
// Space Complexity: O(n)
/*
 * maintain a queue with employees in it and get the importance and add
 * children to the queue.
*/

class Solution {
    HashMap<Integer, Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        result = 0;
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Employee e = q.poll();
                result += e.importance;
                for(int sub: e.subordinates){
                    q.add(map.get(sub));
                }
            }
        }
        return result;
    }
}