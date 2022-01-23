class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if len(employees) == None: return 0
        maps = {}
        for i in employees:
            # print(i.subordinates)
            maps[i.id] = i
            
        q = []
        q.append(id)
        total = 0
        while q:
            eid = q.pop(0)
            obj = maps.get(eid)
            total += obj.importance
            for i in obj.subordinates:
                q.append(i)
                
        return total
            
# T.C=>O(n) => Since we traverse through all the nodes in a list
# S.C=>O(n) => Since all the values or subordinates might get added to the list as needed
# Approach => Here in hash map we store all the values for a particular employee its importance etc. So use bfs we interate through its subordinates and add all the necessary importance in it as required. 


#In context of graph we can say O(b + c)    