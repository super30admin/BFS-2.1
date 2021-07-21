//Time Complexity : O(n), n -> Total number of employees
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
	Map<Integer, Employee> empMap;

	/*
	 * Using DFS, recursively find the importance of each subordinate of the gien
	 * employee, and add the answer.
	 */
	public int getImportance(List<Employee> employees, int id) {
		if (employees == null || employees.size() == 0) {
			return 0;
		}

		empMap = new HashMap<Integer, Employee>();

		for (Employee emp : employees) {
			empMap.put(emp.id, emp);
		}

		return helper(id);
	}

	public int helper(int id) {
		Employee emp = empMap.get(id);
		int ans = emp.importance;
		for (Integer subOrd : emp.subordinates) {
			ans += helper(subOrd);
		}
		return ans;
	}

	public static void main(String[] args) {
		EmployeeImportance obj = new EmployeeImportance();
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(2, 3, new ArrayList<>()));
		employees.add(new Employee(3, 3, new ArrayList<>()));
		employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
		int empId = 1;

		System.out.println("Importance of employee with ID \'" + empId + "\' : " + obj.getImportance(employees, empId));
	}

}
