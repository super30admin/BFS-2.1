class GetImportance {

    //Time Complexity: O(v + e)
    //Space Complexity: O(n)

    public int getImportance(List<Employee> employees, int id) {

        if (employees == null || employees.size() == 0) {
            return 0;
        }

        int result = 0;

        HashMap<Integer, Employee> map = new HashMap<>();

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        while (!q.isEmpty()) {
            int curr = q.poll();
            Employee e = map.get(curr);
            result += e.importance;

            for (int subid: e.subordinates) {
                q.add(subid);
            }

        }

        return result;
    }

}