// Time complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        
        int result=0;
        q.add(id);
        while(!q.isEmpty()){
            
                int eid = q.poll();
            Employee y = map.get(eid);
            result+=y.importance;
            for(Integer s : y.subordinates){
                q.add(s);
            }
        }
        return result;
    }
}
