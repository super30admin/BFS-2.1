#time complexity:O(V+E) = O(V) where V is vertices starting from id and E is edges but here Vertices are greater hence O(V)
#space complexity:O(V) because thats what will be added to the q
#passed all cases on LeetCode:yes
#difficulty faced:
# comments:in the code
#https://leetcode.com/problems/employee-importance/
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: "List['Employee']", id: int) -> int:

        if employees == None or len(employees) == 0: return 0

        #need to maintain a lookup table bec input is a list
        #we dont want to iterate over this list everytime we need to find
        #importance of the employee or who are their reportees
        #key for lookup is id and value is whole data struct

        m1 = {}

        for emp in employees:
            m1[emp.id] = emp 

        #since id is already given we dont need to find root of bfs
        #we can start bfs from that id
        q = []
        total = 0
        q.append(id)

        while q:
            eid = q.pop(0)
            emp1 = m1[eid]
            total += emp1.importance
            #employee subordinates are already given as an array
            #they should be added to the que to be processed
            edges = emp1.subordinates
            if edges == None: continue
            for edge in edges:
                q.append(edge)
            
        return total


