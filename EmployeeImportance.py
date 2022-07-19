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
        #Input is list of employee objects 
        '''We need to maintain an adjacency list/ hashmap of employeeid : employeeObject'''
        #Time complexity: O(n) --> total number of employees
        #Space complexity: O(n)--> to maintain the adjaceny list
        
        hashmap=dict()
        for e in employees:
            hashmap[e.id]=e
            
        queue=deque()
        queue.append(id)
        result=0
        while len(queue)!=0:
            currid=queue.popleft()
            e=hashmap[currid]
            result+=e.importance
            for sid in e.subordinates:
                queue.append(sid)
        return result
