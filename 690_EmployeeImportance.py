"""
Leetcode- https://leetcode.com/problems/employee-importance/
TC - O(N), SC- O(1) DFS
Lecture- https://youtu.be/lMaZpCmcMfA
Challenge-NA
FAQ-
Can it be solved with BFS? Yes.


You have a data structure of employee information, including the employee's unique ID, importance value, and direct
subordinates' IDs.

You are given an array of employees employees where:
employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their
direct and indirect subordinates.

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

Constraints:
1 <= employees.length <= 2000
1 <= employees[i].id <= 2000
All employees[i].id are unique.
-100 <= employees[i].importance <= 100
One employee has at most one direct leader and may have several subordinates.
The IDs in employees[i].subordinates are valid IDs.
"""

from collections import deque


# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    """
    Ideation- DFS O(N)
    Our aim is to add importance of the employee's direct and indirect employee whose id is given.
    Notice the custom employee class, the subordinates in it is list of employee id's.
    To find indirect subordinates, we need to go into each of the subordinates and their subordinates to add the result.

    DFS will be best approach for this, since we need to explore to the depth of subordinates of the desired employee.
    """

    def getImportance(self, employees, id):
        # this hashmap will point to each employee class based on the id, so we can access subordinate's info.
        self.adjList = {}
        for e in employees:
            self.adjList[e.id] = e

        # logic
        self.result = 0
        for e in employees:
            # find desired employee whose importance we need to find.
            if e.id == id:
                self.dfs(e)
                break

        return self.result

    def dfs(self, e):
        # base - no base case needed here since the dfs will automatically terminate itself once all its subordinates
        # are processed
        # logic
        for sub in e.subordinates:
            self.dfs(self.adjList[sub])
        self.result += e.importance

    """
    Ideation- BFS O(N) time O(N) space
    The idea is similar, except it's implemented using BFS. Find the desired employee add it to queue and keep adding
    its subordinates and their subordinates.
    """

    def getImportance1(self, employees, id):
        # this hashmap will point to each employee class based on the id, so we can access subordinate's info.
        self.adjList = {}
        for e in employees:
            self.adjList[e.id] = e

        # logic
        q = deque()
        for e in employees:
            if e.id == id:
                q.append(e)
                break

        self.result = 0
        while q:
            curr = q.popleft()
            self.result += curr.importance
            for subId in curr.subordinates:
                q.append(self.adjList[subId])

        return self.result