# Time Complexity: O(V)
# Space Complexity: O(V)
# V = Vertices

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
        queue = collections.deque()
        queue.append(id)
        dict={} # we're using map to optimize the employeeId search rather than iterating over list again and again.
        res = 0
        for employee in employees:
            dict[employee.id]=employee
    
        while queue:
            curr_id = queue.popleft()
            curr_employee = dict[curr_id]
            res += curr_employee.importance
            for subordinateId in curr_employee.subordinates:
                queue.append(subordinateId)
        return res
            
