/**
Problem: https://leetcode.com/problems/employee-importance/
*/
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/**
Approach 1: DFS
TC: O(n) - when all employees are indirectly subordinates of just one employee.
SC: O(n) - when one employee is the leader and all other employees are his subordinate
*/
class Solution {
    HashMap<Integer, List<Integer>> employeesAndSubordinates = null;
    HashMap<Integer, Integer> employeesAndImportance = null;
    int employeeImportance = 0;
    
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        } 
	    employeeImportance = 0;
        employeesAndSubordinates = new HashMap<>();
        employeesAndImportance = new HashMap<>();

        for (int i = 0; i < employees.size(); ++i) {
            Employee e = employees.get(i);
            employeesAndSubordinates.put(e.id, e.subordinates);
            employeesAndImportance.put(e.id, e.importance);
        }        

        dfs(id);
        return employeeImportance;
    }

	private void dfs(int employeeId) {
		employeeImportance += employeesAndImportance.get(employeeId);
        List<Integer> subordinates = employeesAndSubordinates.get(employeeId);
		for (Integer subordinate : subordinates) {
			dfs(subordinate);
        }
    }
}


/**
If each employee can have multiple leaders, we would need a seen array. This now becomes a graph problem
from a tree problem and TC : O(V+E) 
For trees also, TC is O(V+ E) => O(n + (n - 1)) => O(2n - 1) => O(n)
*/
class Solution {
    HashMap<Integer, List<Integer>> employeesAndSubordinates = null;
    HashMap<Integer, Integer> employeesAndImportance = null;
    HashSet<Integer> seen = null;
    int employeeImportance = 0;
    
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        } 
	    employeeImportance = 0;
        seen = new HashSet<>();
        employeesAndSubordinates = new HashMap<>();
        employeesAndImportance = new HashMap<>();

        for (int i = 0; i < employees.size(); ++i) {
            Employee e = employees.get(i);
            employeesAndSubordinates.put(e.id, e.subordinates);
            employeesAndImportance.put(e.id, e.importance);
        }        

        dfs(id);
        return employeeImportance;
    }

	private void dfs(int employeeId) {
		if (seen.contains(employeeId)) return;
		
		seen.add(employeeId);
		employeeImportance += employeesAndImportance.get(employeeId);
        List<Integer> subordinates = employeesAndSubordinates.get(employeeId);
		for (Integer subordinate : subordinates) {
			dfs(subordinate);
        }
    }
}

/**
Approach 2: BFS
TC: O(n) - when all employees are indirectly subordinates of just one employee.
SC: O(n) - when one employee is the leader and all other employees are his subordinate
*/
class Solution {
    HashMap<Integer, List<Integer>> employeesAndSubordinates = null;
    HashMap<Integer, Integer> employeesAndImportance = null;
    int employeeImportance = 0;
    
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        } 
        employeeImportance = 0;
        employeesAndSubordinates = new HashMap<>();
        employeesAndImportance = new HashMap<>();

        for (int i = 0; i < employees.size(); ++i) {
            Employee e = employees.get(i);
            employeesAndSubordinates.put(e.id, e.subordinates);
            employeesAndImportance.put(e.id, e.importance);
        }        

        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        
        while (!queue.isEmpty()) {
            int eID = queue.poll();
            employeeImportance += employeesAndImportance.get(eID);
            
            if (employeesAndSubordinates.containsKey(eID)) {
                List<Integer> subordinates = employeesAndSubordinates.get(eID);
                for (Integer subordinate : subordinates) {
                    queue.add(subordinate);
                }
            }
            
        }
        return employeeImportance;
    }
}
