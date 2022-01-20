# Time Complexity : O(N) [Worst Case when each employee is in subordinate tree of the target id]
# Space Complexity : O(N) [For the recursion stack (N) and for the map (N)]
# N = Number of employees in the list.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach



'''Recursive DFS Solution'''

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        def recur(emp):
            # base case: when emp does not have subordinates
            if not emp.subordinates:
                return emp.importance # if no subordinates then we can return current importance
            
            #logic
            currImp = 0
            for sub in emp.subordinates:
                currImp += recur(idMap[sub])   
            return currImp + emp.importance

        
        
        idMap = {} # subordinates is a list of int, we need a mapping to the employee object
        idFlag = False  # make sure employee with target id exists
        for emp in employees:
            idMap[emp.id] = emp
            if emp.id == id:
                idFlag = True
        
        totalImportance = 0
        if idFlag:
            totalImportance = recur(idMap[id])
        
        return totalImportance