/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    int sum = 0;

    public int getImportance(List<Employee> employees, int id) {

         HashMap<Integer,List<Integer>> adjlist = new HashMap<>();
         HashMap<Integer,Integer> impmap = new HashMap<>();

        for(Employee emp : employees )
        {
            int out = emp.id;
            adjlist.put(out,emp.subordinates);
            impmap.put(out,emp.importance);
        }

        Queue<Integer> q = new LinkedList<>();

        for(Employee emp : employees )
        {
            if(emp.id == id)
            {
                q.add(id);
                break;
            }
        }

        while(!q.isEmpty())
        {
            int currhead = q.poll();
            sum += impmap.get(currhead);
            List<Integer> subordinate = adjlist.get(currhead);

            if(subordinate!=null)
            {
                for(int subs:subordinate)
                {
                    q.add(subs);
                }
            }
        }

        return sum;

    }
}
