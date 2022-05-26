//Time: O(N) Space:O(N)

//BFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> adjLi = new HashMap<>();
        // we create an adjacency list of employees, to search on O(1) time later
        for(Employee emp: employees) {
            adjLi.put(emp.id, emp);
        }
        Queue<Integer> q = new LinkedList<>();
        // adding the first employee id into queue for processing
        q.add(id);
        int importance = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i =0;i<size;i++) {
                int curr = q.poll();
                // pulling out the first record in the queue
                // making use of adjacency list to get the importance of each employee and his subs
                Employee e = adjLi.get(curr);
                // checking if it has suborindates and adding them to the queue for further processing
                for(Integer sub: e.subordinates) {
                    q.add(sub);
                }
                // adding the importance to the global sum
                importance += e.importance;
            }
        }
        return importance;
    }
}