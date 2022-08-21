# 690. Employee Importance

'''
Leetcode all test cases passed: Yes
Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        n is the no of employees
        w is width of the tree
        Time Complexity: O(n) 
        Space Complexity: O(w)
'''
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        result = 0
        adj_map = {}
        for employee in employees:
            adj_map[employee.id] = employee
        
        queue = collections.deque([adj_map[id]])
        
        while queue:
            curr = queue.popleft()
            result += curr.importance
            for sub in curr.subordinates:
                queue.append(adj_map[sub])
            
        return result
