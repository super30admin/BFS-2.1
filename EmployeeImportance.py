"""
//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
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
    #T.C= O(n)
    #S.C = O(n)
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        if len(employees) == 0:
            return 0
        mp = {}
        for emp in employees:
            mp[emp.id] = emp
            
        from collections import deque
        q= deque()
        q.append(id)
        total = 0
        while q:
            curr = q.popleft()
            e = mp.get(curr)
            total+=e.importance
            subs = e.subordinates
            if subs!=None:
                for s in subs:
                    q.append(s)
        return total
            
        
        