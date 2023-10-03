// Time Complexity : O(n) traverses through the whole list if all employees are subordinated of ID
// Space Complexity : O(n) because all elements will be added to map.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }

        int m = employees.size();
        int value = 0;

        Queue<Employee> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();

        for(Employee e : employees){
            map.put(e.id, e);
        }

        for(Employee e : employees){
            if(e.id == id){
                q.add(e);
                value += e.importance;
            }
        }

        if(q.isEmpty()){
            return 0;
        }

        while(!q.isEmpty()){
            Employee e = q.poll();
            List<Integer> subIdList = e.subordinates;
            if(subIdList.size() < employees.size()){
                for(int subId : subIdList){
                    Employee sub = map.get(subId);
                    q.add(sub);
                    value += sub.importance;
                }
            }
        }

        return value;
    }
}
