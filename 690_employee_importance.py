'''

## Problem 690: Employee importance

## Author: Neha Doiphode
## Date:   07-26-2022

## Description
    You have a data structure of employee information, including the employee's unique ID,
    importance value, and direct subordinates' IDs.

    You are given an array of employees employees where:
        employees[i].id is the ID of the ith employee.
        employees[i].importance is the importance value of the ith employee.
        employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.

    Given an integer id that represents an employee's ID,
    return the total importance value of this employee and all their direct and indirect subordinates.

## Examples:
    Example 1:
        Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
        Output: 11
        Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
                     They both have an importance value of 3.
                     Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.

    Example 2:
        Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
        Output: -3
        Explanation: Employee 5 has an importance value of -3 and has no direct subordinates.
                     Thus, the total importance value of employee 5 is -3.



## Constraints:
    1 <= employees.length <= 2000
    1 <= employees[i].id <= 2000
    All employees[i].id are unique.
    -100 <= employees[i].importance <= 100
    One employee has at most one direct leader and may have several subordinates.
    The IDs in employees[i].subordinates are valid IDs.


## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Notes:
    If its a graph, TC - O(V + E), Tree is a special case of graph.
        so if we consider tree as a graph, trees always have less number of edges than vertices.
        So, asymptotically if we consider V + E ~= 2V ~= V where V is number of vertices which is same as O(n).
'''

from typing import List, Optional
from queue import Queue

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

def get_input():
    print("Enter total number of employees: ", end = "")
    numEmployees = int(input())
    employees = []
    employee_objects = []
    print("Enter information of each employee: ")
    for _ in range(numEmployees):
        print("Enter employee id: ", end = "")
        emp_id = int(input())
        print("Enter employee importance(Integer): ", end = "")
        emp_importance = int(input())
        print("Enter employee sub-ordinates(list of integer employee ids with spaces, enter 'null' if no sub-ordinates): ", end = "")
        emp_subordinates = input()
        if emp_subordinates != 'null':
            emp_subordinates = [int(val) for val in emp_subordinates.split()]
        else:
            emp_subordinates = []

        employee = Employee(emp_id, emp_importance, emp_subordinates)
        employee_objects.append(employee)
        employees.append([emp_id, emp_importance, emp_subordinates])

    print("Enter the integer employee id for which you want to find the total importance for: ")
    employee_in_interest = int(input())
    return employees, employee_objects, employee_in_interest

class Solution:
    importance = 0
    details = {}

    def getImportance_BFS(self, employees: List['Employee'], id: int) -> int:
        '''
        Time complexity: (O(n)), where n is the total number of employees.
        Space complexity:(O(n)), where n is the total number of employees.
        '''
        if len(employees) == 0:
            return None

        details = {}
        q = Queue()
        importance = 0

        for employee in employees:
            if employee.id not in details:
                details[employee.id] = employee

        for employee in employees:
            if employee.id == id:
                q.put(employee)
                break

        while not q.empty():
            size = q.qsize()
            for i in range(size):
                employee = q.get()
                importance += employee.importance
                if len(employee.subordinates) != 0:
                    for subord in employee.subordinates:
                        q.put(details[subord])
        return importance

    def dfs(self, employee: 'Employee') -> None:

        self.importance += employee.importance

        # base case
        if len(employee.subordinates) == 0:
            return

        # logic
        for subord in employee.subordinates:
            self.dfs(self.details[subord])

    def getImportance_DFS(self, employees: List['Employee'], id: int) -> int:
        '''
        Time complexity: (O(n)), where n is the total number of employees.
        Space complexity:(O(n)), where n is the total number of employees.
        '''
        if len(employees) == 0:
            return None

        self.importance = 0
        self.details = {}
        start = None

        for employee in employees:
            if employee.id not in self.details:
                self.details[employee.id] = employee
            if employee.id == id:
                start = employee

        self.dfs(start)
        return self.importance


# Driver code
solution = Solution()
employees, employee_objects, employee_in_interest = get_input()
print(f"Input: List of given employees[[<id>, <importance>, <sub-ordinates>]]: {employees}", end = "")
print()
print(f"Input: Employee id for which we want to find total importance for: {employee_in_interest}", end = "")
print()
print(f"Approach 1: Using BFS: Employee importance: {solution.getImportance_BFS(employee_objects, employee_in_interest)}")
print(f"Approach 2: Using DFS: Employee importance: {solution.getImportance_DFS(employee_objects, employee_in_interest)}")
