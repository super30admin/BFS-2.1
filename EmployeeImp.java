//Time : O(V+E)
// Space : O(N)

class Solution {
    HashMap<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while (!q.isEmpty()) {
            int eid = q.poll();
            Employee a = map.get(eid);
            result = result + a.importance;
            for (int r : a.subordinates) {
                q.add(r);
            }
        }
        return result;
    }
}