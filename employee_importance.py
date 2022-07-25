# Time complexity: O(n)
# Space complexity: O(n)
# To find indirect subordinates, we need to go into each of the subordinates 
# and their subordinates to add the result.
# DFS will be best approach for this, 
# since we need to explore to the depth of subordinates of the desired employee.



""""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # this hashmap will point to each employee class based on the id, so we can access subordinate's info.
        self.adjList = {}
        for e in employees:
            self.adjList[e.id] = e

        # logic
        self.totalimportance = 0
        for e in employees:
            # find desired employee whose importance we need to find.
            if e.id == id:
                self.dfs(e)
                break

        return self.totalimportance
    def dfs(self, e):
        # base - no base case needed here since the dfs will automatically terminate itself once all its subordinates are processed
        # logic
        for sub in e.subordinates:
            self.dfs(self.adjList[sub])
        self.totalimportance += e.importance
        