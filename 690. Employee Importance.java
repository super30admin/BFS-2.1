class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        time, fresh = 0, 0
        
        ROWS, COLS = len(grid), len(grid[0])
        for r in range(ROWS):class Solution {
    //Adjecent List
    HashMap<Integer, Employee> map;
    int totalImportance;
    
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        
        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        // Want BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty()){
            int currEmployee = q.poll();
            Employee emp = map.get(currEmployee);
            totalImportance += emp.importance;
            if(emp.subordinates == null) continue;
            for(int sub : emp.subordinates){
                q.add(sub);
            }
        }
        return totalImportance;
     }
}
            for c in range(COLS):
                if grid[r][c] == 1:
                    fresh += 1
                if grid[r][c] == 2:
                    q.append([r, c])

        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while q and fresh > 0:
            for i in range(len(q)):
                r, c = q.popleft()
                for dr, dc in directions:
                    row, col = dr + r, dc + c

                    if(row < 0 or row == len(grid) or
                       col < 0 or col == len(grid[0]) or
                       grid[row][col] != 1):
                        continue

                    grid[row][col] = 2
                    q.append([row, col])
                    fresh -= 1
            time += 1
        return time if fresh == 0 else -1