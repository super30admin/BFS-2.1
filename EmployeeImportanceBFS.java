import java.util.*;


public class EmployeeImportanceBFS {

        //BFS - Queue, HashMap - auxiliary DS

        public int getImportance(List<Employee> employees, int id) {

            //map employee id(attribute) to employee object
            HashMap<Integer, Employee> map = new HashMap<>();

            if(employees == null) return 0;

            // for each employee object running over a list in for loop
            for(Employee e: employees) {

                //make map
                map.put(e.id, e);
            }

            //
            Queue<Integer> q = new LinkedList<>();

            int totalImp = 0;

            //pass given id to queue
            q.add(id);

            //BFS until queue gets empty
            while(!q.isEmpty()) {

                // pop out id
                int eid = q.poll();

                // get importance of employee with popped id
                Employee e = map.get(eid);

                //increment importance
                totalImp += e.importance;

                // for each subordinate of popped employee running over a list in for loop
                for(int subId: e.subordinates) {

                    // add each subordinate id to queue to add its importance to result
                    q.add(subId);
                }
            }
            // output after BFS
            return totalImp;
        }


}

/*
TIME COMPLEXITY = O(N)

N - number of employees
if top most employee id is given, we run over each employee - worst case

SPACE COMPLEXITY = O(N)

maximum queue size = N-1 when a single employee has all subordinates
*/