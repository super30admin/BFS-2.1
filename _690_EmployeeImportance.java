/*BFS
Time Complexity : o(n) where n is total number of employees
 Space Complexity :  o(n) where n is total number of employees

 Approach : Create a Employeeid and employee map, Add the current id to queue and satrt BFS, explore all subordinates and add tehir imporatnce to total importance

 */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) map.put(e.id,e);

        int totalImportance = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        while(!q.isEmpty()){
            Integer currID = q.poll();
            totalImportance += map.get(currID).importance;
            for(int subordinateId : map.get(currID).subordinates){
                q.add(subordinateId);
            }
        }
        return totalImportance;
    }
}
//DFS, same approach and time and space
/******************************************************************/
class Solution {

    Map<Integer, Employee> map;
    int totalImportance;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e : employees) map.put(e.id,e);
        totalImportance = 0;
        dfs(id);
        return totalImportance;
    }

    public void dfs(int id){
        totalImportance += map.get(id).importance;
        for(int subordinateId : map.get(id).subordinates) dfs(subordinateId);
    }
}
