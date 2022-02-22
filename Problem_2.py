# Time Complexity : O(N) 
# Space Complexity : O(N) 
# N = Number of employees in the list.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        def recur(emp):
            if not emp.subordinates:
                return emp.importance 
        
            currImp = 0
            for sub in emp.subordinates:
                currImp += recur(idMap[sub])   
            return currImp + emp.importance

        idMap = {} 
        idFlag = False  
        for emp in employees:
            idMap[emp.id] = emp
            if emp.id == id:
                idFlag = True
        
        totalImportance = 0
        if idFlag:
            totalImportance = recur(idMap[id])
        
        return totalImportance