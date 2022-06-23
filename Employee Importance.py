# TC : O(N)
# SC : O(N)
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
        adjacencyList = {}
        for employee in employees:
            adjacencyList[employee.id] = (employee.importance, employee.subordinates)
        queue = [id]
        totalImportance = 0
        while queue:
            id = queue.pop(0)
            totalImportance += adjacencyList[id][0]
            for subordinate in adjacencyList[id][1]: queue.append(subordinate)
        
        return totalImportance