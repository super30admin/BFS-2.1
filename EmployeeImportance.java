import  java.util.*;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportanceBFS(List<Employee> employees, int id) {
    /*

    Approach 1 : using BFS
    TC: O(n) or O(v+E)
    SC: O(n) or O(V)

    */
        if(employees==null || employees.size()==0) return 0;
        HashMap<Integer,Employee> map=new HashMap<>();
        int totalImportance=0;

        for(Employee e:employees){
            map.put(e.id,e);
        }

        Queue<Integer> q=new LinkedList<>();
        q.add(id);

        while(!q.isEmpty()){
            int currId=q.poll();
            Employee emp=map.get(currId);
            totalImportance+=emp.importance;
            for(int sub:emp.subordinates){
                q.add(sub);
            }
        }
        return totalImportance;
    }


    HashMap<Integer,Employee> map;
    int totalImportance;
    public int getImportanceDFS(List<Employee> employees, int id) {
    /*

    Approach 2 : using DFS
    TC: O(n) or O(v+E)
    SC: O(n) or O(V)

    */
        if(employees==null || employees.size()==0) return 0;
        map=new HashMap<>();

        for(Employee e:employees){
            map.put(e.id,e);
        }

        dfs(id);

        return totalImportance;
    }

    private void dfs(int id ){
        Employee e=map.get(id);
        totalImportance+=e.importance;
        for(int sub:e.subordinates){
            dfs(sub);
        }
    }
}
