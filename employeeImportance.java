/*
Time Complexity : O(n)
Space Complexity : O(n)
 Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no

*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null){
            return 0;
        }
        HashMap<Integer,Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int totalimp =0;
        for(Employee e : employees){
            map.put(e.id,e);
        }
        q.add(id);
        while(!q.isEmpty()){
            int id1 = q.poll();
            Employee a = map.get(id1);
           List<Integer>  subor = a.subordinates;
            totalimp = totalimp+ a.importance;
            for(Integer i : subor){
                q.add(i);
            } 
        }
        return totalimp;   
    }
}