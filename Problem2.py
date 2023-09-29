#time complexity:o(n), we query each of the employee
#space complexity: o(n), for the number of employees
#passed all cases on LeetCode:yes
# https://leetcode.com/problems/employee-importance/description/

class Solution:
    def getImportance(self, employees, id):
        emap = {e.id: e for e in employees}

        def dfs(eid):
            emp = emap[eid]
            return (emp.importance + sum(dfs(subid) for subid in emp.subordinates))
        
        return dfs(id)