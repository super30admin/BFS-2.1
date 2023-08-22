#Time Complexity : O(N) approx
# Space Complexity : O(N) space for map

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        map_emp = {}
        queue = []
        importance = 0
        for emp in employees:
            map_emp[emp.id] = emp
        

        if id in map_emp:
            queue.append(id)
        
        while len(queue) > 0 : 
            
            size = len(queue)

            for i in range(size):
                curr = queue.pop(0)
                print(curr)
                importance += map_emp[curr].importance
                subordinates = map_emp[curr].subordinates

                for j in range(len(subordinates)):
                    queue.append(subordinates[j])
        
        return importance
