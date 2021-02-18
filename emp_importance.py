// Time: O(n) where n is no. of employees
// Space: O(n)
// Passed on Leetcode: Yes
// Approach: Use a queue(BFS) to iterate through given employees subordinates. acess the subordinates effectively by storing the 
// index of each employee id in employees array for faster access. Keep incrementing the total importance value as we pop elements from queue.

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
        
        queue=[]
        res=0
        d={}
        
        for i in range(len(employees)):
            if(employees[i].id not in d):
                d[employees[i].id] = i
        
        queue.append(id)
        
        while(queue):
            
            popped=queue.pop(0)
            res+= employees[d[popped]].importance
            subor= employees[d[popped]].subordinates
            
            for i in range(len(subor)):
                queue.append(subor[i])
        return(res)
            
            
        