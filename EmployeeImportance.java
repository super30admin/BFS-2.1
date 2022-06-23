//Time Complexity=O(n)
//Time Complexity=O(n)
public class EmployeeImportance {

    HashMap<Integer,Employee>  map;
    int result=0;
    public int getImportance(List<Employee> employees, int id) {

        map=new HashMap();
        for(Employee e:employees){
            map.put(e.id,e);
        }

         Queue<Integer>q=new LinkedList<>();
         q.add(id);
         while(!q.isEmpty()){
             int eid=q.poll();
             Employee e=map.get(eid);
             result+=e.importance;
             for(int subId:e.subordinates){
                 q.add(subId);
             }
         }
//        dfs(id);
        return result;
    }
//    private void dfs(int eid){
//        Employee e=map.get(eid);
//        result+=e.importance;
//        for(int i:e.subordinates){
//            dfs(i);
//        }
//    }
}
