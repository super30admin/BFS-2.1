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
        #O(N)
        #O(N)
        
        if not employees:
            return 0
        empmap={}
        #map whwre id is key and complete employee structure is value object
        for emp in employees:
            empmap[emp.id]=emp
        #global sum   
        self.s=0
        
        def dfs(id):
            #get importance of employee and add o sum
            self.s+=empmap[id].importance
            #for each subordinate>>compute similar sum
            for e in empmap[id].subordinates:
                dfs(e)
        
        dfs(id)
        return self.s