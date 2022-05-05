//very simple direct bfs solution where we use hashmap to store all employee objects with id as key.
// because we get id as arguement we need to get importance based on id we get
// note that subordinates are only direct subordinates

//sc and tc: o(n)

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) {
            return 0;
        }
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        
        int total = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty()) {
            
            int cur = q.poll();
            Employee emp = map.get(cur);
            total += emp.importance;
            
            for(int juniors : emp.subordinates) {
                q.add(juniors);
            }
        }
        return total;
    }
}