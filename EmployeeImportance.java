public class EmployeeImportance {
    // TC is O(n) where n is number of emp
    // SC is o(n)
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Employee> q = new LinkedList<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        int importance = 0;
        q.add(map.get(id));
        while (!q.isEmpty()) {
            Employee curr = q.poll();
            importance += curr.importance;
            List<Integer> sub = map.get(curr.id).subordinates;
            for (int s : sub) {
                q.add(map.get(s));
            }
        }
        return importance;
    }
}
