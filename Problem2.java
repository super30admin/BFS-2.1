/*
 
Employee Impotance(https://leetcode.com/problems/employee-importance/)

TC : O(n)
SC : O(n)
Leet Code :

 */

 class Solution {
    public int getImportance(List<Employee> employees, int id) {

        if(employees == null || employees.size() == 0){
            return 0;
        }

        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        int importance = 0;

        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        q.add(id);

        while(!q.isEmpty()){
            int currId = q.poll();
            Employee curr = map.get(currId);
            importance = importance + curr.importance;

            if(curr.subordinates.size() == 0){
                continue;
            }
            for(int emp : curr.subordinates){
                q.add(emp);
            }
        }

        return importance;

    }
}