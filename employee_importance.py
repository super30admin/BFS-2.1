#Time Complexity :  O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

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
        self.emp_map = {e.id :e  for e in employees}
        self.importance = 0
        def dfs(employee_id):
            emp = self.emp_map[employee_id]
            self.importance+=emp.importance
            for subs in emp.subordinates:
                dfs(subs)
            
        dfs(id)
        return self.importance