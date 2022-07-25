//Time Complexity: O(n), where n is the total no. of employees, max possible.
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2_BFS {

    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null || employees.size() == 0)
            return -1;
        
        HashMap<Integer, Employee> map = new HashMap<>();
        int total = 0;
        
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty())
        {
            int curr = q.poll();    
            Employee e = map.get(curr);
            total += e.importance;
            for(int i : e.subordinates){
                q.add(i);
            }
        }
        return total;
    }
}
