// Time Complexity : O(n)
// Space Complexity : O(n) for the Queue and HashMap
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) {
            return 0;
        }

        HashMap<Integer, Employee> m = new HashMap<>();
        for(Employee e : employees) {
            m.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        q.add(id);

        while(!q.isEmpty()) {
            // no need to track size since we don't depend on level
            // order traversal
            int curr = q.poll();
            Employee e = m.get(curr);
            total += e.importance;
            List<Integer> subs = e.subordinates;
            if(subs == null) {
                continue;
            }
            for(int s : subs) {
                q.add(s);
            }
        }

        return total;
    }
}