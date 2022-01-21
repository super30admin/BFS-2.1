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
        q = deque()
        map = {}
        result = 0
        for e in employees:
            map[e.id] = e
        q.append(id)
        while q:
            size = len(q)
            for i in range(size):
                eid = q.popleft()
                e = map[eid]
                result += e.importance
                for subid in e.subordinates:
                    q.append(subid)
        return result