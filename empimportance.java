
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class empimportance {
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

        public int imp;

        public HashMap<Integer, Employee>map;
        public int getImportance(List<Employee> employees, int id) {

            map =  new HashMap<>();

            Queue <Employee> q = new LinkedList<>();

            for (Employee emp : employees){
                map.put(emp.id, emp);
                if (emp.id == id){
                    q.add(emp);
                }
            }

            while(!q.isEmpty()){
                Queue <Employee> qt = new LinkedList<>();

                while(!q.isEmpty()){
                    Employee et = q.poll();
                    imp += et.importance;
                    List<Integer> el = et.subordinates;

                    if(!el.isEmpty()){
                        for(int id1: el){
                            qt.add(map.get(id1));
                        }
                    }
                }
                q = qt;

            }
            return imp;
        }
    }
