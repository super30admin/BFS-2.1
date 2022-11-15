// Time Complexity : O(n)
// Space Complexity : O(n)
// works in leetcode


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        int result = 0;
        Map<Integer,List<Integer>> empSub = new HashMap<>();
        Map<Integer, Integer> empImportance = new HashMap<>();

        for(Employee emp: employees){
            empSub.put(emp.id, emp.subordinates);
            empImportance.put(emp.id, emp.importance);
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);

        while(!queue.isEmpty()){

            int popId = queue.remove();
            result+= empImportance.get(popId);

            for (Integer subId : empSub.get(popId)){
                queue.add(subId);
            }

        }

        return result;

    }
}