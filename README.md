# BFS-2.1

## Problem 1

Rotting Oranges(https://leetcode.com/problems/rotting-oranges)

//Time Complexity = O(M*N)
//Time Complexity = O(M*N)

class Solution {
public int orangesRotting(int[][] grid) {
if(grid == null || grid.length == 0) {
return 0;
}
int m = grid.length;
int n = grid[0].length;
int fresh = 0;
int time = 0;

        Queue<Integer> queue = new LinkedList();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                } else if(grid[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        if(fresh == 0) {
            return 0;
        }
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

        while(!queue.isEmpty()) {
            int sz = queue.size();
            for(int i = 0; i < sz; i = i + 2) {

                int r = queue.poll();
                int c = queue.poll();

                for(int[] dir : dirs) {
                    int nR = dir[0] + r;
                    int nC = dir[1] + c;
                    if(nR >= 0 && nR < m && nC >= 0 && nC < n && grid[nR][nC] == 1) {
                        grid[nR][nC] = 2;
                        fresh--;
                        queue.add(nR);
                        queue.add(nC);
                    }
                }
            }
            time++;
        }
        if(fresh != 0) {
            return -1;
        } else {
            return time-1;
        }
    }

}

## Problem 2

Employee Impotance(https://leetcode.com/problems/employee-importance/)

//Time Complexity = O(e*s)
//Time Complexity = O(e*s)

/_
// Definition for Employee.
class Employee {
public int id;
public int importance;
public List<Integer> subordinates;
};
_/

class Solution {
public int getImportance(List<Employee> employees, int id) {
if(employees == null || employees.size() == 0) {
return 0;
}

        HashMap<Integer, Employee> employeeMap = new HashMap();

        for(Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        Queue<Integer> queue = new LinkedList();
        queue.add(id);
        int result = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();

            result += employeeMap.get(current).importance;

            for(Integer subordinate : employeeMap.get(current).subordinates) {
                queue.add(subordinate);
            }
        }
        return result;
    }

}
