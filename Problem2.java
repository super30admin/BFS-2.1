/*
Employee Importance
approach: do a bfs and add importance of employee with subordinates
time: O(v+e)
space: O(v)
 */
public class Problem2 {
    /*
    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee> q = new LinkedList<>();

        Map<Integer, Employee> map = new HashMap<>();
        int imp = 0;
        for(Employee e: employees) {
            if(id==e.id) q.add(e);
            map.put(e.id, e);
        }

        while(!q.isEmpty()) {
            Employee temp = q.poll();
            imp += temp.importance;
            List<Integer> subs = temp.subordinates ;
            for(Integer e:subs) {
                q.add(map.get(e));
            }
        }

        return imp;

    }

     */
}
