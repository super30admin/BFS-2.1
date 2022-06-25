#TC:O(n) for worst case
#SC:O(n) 
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
        hashMap={}
        result=0
        for i in range(len(employees)):
            hashMap[employees[i].id]=employees[i]
        q=[]
        q.append(id)
        
        while q:
            eid=q.pop(0)
            e=hashMap[eid]
            result+=e.importance
            for i in range(len(e.subordinates)):
                q.append(e.subordinates[i])
            print(q)
            print(result)
        return result


#code for employee importance using DFS
'''
#TC:O(n) for worst case
#SC:O(n)
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
        hashMap={}
        self.result=0
        for i in range(len(employees)):
            hashMap[employees[i].id]=employees[i]
        l=0
        def dfs(root):
            
            curr=hashMap[root]
            self.result+=curr.importance
            for k in range(len(curr.subordinates)):
                dfs(curr.subordinates[k])
        dfs(id)
        return self.result
'''