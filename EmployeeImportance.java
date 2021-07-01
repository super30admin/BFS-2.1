/*Sc, SC O(N) , O(N) 
 * */


class Solution {
    public int getImportance(List<Employee> employees, int id) {

        // bfs
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e:employees){
            map.put(e.id, e);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int imp = 0 ;
	// BFS, add its subordinate to the queue
        while(!queue.isEmpty()){
            Integer empId= queue.poll();
            imp += map.get(empId).importance;
            for (Integer eid:map.get(empId).subordinates){
                queue.add(eid);
            }

        }
        return imp;
    }
}
