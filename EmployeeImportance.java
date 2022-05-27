// Time Complexity :O(n) - number or employees in list
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class EmployeeImportance {
    int importance = 0;
    Map<Integer, Integer> imp;
    Map<Integer, List<Integer>> sub;

    public int getImportance(List<Employee> employees, int id) {
        imp = new HashMap<>();
        sub = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        for (Employee emp : employees) {
            if (!imp.containsKey(emp.id)) {
                imp.put(emp.id, emp.importance);
            }
            if (!sub.containsKey(emp.id)) {
                sub.put(emp.id, emp.subordinates);
            }
        }

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int empId = q.poll();
                importance += imp.getOrDefault(empId, 0);
                List<Integer> subList = sub.getOrDefault(empId, new ArrayList<Integer>());

                for (int subId : subList) {
                    q.offer(subId);
                }
            }
        }

        return importance;
    }
}
