// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null || employees.size()==0) return 0;
        int total=0;
        HashMap<Integer,Employee> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        for(Employee emp:employees){
            map.put(emp.id, emp);
        }
        
        q.add(id);
        while(!q.isEmpty()){
            int curr= q.poll();
            Employee emp= map.get(curr);
            total+=emp.importance;
            List<Integer> list= emp.subordinates;
            if(list!=null){
                int n= list.size();
                for(Integer p:list){
                    q.add(p);
                }
            }
        }
         return total;   
    }
}