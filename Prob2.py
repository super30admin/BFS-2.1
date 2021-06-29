#Time complexity for put and get: O(n)
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

"""
# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        #BFS
        result = 0
        emp_map = {}
        for e in employees:
            emp_map[e.id] = e
        q = deque()
        q.append(id)
        
        while q:
            nodeid = q.pop()
            node = emp_map[nodeid]
            result+=node.importance
            for e in node.subordinates:
                q.append(e)
        return result
        #DFS
        # self.result = 0
        # self.emp_map = {}
        # for e in employees:
        #     self.emp_map[e.id] = e
        # def dfs(id):
        #     #base
        #     #logic
        #     emp = self.emp_map[id]
        #     self.result += emp.importance
        #     for e in emp.subordinates:
        #         dfs(e)
        # dfs(id)
        # return self.result