#Time Complexity :o(mn)
# Space Complexity :o(n)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no , Here I used DFS approach.

class Solution:
    total=0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        employees = {em.id:em for em in employees}
        # DFS
        def dfs(em_id):
            if em_id not in employees:
                return
            self.total += employees[em_id].importance
            for i in employees[em_id].subordinates:
                dfs(i)
            return
        dfs(id)
        return self.total